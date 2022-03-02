package com.avangenio.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.avangenio.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    boolean foundFormat = false;

    String route, text, IDF, separator, format = "";
    List<Data> datas = new ArrayList<Data>();


    public FileUtils() {

    }

    public FileUtils(String route, String text, List<Data> datas, String IDF, String separator, String format) {
        this.route=route;
        this.text=text;
        this.datas=datas;
        this.IDF=IDF;
        this.separator=separator;
        this.format=format;
    
    }

    public String ReadFile() throws FileNotFoundException {
        String file = "";
            Scanner input = new Scanner(new File(route));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                file += line + "\n";
            }
            input.close();
        return file;
    }

    public Map<String, String> ReadBlock(String format) {
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

        } catch (FileNotFoundException e) {
            System.err.println("No data file");
        }
        if (file.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isFoundFormat() {
        return this.foundFormat;
    }

    public boolean getFoundFormat() {
        return this.foundFormat;
    }

    public void setFoundFormat(boolean foundFormat) {
        this.foundFormat = foundFormat;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIDF() {
        return this.IDF;
    }

    public void setIDF(String IDF) {
        this.IDF = IDF;
    }

    public String getSeparator() {
        return this.separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public List<Data> getDatas() {
        return this.datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    public void setFormat(String format) {
        this.format=format;
    }

    public String getFormat() {
        return this.format;
    }
}
