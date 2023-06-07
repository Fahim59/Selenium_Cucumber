package Real_Scenario.customtypes;

import Real_Scenario.domainobject.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterTypes {
    @ParameterType(".*")
    public Product product(String name){
        return new Product(name.replace("\"", ""));
    }
}
