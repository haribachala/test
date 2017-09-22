package com.play;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestFile {

    public static void main(String[] args)throws  Exception {

        String data  = "Hello";
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime timeStamp= currentTime.now();

        // File file = new File("C:\\Users\\U6015446\\Desktop\\searchResults\\SearchResultIds_"+timeStamp.now()+".csv");
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(timeStamp.toString(), formatter);
        System.out.println(dateTime);
        String fileTimeStamp  =dateTime.toString().replace(":", "_").replace(".","_");
        System.out.println(fileTimeStamp);
        File file = new File("C:\\Users\\U6015446\\Desktop\\searchResults\\searchResultIds_"+fileTimeStamp+".csv");

        try(FileOutputStream fos = new FileOutputStream(file)){
            PrintWriter w = new PrintWriter(fos);
            w.println(currentTime);
            w.println("");
            w.println("");
            w.println("");
            w.println(data);
            w.println("");

        }
    }
}
