package Real_Scenario.utils;

import Real_Scenario.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(String env) {
        switch (EnvType.valueOf(env)){
            case DEV:
                properties = PropertyUtils.propertyLoader("src/test/resources/dev_config.properties");
                break;

            case STAGE:
                properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
                break;

            default: throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader(System.getProperty("env", String.valueOf(EnvType.DEV)));
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the stage_config.properties file");
    }
}
