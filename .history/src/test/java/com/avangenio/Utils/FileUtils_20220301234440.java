package com.avangenio.Utils;

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
    public static String ReadBlock(String route) {
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
