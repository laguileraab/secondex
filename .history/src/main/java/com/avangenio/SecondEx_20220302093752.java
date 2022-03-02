package com.avangenio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.avangenio.Utils.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondEx {

    private static String[] args;

    @Autowired
    DataService dataService;

    public static void main(String[] args) {
        String logConfig = ".level=" + java.util.logging.Level.INFO + '\n';
logConfig += "handlers=java.util.logging.ConsoleHandler\n";
// ensure ConsoleHandler does not filter
logConfig += "java.util.logging.ConsoleHandler" + ".level=" + java.util.logging.Level.FINEST + '\n';

//set your custom levels
logConfig += "org.apache.cxf" + ".level=" + java.util.logging.Level.WARNING + "\n";

try {
  java.util.logging.LogManager.getLogManager().readConfiguration(new java.io.ByteArrayInputStream(logConfig.getBytes("UTF-8")));
  // no need to close ByteArrayInputStream -- it is a no-op
}
catch (IOException ioe) {
  System.err.println("cannot fully configure logging");
  ioe.printStackTrace();
}
        SecondEx.args = args;
        SpringApplication app = new SpringApplication(SecondEx.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setLogStartupInfo(false);
        app.run(args);
    }

    @PostConstruct
    public void init() {
        
        String filter = "";

        String text = "";
        Map<String, String> f1 = new HashMap<String, String>();
        Map<String, String> f2 = new HashMap<String, String>();

        // boolean foundFormat = false;
        // String format1 = "";
        // String format2 = "";

        List<Data> datas = new ArrayList<Data>();
        // String separator = "";
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
                    dataService.saveOrUpdateAll(datas);
                    System.out.println("TESST\n"+
                    "TESST\nTESST\nTESST\nTESST\nTESST\nTESST\nTESST\nTESST\nTESST\n"
                    +datas.get(0).getCity());
                    break;
            }
        }
    }
}
