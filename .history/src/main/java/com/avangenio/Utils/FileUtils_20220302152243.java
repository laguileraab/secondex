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

    public Map<String, String> ReadBlock() {
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

    public static List<Data> ReadFields(Map<String, String> f, String format, List<Data> datasP, String separator) {
        f.get(format).lines().forEach((line) -> {
            String[] dataSplit = line.split(separator);
            Data data = new Data(dataSplit[0].trim(), dataSplit[1].trim(), dataSplit[2].trim());
            datasP.add(data);
        });
        return datasP;
    }

    public static List<Data> FormatID(List<Data> datasP, String IDF) {
        datasP.forEach((data) -> {
            if (data.getId().matches(IDF)) {
                data.setId(data.getId().replace("-", ""));
            }
        });
        return datasP;
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

    public static FileUtils fetchData(FileUtils fileUtils, String route) throws FileNotFoundException {
        Map<String, String> f1 = new HashMap<String, String>();
        Map<String, String> f2 = new HashMap<String, String>();
        List<Data> datas = new ArrayList<Data>();
        List<Data> datasaux = new ArrayList<Data>();
        String IDF = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z]";
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
        fileUtils.setDatas(datas); // Clear data in fileUtils
        datas.addAll(FileUtils.FormatID(FileUtils.ReadFields(f2, "F2", datasaux, " ; "), IDF)); // Format id for f2                                                                          // format
        datas.addAll(FileUtils.ReadFields(f1, "F1", datasaux, ",")); // Add all objects found
        fileUtils.setDatas(datas); // Set data in fileUtils
        return fileUtils;
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
