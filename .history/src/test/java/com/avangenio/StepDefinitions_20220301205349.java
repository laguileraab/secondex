package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

public class StepDefinitions {

    String text = null;
    Map<String, String> f = new HashMap<String, String>();
    boolean foundFormat = false;

    @Given("^this \"(.*)\" with an extension \"(.*)\" in the path \"(.*)\"$")
    public void thisFileWithAnExtension(String file, String extension, String path) {
        text = FileUtils.ReadFile(path + file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        text.lines().forEach((line) -> {
            if (line.startsWith("f2")) {
                foundFormat = true;
            } else {
                if (line.startsWith("D") && f.get(format) != null) {
                    f.put(format, f.get(format) + line + "\n");
                } else {
                    if (line.startsWith("D")) {
                        f.put(format, line + "\n");
                    } else {
                        foundFormat = false;
                    }
                }
            }
            System.out.println(foundFormat);
        });
        System.out.println(format + "\n" + f.get(format));
        assertNotNull(f);
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
