package com.avangenio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

public class SecondEx {

    public static void main(String[] args) {

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
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch (key) {
                case "CITY":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
                            text = FileUtils.ReadFile(FileUtils.ReadFile("data.tmp"));
                            f1 = new FileUtils().ReadBlock(text, "F1");
                            f2 = new FileUtils().ReadBlock(text, "F2");
                            datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                            datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                            datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));
                            datas.forEach((data) -> {
                                if (data.getCity().equals(args[2])) {
                                    System.out.println(data.getName() + "," + data.getId());
                                }
                            });
                        // System.out.println(dataService.getDataByCity(nextKey));
                    }
                    break;
                case "ID":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
                        if (datas.isEmpty()) {
                            text = FileUtils.ReadFile(FileUtils.ReadFile("data.tmp"));
                            f1 = new FileUtils().ReadBlock(text, "F1");
                            f2 = new FileUtils().ReadBlock(text, "F2");
                            datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                            datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                            datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));

                        } else {

                        }
                        // System.out.println(dataService.getDataByCity(nextKey));
                    }
                    break;
                case "NAME":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
                        if (datas.isEmpty()) {
                            text = FileUtils.ReadFile(FileUtils.ReadFile("data.tmp"));
                            f1 = new FileUtils().ReadBlock(text, "F1");
                            f2 = new FileUtils().ReadBlock(text, "F2");
                            datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                            datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                            datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));

                        } else {

                        }
                        // System.out.println(dataService.getDataByCity(nextKey));
                    }
                    break;
                default:
                    text = FileUtils.ReadFile(key);
                    f1 = new FileUtils().ReadBlock(text, "F1");
                    f2 = new FileUtils().ReadBlock(text, "F2");
                    datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                    datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                    datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));
                    FileUtils.WriteFile(key);
                    break;
            }
        }
    }
}
