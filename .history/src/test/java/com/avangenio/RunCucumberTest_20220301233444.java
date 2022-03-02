package com.avangenio;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/avangenio")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    public static void main(String[] args) {
        String filter = "";
        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            String nextKey = "";
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch(key){
                case "CITY":

                break;
                case "ID":
                break;
                default:
                break;
            }
        }
    }
}
