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

    String text = "";
    Map<String, String> f = new HashMap<String, String>();
    boolean foundFormat = false;
    String format = "";
    List<Data> datas = new ArrayList<Data>();

    @Given("^this \"(.*)\" with an extension \"(.*)\" in the path \"(.*)\"$")
    public void thisFileWithAnExtension(String file, String extension, String path) {
        text = FileUtils.ReadFile(path + file + extension);
        assertNotNull(text);
    }

    @When("^found \"(.*)\"$")
    public void found(String format) {
        this.format = format;
        text.lines().forEach((line) -> {
            if (line.toLowerCase().startsWith(format.toLowerCase())) {
                foundFormat = true;
            } else {
                if (line.startsWith("D") && f.get(format) != null && foundFormat) {
                    line = line.substring(2);
                    f.put(format, f.get(format) + line + "\n");
                } else {
                    if (line.startsWith("D") && foundFormat) {
                        line = line.substring(2);
                        f.put(format, line + "\n");
                    } else {
                        foundFormat = false;
                    }
                }
            }
        });
        assertNotNull(f);
    }

    @Then("^divider is \"(.*)\"$")
    public void dividerIs(String separator) {

        f.get(format).lines().forEach((line) -> {
            System.out.println(line);
            String[] dataSplit = line.split(separator);
            System.out.println(dataSplit[0].trim());
            System.out.println(dataSplit[1].trim());
            System.out.println(dataSplit[2].trim());

            Data data = new Data(dataSplit[0].trim(), dataSplit[1].trim(), dataSplit[2].trim());
            datas.add(data);
        });

        assertEquals(separator, separator);
    }

    @And("^ID format must be like \"(.*)\"$")
    public void iDFormatMustBeLike(String IDF) {
        assertEquals(IDF, IDF);
    }
}
