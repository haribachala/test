package com.play;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class TestFile {

    public static void main(String[] args)throws  Exception {

        String data  = "Hello";
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime timeStamp= currentTime.now();

        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.csv'").format(new Date());
        File file = new File("C:\\Users\\U6015446\\Desktop\\searchResults\\"+fileName);

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
