package com.avangenio.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class FileUtils {
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
    public static Map<String,String> ReadBlock(String text,String format) {
        boolean foundFormat;
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
}
