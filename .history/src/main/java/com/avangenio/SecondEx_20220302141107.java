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
                    }
                    break;
                default:
                    try {
                        FileUtils.WriteFile(key);
                        fileUtils = fetchData(fileUtils, key);
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
        List<Data> datasAux = new ArrayList<Data>();

        if (route.equals("data.tmp")) {
            fileUtils.setRoute(route); // Set address for Tmp file
            String tmp = fileUtils.ReadFile(); // Read Tmp File
            route = tmp.substring(0, tmp.length() - 1); // Cut endline
        }
        fileUtils.setRoute(route); // Set file with Text
        fileUtils.setText(fileUtils.ReadFile()); // Read text from file
        fileUtils.setFormat("F1");
        f1 = fileUtils.ReadBlock(); // Read in format F1
        fileUtils.setFormat("F2");
        f2 = fileUtils.ReadBlock(); // Read in format f2
        datasAux.addAll(FileUtils.ReadFields(f2, "F2", datas, " ; ")); // Store in object data f2
        datas = FileUtils.FormatID(datasAux, "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]"); // Format id for f2
                                                                                                // format
        datas.addAll(FileUtils.ReadFields(f1, "F1", datas, ",")); // Add all objects found
        fileUtils.setDatas(datas); // Set data in fileUtils

        for (int j = 0; j < fileUtils.getDatas().size(); j++) {
            System.out.println(fileUtils.getDatas().get(j).getName() + ","
                    + fileUtils.getDatas().get(j).getId());
        }

        return fileUtils;
    }
}
