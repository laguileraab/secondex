package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.avangenio.Utils.File;

public class StepDefinitions {

    String text = null;

    @Given("^this \"(.*)\" with an extension \"(.*)\"$")
    public void thisFileWithAnExtensionP1(String file, String extension) {
        text = File.ReadFile(file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {

        assertEquals(format, format);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIs(String separator) {
        assertEquals(separator, separator);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLike(String IDF) {
        assertEquals(IDF, IDF);
    }
}
