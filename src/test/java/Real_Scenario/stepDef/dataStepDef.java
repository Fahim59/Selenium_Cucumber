package Real_Scenario.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class dataStepDef {
    @Given("Credentials are")
    public void credentialsAre(DataTable dataTable) {
        //List<String> creds = dataTable.values();
        List<String> creds = dataTable.row(0);

        System.out.println("UserName: " +creds.get(0));
        System.out.println("Password: " +creds.get(1));
    }
}
