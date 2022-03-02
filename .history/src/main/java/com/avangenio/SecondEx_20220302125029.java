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
                            }for(int j =0;j<datas.size();j++){
                                if (data.getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                    if (dataShow.contains(data.getCity())) {
                                        System.out.println(data.getName() + "," + data.getId());
                                        dataShow.add(data.getCity());
                                    }
                                }
                            }
                            List<String> dataShow = new ArrayList<String>();
                        } catch (FileNotFoundException e) {

                        }
                    }
                    break;
                case "ID":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
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
                            datas.forEach((data) -> {
                                if (args.length < 3) {
                                    if (data.getId().toUpperCase().equals(args[1].toUpperCase())) {
                                        if (dataShow.contains(data.getId())) {
                                            System.out.println(data.getCity());
                                            dataShow.add(data.getId());
                                        }
                                    }
                                } else {
                                    if (args.length == 3) {
                                        if (data.getId().toUpperCase().equals(args[2].toUpperCase())) {
                                            if (dataShow.contains(data.getId())) {
                                                System.out.println(data.getCity());
                                                dataShow.add(data.getId());
                                            }
                                        }
                                    }
                                }
                            });
                        } catch (FileNotFoundException e) {

                        }
                    }
                    break;
                case "NAME":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No Data");
                        System.exit(0);
                    } else {
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
                            datas.forEach((data) -> {
                                if (args.length < 3) {
                                    if (data.getName().toUpperCase().equals(args[1].toUpperCase())) {
                                        if (dataShow.contains(data.getName())) {
                                            System.out.println(data.getCity());
                                            dataShow.add(data.getName());
                                        }
                                    }
                                } else {
                                    if (args.length == 3) {
                                        if (data.getName().toUpperCase().equals(args[2].toUpperCase())) {
                                            if (dataShow.contains(data.getName())) {
                                                System.out.println(data.getCity());
                                                dataShow.add(data.getName());
                                            }
                                        }
                                    }
                                }
                            });
                        } catch (FileNotFoundException e) {

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
