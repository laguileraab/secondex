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
    public static Map<String,String> ReadBlock(String text,String format,int foundFormat) {
        Map<String, String> f = new HashMap<String, String>();
        text.lines().forEach((line) -> {
            if (line.toLowerCase().startsWith(format.toLowerCase())) {
                foundFormat = 1;
            } else {
                if (line.startsWith("D") && f.get(format) != null && foundFormat == 0) {
                    line = line.substring(2);
                    f.put(format, f.get(format) + line + "\n");
                } else {
                    if (line.startsWith("D") && foundFormat == 1) {
                        line = line.substring(2);
                        f.put(format, line + "\n");
                    } else {
                        foundFormat = 0;
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
