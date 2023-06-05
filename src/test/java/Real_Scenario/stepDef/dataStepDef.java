package Real_Scenario.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class dataStepDef {

    @Given("Single row with no header Credentials are")
    public void singleRowWithNoHeaderCredentialsAre(DataTable dataTable) {
        //List<String> creds = dataTable.values();
        List<String> creds = dataTable.row(0);

        System.out.println("UserName: " +creds.get(0));
        System.out.println("Password: " +creds.get(1));
    }

    @Given("Multiple rows with no header Credentials are")
    public void multipleRowsWithNoHeaderCredentialsAre(List<List<String>> creds) {

        System.out.println("Row 0's UserName: " +creds.get(0).get(0));
        System.out.println("Row 0's Password: " +creds.get(0).get(1));

        System.out.println("Row 1's UserName: " +creds.get(1).get(0));
        System.out.println("Row 1's Password: " +creds.get(1).get(1));
    }
}
