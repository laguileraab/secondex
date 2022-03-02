package com.avangenio;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/avangenio")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    public static void main(String[] args) {
        String filter = "";

        String text = "";
        Map<String, String> f1 = new HashMap<String, String>();
        Map<String, String> f2 = new HashMap<String, String>();

        //boolean foundFormat = false;
        //String format1 = "";
        //String format2 = "";

        List<Data> datas = new ArrayList<Data>();
        //String separator = "";

        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            String nextKey = "";
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch (key) {
                case "CITY":
                    System.out.println(datas);
                    break;
                case "ID":
                    break;
                default:
                    text = FileUtils.ReadFile(key);
                    f1 = new FileUtils().ReadBlock(text, "F1");
                    f2 = new FileUtils().ReadBlock(text, "F2");
                    datas = FileUtils.ReadFields(f1, "F1", datas, ",");
                    FileUtils.ReadFields(f2, "F2", datas, " ; ");
                    datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                    break;
            }
        }
    }
}
