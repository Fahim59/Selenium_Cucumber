package utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ExcelPlugin implements ConcurrentEventListener {
    private Workbook workbook;
    private Sheet sheet;
    private int rowIndex;
    private Map<String, Integer> scenarioStepCounts;
    private Map<String, Integer> scenarioPassedSteps;
    private Map<String, Integer> scenarioFailedSteps;
    private Map<String, String> scenarioStatuses;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, this::handleTestRunStarted);
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::handleTestRunFinished);
    }

    private void handleTestRunStarted(TestRunStarted event) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Results");
        rowIndex = 0;

        scenarioStepCounts = new HashMap<>();
        scenarioPassedSteps = new HashMap<>();
        scenarioFailedSteps = new HashMap<>();
        scenarioStatuses = new HashMap<>();

        Row headerRow = sheet.createRow(rowIndex++);

        headerRow.createCell(0).setCellValue("Scenario Name");
        headerRow.createCell(1).setCellValue("Scenario Step");
        headerRow.createCell(2).setCellValue("Passed Step");
        headerRow.createCell(3).setCellValue("Failed Step");
        headerRow.createCell(4).setCellValue("Status");
        headerRow.createCell(5).setCellValue("Execution Date");
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        String scenarioName = event.getTestCase().getName();
        scenarioStepCounts.put(scenarioName, 0);
        scenarioPassedSteps.put(scenarioName, 0);
        scenarioFailedSteps.put(scenarioName, 0);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        String scenarioName = event.getTestCase().getName();
        String status = "";

        if (event.getTestStep() instanceof PickleStepTestStep) {
            int stepCount = scenarioStepCounts.getOrDefault(scenarioName, 0);
            scenarioStepCounts.put(scenarioName, stepCount + 1);

            if (event.getResult().getStatus() == Status.PASSED) {
                status = "Passed";

                int passedCount = scenarioPassedSteps.getOrDefault(scenarioName, 0);
                scenarioPassedSteps.put(scenarioName, passedCount + 1);
            }
            else if(event.getResult().getStatus() == Status.FAILED){
                status = "Failed";

                int failedCount = scenarioFailedSteps.getOrDefault(scenarioName, 0);
                scenarioFailedSteps.put(scenarioName, failedCount + 1);
            }

            int failedCount = scenarioFailedSteps.getOrDefault(scenarioName, 0);

            if (failedCount > 0) {
                status = "Failed";
            }

            scenarioStatuses.put(scenarioName, status);
        }
    }

    private void handleTestRunFinished(TestRunFinished event) {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        for (String scenarioName : scenarioStepCounts.keySet()) {
            int stepCount = scenarioStepCounts.get(scenarioName);
            int passedCount = scenarioPassedSteps.getOrDefault(scenarioName, 0);
            int failedCount = scenarioFailedSteps.getOrDefault(scenarioName, 0);

            String status = scenarioStatuses.getOrDefault(scenarioName, "Skipped");

            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(scenarioName);
            dataRow.createCell(1).setCellValue(stepCount);
            dataRow.createCell(2).setCellValue(passedCount);
            dataRow.createCell(3).setCellValue(failedCount);
            dataRow.createCell(4).setCellValue(status);
            dataRow.createCell(5).setCellValue(currentDate);

            CellStyle cellStyle = workbook.createCellStyle();

            if (status.equals("Passed")) {
                cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            }
            else if (status.equals("Failed")) {
                cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            }

            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            dataRow.getCell(4).setCellStyle(cellStyle);
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);

        try (FileOutputStream fileOutputStream = new FileOutputStream("E:\\Intellij Files\\Excel Files\\Test_Result.xlsx")) {
            workbook.write(fileOutputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}