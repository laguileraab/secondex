package com.avangenio.Utils;

import java.util.Scanner;

public class File {
    public static String ReadFile(String route){
        String file = null;
        try{
            Scanner input = new Scanner(new File(route));
            while(input.hasNextLine()){
                String line = input.nextLine();
                file += line;
            }
        }catch(Exception e){

        }
        return file;
    }
}
