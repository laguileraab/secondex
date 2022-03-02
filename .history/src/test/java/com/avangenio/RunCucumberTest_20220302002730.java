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
        Map<String, String> f = new HashMap<String, String>();
        boolean foundFormat = false;
        String format = "";
        List<Data> datas = new ArrayList<Data>();
        String separator = "";


        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            String nextKey = "";
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch(key){
                case "CITY":
                System.out.println(datas);
                break;
                case "ID":
                break;
                default:
                text = FileUtils.ReadFile(key);
                f = new FileUtils().ReadBlock(text, format);
                datas = FileUtils.ReadFields(f, format, datas, separator);
                datas = FileUtils.FormatID(datas,IDF);
                break;
            }
        }
    }
}
