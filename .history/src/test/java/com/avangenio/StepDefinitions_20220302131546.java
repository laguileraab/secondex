package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

public class StepDefinitions {

    String text = "";
    Map<String, String> f = new HashMap<String, String>();
    boolean foundFormat = false;
    String format = "";
    List<Data> datas = new ArrayList<Data>();
    String separator = "";
    FileUtils fileUtils = new FileUtils();

    @Given("^this \"(.*)\" with an extension \"(.*)\" in the path \"(.*)\"$")
    public void thisFileWithAnExtension(String file, String extension, String path) throws FileNotFoundException {
        fileUtils.setRoute(path + file + extension);
        text = fileUtils.ReadFile();
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        this.format = format;
        f = new FileUtils().ReadBlock(text, format);
        assertNotNull(f);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIs(String separator) {
        this.separator = separator;
        datas = FileUtils.ReadFields(f, format, datas, separator);
        assertNotNull(datas);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLike(String IDF) {
        f.get(format).lines().forEach((line) -> assertTrue(line.matches("(.*)" + IDF)));
        datas = FileUtils.FormatID(datas,IDF);
    }
}
