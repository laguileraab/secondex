package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    @Given("^this file with an extension \"(.*)\"$")
    public void thisFileWithAnExtensionP1(String extension) {
        System.out.println(extension);
    }

    @When("^found \"(.*)\"$")
    public void foundP1(String format) {
        System.out.println(format);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIsP1(String separator) {
        System.out.println(separator);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLikeP1(String IDF) {
assertEquals(1, IDF);;    }
}
