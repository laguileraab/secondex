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
                        String tmp = FileUtils.ReadFile("data.tmp");
                        tmp = tmp.substring(0,tmp.length()-1);
                        text = FileUtils.ReadFile(tmp);
                        f1 = new FileUtils().ReadBlock(text, "F1");
                        f2 = new FileUtils().ReadBlock(text, "F2");
                        datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; "));
                        datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]");
                        datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ","));
                        if (datas.isEmpty()) {
                            System.err.println("No data");
                            System.exit(0);
                        }
                        datas.forEach((data) -> {
                            if (args.length < 3) {
                                if (data.getCity().equals(args[1])) {
                                    System.out.println(data.getName() + "," + data.getId());
                                }
                            } else {
                                if (args.length == 3) {
                                    if (data.getCity().equals(args[2])) {
                                        System.out.println(data.getName() + "," + data.getId());
                                    }
                                }
                            }
                        });
                    }
                    break;
                case "ID":
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
                        if (datas.isEmpty()) {
                            System.err.println("No data");
                            System.exit(0);
                        }
                        datas.forEach((data) -> {
                            if (args.length < 3) {
                                if (data.getId().equals(args[1])) {
                                    System.out.println(data.getCity());
                                }
                            } else {
                                if (args.length == 3) {
                                    if (data.getId().equals(args[2])) {
                                        System.out.println(data.getCity());
                                    }
                                }
                            }
                        });
                    }
                    break;
                case "NAME":
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
                        if (datas.isEmpty()) {
                            System.err.println("No data");
                            System.exit(0);
                        }
                        datas.forEach((data) -> {
                            if (args.length < 3) {
                                if (data.getCity().equals(args[1])) {
                                    System.out.println(data.getCity());
                                }
                            } else {
                                if (args.length == 3) {
                                    if (data.getCity().equals(args[2])) {
                                        System.out.println(data.getCity());
                                    }
                                }
                            }
                        });
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
                    if (datas.isEmpty()) {
                        System.err.println("No data");
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}
