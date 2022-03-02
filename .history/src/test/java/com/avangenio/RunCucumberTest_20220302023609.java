package com.avangenio;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@SpringBootApplication
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/avangenio")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

}
