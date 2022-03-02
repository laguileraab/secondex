package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    @Given("^this file with an extension \"(.*)\"$")
    public void thisFileWithAnExtensionP1(String extension) {
        String file = File.ReadFile(extension);



        assertEquals(extension, extension);
    }

    @When("^found \"(.*)\"$")
    public void foundP1(String format) {
        assertEquals(format, format);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIsP1(String separator) {
        assertEquals(separator, separator);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLikeP1(String IDF) {
        assertEquals(IDF, IDF);
    }
}
