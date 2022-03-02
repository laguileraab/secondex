package com.avangenio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Given("^this \"(.*)\" with an extension \"(.*)\" in the path \"(.*)\"$")
    public void thisFileWithAnExtension(String file, String extension, String path) {
        text = FileUtils.ReadFile(path + file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        this.format = format;
        f = FileUtils.ReadBlock(text, format);
        assertNotNull(f);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIs(String separator) {
        this.separator = separator;
        f.get(format).lines().forEach((line) -> {
            String[] dataSplit = line.split(separator);
            Data data = new Data(dataSplit[0].trim(), dataSplit[1].trim(), dataSplit[2].trim());
            datas.add(data);
        });
        assertNotNull(datas);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLike(String IDF) {
        f.get(format).lines().forEach((line) -> assertTrue(line.matches("(.*)" + IDF)));
        datas.forEach((data) -> {
            if (data.getId().matches(IDF)) {
                data.setId(data.getId().replace("-", ""));
            }
        });
    }
}
