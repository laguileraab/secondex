package com.avangenio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avangenio.Utils.FileUtils;

public class SecondEx {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        String nextKey = "";

        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            try {
                nextKey = args[i + 1];
            } catch (Exception e) {
            }
            switch (key.toUpperCase()) {
                case "CITY":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No data");
                        System.exit(0);
                    } else {
                        if (fileUtils.getDatas().isEmpty()) {
                            try {
                                fileUtils = fetchData(fileUtils, "data.tmp");

                                if (fileUtils.getDatas().isEmpty()) {
                                    System.err.println("No data");
                                    System.exit(0);
                                }
                                List<String> dataShow = new ArrayList<String>();
                                for (int j = 0; j < fileUtils.getDatas().size(); j++) {
                                    if (fileUtils.getDatas().get(j).getCity().toUpperCase()
                                            .equals(nextKey.toUpperCase())) {
                                        // if (dataShow.contains(datas.get(j).getCity())) {
                                        System.out.println(fileUtils.getDatas().get(j).getName() + ","
                                                + fileUtils.getDatas().get(j).getId());
                                        // dataShow.add(datas.get(j).getCity());
                                        // }
                                    }
                                }
                            } catch (FileNotFoundException e) {

                            }
                        } else {
                            for (int j = 0; j < fileUtils.getDatas().size(); j++) {
                                if (fileUtils.getDatas().get(j).getCity().toUpperCase().equals(nextKey.toUpperCase())) {
                                    // if (dataShow.contains(datas.get(j).getCity())) {
                                    System.out.println(fileUtils.getDatas().get(j).getName() + ","
                                            + fileUtils.getDatas().get(j).getId());
                                    // dataShow.add(datas.get(j).getCity());
                                    // }
                                }
                            }
                        }
                    }
                    break;
                default:
                    try {
                        fileUtils = fetchData(fileUtils, key);
                        FileUtils.WriteFile(key);
                        if (fileUtils.getDatas().isEmpty()) {
                            System.err.println("No data");
                            System.exit(0);
                        }
                    } catch (FileNotFoundException e) {

                    }
                    break;
            }
        }
    }

    private static FileUtils fetchData(FileUtils fileUtils, String route) throws FileNotFoundException {
        Map<String, String> f1 = new HashMap<String, String>();
        Map<String, String> f2 = new HashMap<String, String>();
        List<Data> datas = new ArrayList<Data>();

        fileUtils.setRoute(route); // Set address for Tmp file
        String tmp = fileUtils.ReadFile(); // Read Tmp File
        tmp = tmp.substring(0, tmp.length() - 1); // Cut endline
        fileUtils.setRoute(tmp); // Set file with Text
        fileUtils.setText(fileUtils.ReadFile()); // Read text from file
        f1 = fileUtils.ReadBlock("F1"); // Read in format F1
        f2 = fileUtils.ReadBlock("F2"); // Read in format f2
        datas.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; ")); // Store in object data f2
        datas = FileUtils.FormatID(datas, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]"); // Format id for f2 format
        datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ",")); // Add all objects found
        fileUtils.setDatas(datas); // Set data in fileUtils
        return fileUtils;
    }
}
