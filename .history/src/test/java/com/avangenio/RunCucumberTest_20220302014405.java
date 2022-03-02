package com.avangenio;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.avangenio.Utils.FileUtils;


@SpringBootApplication
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/avangenio")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    private static String[] args;
    @Autowired
    DataService dataService;
    
    public static void main(String[] args) {
        RunCucumberTest.args = args;
        SpringApplication.run(RunCucumberTest.class, args);
    }
    
    @PostConstruct
    public void init() {
        String city=zipCodeLookupService.retriveCityForZip(args[0]);
        System.out.println("city for zipcode " + args[0] + " is " +city); 

        String filter = "";

        String text = "";
        Map<String, String> f1 = new HashMap<String, String>();
        Map<String, String> f2 = new HashMap<String, String>();

        //boolean foundFormat = false;
        //String format1 = "";
        //String format2 = "";

        List<Data> datas = new ArrayList<Data>();
        //String separator = "";
        String nextKey = "";
        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            nextKey = "";
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch (key) {
                case "CITY":
                    System.out.println();
                    break;
                case "ID":
                    break;
                default:
                    text = FileUtils.ReadFile(key);
                    f1 = new FileUtils().ReadBlock(text, "F1");
                    f2 = new FileUtils().ReadBlock(text, "F2");
                    datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                    datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                    datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));
                    
                    break;
            }
        }
    }
}
