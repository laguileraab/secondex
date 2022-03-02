package com.avangenio;

import java.io.FileNotFoundException;
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
        List<Data> datas = new ArrayList<Data>();
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
                        if (datas.isEmpty()) {
                            try {
                                String tmp = FileUtils.ReadFile("data.tmp");
                                tmp = tmp.substring(0, tmp.length() - 1);
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
                                List<String> dataShow = new ArrayList<String>();
                                for (int j = 0; j < datas.size(); j++) {
                                    if (datas.get(j).getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                        // if (dataShow.contains(datas.get(j).getCity())) {
                                        System.out.println(datas.get(j).getName() + "," + datas.get(j).getId());
                                        // dataShow.add(datas.get(j).getCity());
                                        // }
                                    }
                                }
                            } catch (FileNotFoundException e) {

                            }
                        } else {
                            for (int j = 0; j < datas.size(); j++) {
                                if (datas.get(j).getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                    // if (dataShow.contains(datas.get(j).getCity())) {
                                    System.out.println(datas.get(j).getName() + "," + datas.get(j).getId());
                                    // dataShow.add(datas.get(j).getCity());
                                    // }
                                }
                            }
                        }
                    }
                    break;
                case "ID":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
                        if (datas.isEmpty()) {

                            try {
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
                                List<String> dataShow = new ArrayList<String>();
                                for (int j = 0; j < datas.size(); j++) {
                                    if (datas.get(j).getId().toUpperCase().equals(nextKey.toUpperCase())) {
                                        // if (dataShow.contains(datas.get(j).getCity())) {
                                        System.out.println(datas.get(j).getCity());
                                        // dataShow.add(datas.get(j).getCity());
                                        // }
                                    }
                                }
                            } catch (FileNotFoundException e) {

                            }
                        } else {
                            for (int j = 0; j < datas.size(); j++) {
                                if (datas.get(j).getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                    // if (dataShow.contains(datas.get(j).getCity())) {
                                    System.out.println(datas.get(j).getName() + "," + datas.get(j).getId());
                                    // dataShow.add(datas.get(j).getCity());
                                    // }
                                }
                            }
                        }
                    }
                    break;
                case "NAME":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
                        if (datas.isEmpty()) {

                            try {
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
                                List<String> dataShow = new ArrayList<String>();
                                for (int j = 0; j < datas.size(); j++) {
                                    if (datas.get(j).getName().toUpperCase().equals(nextKey.toUpperCase())) {
                                        // if (dataShow.contains(datas.get(j).getCity())) {
                                        System.out.println(datas.get(j).getCity());
                                        // dataShow.add(datas.get(j).getCity());
                                        // }
                                    }
                                }
                            } catch (FileNotFoundException e) {

                            }
                        } else {
                            for (int j = 0; j < datas.size(); j++) {
                                if (datas.get(j).getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                    // if (dataShow.contains(datas.get(j).getCity())) {
                                    System.out.println(datas.get(j).getName() + "," + datas.get(j).getId());
                                    // dataShow.add(datas.get(j).getCity());
                                    // }
                                }
                            }
                        }
                    }
                    break;
                default:
                    try {
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
                    } catch (FileNotFoundException e) {

                    }
                    break;
            }
        }
    }
}
