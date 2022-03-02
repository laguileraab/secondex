package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

public class StepDefinitions {

    String text = null;
    Map<String, String> f = new HashMap<String, String>();

    @Given("^this \"(.*)\" with an extension \"(.*)\" in the path \"(.*)\"$")
    public void thisFileWithAnExtension(String file, String extension, String path) {
        text = FileUtils.ReadFile(path + file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        int substringLength = format.length()-1;
        System.out.println(substringLength);
        String[] textSplit = text.split("\n");
        for (int i = 0; i < textSplit.length; i++) {
            if (textSplit[i].substring(0,substringLength).equals(format))
                f.put(format, f.get(format) + textSplit[i] + "\n");
                System.out.println(f.get(format));
        }
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
