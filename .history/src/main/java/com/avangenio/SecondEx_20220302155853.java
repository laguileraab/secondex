package com.avangenio;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
                            if (args.length == 2)
                                fileUtils = FileUtils.fetchData(fileUtils, "data.tmp");

                            if (fileUtils.getDatas().isEmpty()) {
                                System.err.println("No data");
                                System.exit(0);
                            }
                            for (int j = 0; j < fileUtils.getDatas().size(); j++) {
                                if (fileUtils.getDatas().get(j).getCity().toUpperCase()
                                        .equals(nextKey.toUpperCase())) {
                                    System.out.println(fileUtils.getDatas().get(j).getName() + ","
                                            + fileUtils.getDatas().get(j).getId());
                                }
                            }} catch (FileNotFoundException e) {}
                    }
                    break;
                    case "ID":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No data");
                        System.exit(0);
                    } else {
                        try {
                            if (args.length == 2)
                                fileUtils = FileUtils.fetchData(fileUtils, "data.tmp");

                            if (fileUtils.getDatas().isEmpty()) {
                                System.err.println("No data");
                                System.exit(0);
                            }
                            List<String> citiesVisited = new ArrayList<String>();
                            for (int j = 0; j < fileUtils.getDatas().size(); j++) {
                                if (fileUtils.getDatas().get(j).getId().toUpperCase()
                                        .equals(nextKey.toUpperCase())) {
                                            if(citiesVisited.isEmpty() | !citiesVisited.get(j).contains(nextKey))
                                    System.out.println(fileUtils.getDatas().get(j).getCity());
                                }
                            }} catch (FileNotFoundException e) {}
                    }
                    break;
                    case "NAME":
                    if (FileUtils.DataisEmpty()) {
                        System.err.println("No data");
                        System.exit(0);
                    } else {
                        try {
                            if (args.length == 2)
                                fileUtils = FileUtils.fetchData(fileUtils, "data.tmp");

                            if (fileUtils.getDatas().isEmpty()) {
                                System.err.println("No data");
                                System.exit(0);
                            }
                            for (int j = 0; j < fileUtils.getDatas().size(); j++) {
                                if (fileUtils.getDatas().get(j).getName().toUpperCase()
                                        .equals(nextKey.toUpperCase())) {
                                    System.out.println(fileUtils.getDatas().get(j).getCity());
                                }
                            }} catch (FileNotFoundException e) {}
                    }
                    break;
                default:
                    if (i == 0) {
                        try {
                            FileUtils.WriteFile(key);
                            fileUtils = FileUtils.fetchData(fileUtils, key);
                            if (fileUtils.getDatas().isEmpty()) {
                                System.err.println("No data");
                                System.exit(0);
                            }
                        } catch (FileNotFoundException e) {
                        }
                    }
                    break;
            }
        }

    }
}
