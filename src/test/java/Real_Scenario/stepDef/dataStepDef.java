package Real_Scenario.stepDef;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

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

    @Given("Single row with header, Credentials are")
    public void singleRowWithHeaderCredentialsAre(List<Map<String, String>> creds) {
        System.out.println("Username: " +creds.get(0).get("username"));
        System.out.println("Password: " +creds.get(0).get("password"));
    }

    @Given("Multiple rows with header, Credentials are")
    public void multipleRowsWithHeaderCredentialsAre(List<Map<String, String>> creds) {
        System.out.println("Row 0's UserName: " +creds.get(0).get("username"));
        System.out.println("Row 0's Password: " +creds.get(0).get("password"));

        System.out.println("Row 1's UserName: " +creds.get(1).get("username"));
        System.out.println("Row 1's Password: " +creds.get(1).get("password"));
    }

    @Given("Single column with no header, Credentials are")
    public void singleColumnWithNoHeaderCredentialsAre(List<String> cred) {
        System.out.println("Username: " +cred.get(0));
        System.out.println("Password: " +cred.get(1));
    }

    @Given("Single column with header, Credentials are")
    public void singleColumnWithHeaderCredentialsAre(Map<String, String> cred) {
        System.out.println("Username: " +cred.get("username"));
        System.out.println("Password: " +cred.get("password"));
    }

    @Given("Multiple columns with no header Credentials are")
    public void multipleColumnsWithNoHeaderCredentialsAre(List<List<String>> creds) {
        System.out.println("Row 0's UserName: " +creds.get(0).get(0));
        System.out.println("Row 0's Password: " +creds.get(1).get(0));

        System.out.println("Row 1's UserName: " +creds.get(0).get(1));
        System.out.println("Row 1's Password: " +creds.get(1).get(1));
    }
}
