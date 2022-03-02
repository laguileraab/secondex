package com.avangenio.Utils;

import java.util.Scanner;

public class File {
    public static String ReadFile(String route){
        String file = null;
        try{
            Scanner input = new Scanner(new File(route));
        }catch(Exception e){

        }
        return file;
    }
}
