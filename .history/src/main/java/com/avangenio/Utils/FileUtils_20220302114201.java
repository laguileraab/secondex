package com.avangenio.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.avangenio.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    boolean foundFormat = false;

    public FileUtils() {

    }

    public static String ReadFile(String route) {
        String file = "";
        try {
            Scanner input = new Scanner(new File(route));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                file += line + "\n";
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public Map<String, String> ReadBlock(String text, String format) {
        Map<String, String> f = new HashMap<String, String>();
        text.lines().forEach((line) -> {
            if (line.toLowerCase().startsWith(format.toLowerCase())) {
                foundFormat = true;
            } else {
                if (line.startsWith("D") && f.get(format) != null && foundFormat) {
                    line = line.substring(2);
                    f.put(format, f.get(format) + line + "\n");
                } else {
                    if (line.startsWith("D") && foundFormat) {
                        line = line.substring(2);
                        f.put(format, line + "\n");
                    } else {
                        foundFormat = false;
                    }
                }
            }
        });
        return f;
    }

    public static List<Data> ReadFields(Map<String, String> f, String format, List<Data> datas, String separator) {
        f.get(format).lines().forEach((line) -> {
            String[] dataSplit = line.split(separator);
            Data data = new Data(dataSplit[0].trim(), dataSplit[1].trim(), dataSplit[2].trim());
            datas.add(data);
        });
        return datas;
    }

    public static List<Data> FormatID(List<Data> datas, String IDF) {
        datas.forEach((data) -> {
            if (data.getId().matches(IDF)) {
                data.setId(data.getId().replace("-", ""));
            }
        });
        return datas;
    }

    public static void WriteFile(String key) {
        try {
			File file = new File("data.tmp");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(key);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static boolean DataisEmpty() {
        String file = "";
        try {
            Scanner input = new Scanner(new File("data.tmp"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                file += line + "\n";
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
