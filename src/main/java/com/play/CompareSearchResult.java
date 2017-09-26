package com.play;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareSearchResult {
    public static void main(String[] args) throws  Exception {

        List<String> list1= new ArrayList<>();
        List<String> list2= new ArrayList<>();



        try (BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\U6015446\\Desktop\\searchResults\\searchResultIds_2017-09-25T18_11_29_275.csv"))){
            String recordId;
          while ( (recordId = bufferedReader.readLine())!=null){
              List<String> recordList = Arrays.asList(recordId.split(";"));
               list1.addAll(recordList);
          }

        }

        try (BufferedReader bufferedReader2=new BufferedReader(new FileReader("C:\\Users\\U6015446\\Desktop\\searchResults\\searchResultIds_2017-09-24T07_14_43_973.csv"))){
            String recordId2;
            while ( (recordId2 = bufferedReader2.readLine())!=null){
                List<String> recordList2 = Arrays.asList(recordId2.split(";"));
                list2.addAll(recordList2);
            }

        }
        List<String> dropIns = new ArrayList<>(list1);
        List<String> dropOuts = new ArrayList<>(list2);
        dropIns.removeAll(list2);
        dropOuts.removeAll(list1);



        System.out.println("DropIns::" + dropIns);
        System.out.println("No. of DropIns Are :: " + dropIns.size());
        System.out.println("DropOuts::" +dropOuts);
        System.out.println("No. of Dropouts Are :: " + dropOuts.size());

    }
}
