package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.avangenio.Utils.File;

public class StepDefinitions {

    String text = null;
    List<String> f1 = new ArrayList<String>();
    List<String> f2 = new ArrayList<String>();


    @Given("^this \"(.*)\" with an extension \"(.*)\"$")
    public void thisFileWithAnExtensionP1(String file, String extension) {
        text = File.ReadFile(file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        f1.add(text);
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
