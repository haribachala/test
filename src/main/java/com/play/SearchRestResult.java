package com.play;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SearchRestResult {
    private static int searchResultCount=0;
    private  static int countOfIds=0;

    public static void main(String[] args) {
        HttpClient client;
        try{

            long startTime=  System.currentTimeMillis();
            HttpParams httpParameters = new BasicHttpParams();
            // Set the timeout in milliseconds until a connection is established.
            int timeoutConnection = 120000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
            // Set the default socket timeout (SO_TIMEOUT)
            // in milliseconds which is the timeout for waiting for data.
            int timeoutSocket = 120000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
            client = new DefaultHttpClient(httpParameters);

            String response =  sendGET(prepareGetrequest(),client);

            SearchOutput searchOutput = convertToSearchOutput(response);
            searchResultCount  = searchOutput.getPagedResults().getTotal();

            if(searchResultCount >0) {
              String  responseString= callSearchSecondTime(prepareGetrequest(),client);
                SearchOutput actualSearchOutput = convertToSearchOutput(responseString);
                SearchResult actualSearchResult = convertToSearchResult(actualSearchOutput);
                writeSearchResultToFile(searchResultIds(actualSearchResult));
            }
            else {
                System.out.println("Search Service Doesn't return any data");
            }
            System.out.println("Program Execution finished...");

            long endTime=  System.currentTimeMillis();
            long executionTime = endTime-startTime;

            System.out.println("Program Execution finished in " + executionTime/(60*1000) + " min(s)");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static  String prepareGetrequest() {
        return "http://localhost:8335/mr/RestSearchService/v4/search?offset=0&returnLimit=1&searchQuery=cancer&queryLanguage=uiql&returnFields=patentFamilyId&dataset=patentFamily(breadth%3D%22extended%22)&sortBy=none";
    }
    private static String  sendGET(String request, HttpClient client) throws Exception {
        HttpGet getRequest =null;
        getRequest = new HttpGet(request.toString());
        HttpResponse response = client.execute(getRequest);
        String  responseString=  convertStreamToString(response);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Http Response Code: "+responseCode);
        Thread.sleep(60*300);
        return responseString;

    }
    private static String convertStreamToString(HttpResponse response) throws  Exception{
        String finalResult ;
        try( BufferedReader rd = new BufferedReader(new InputStreamReader( response.getEntity().getContent())))
        {
           StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            finalResult= result.toString();
    }
        return finalResult;
    }
    private static Set<String> extractIds(SearchOutput searchOutput) {
        if (searchOutput != null && searchOutput.getPagedResults() != null) {
            List<RowOutput> rows = searchOutput.getPagedResults().getResult();
            return rows == null ? Collections.emptySet() : selectIdsFromRowOutput(rows);
        } else {
            return Collections.emptySet();
        }
    }

    private static Set<String> selectIdsFromRowOutput(List<RowOutput> rows) {
        Set<String> searchIds = new HashSet();
        Iterator var3 = rows.iterator();

        while(var3.hasNext()) {
            RowOutput row = (RowOutput)var3.next();
            List<FieldOutput> fields = row.getField();
            Iterator var6 = fields.iterator();

            while(var6.hasNext()) {
                FieldOutput field = (FieldOutput)var6.next();
                searchIds.add(field.getValue());
            }
        }
        countOfIds =searchIds.size();
        System.out.println("count of Ids: "+countOfIds);
        return searchIds;
    }

       private  static String callSearchSecondTime(String request, HttpClient client ) throws  Exception{

                  String requestWithTotalResult = request.replace("returnLimit=1","returnLimit="+searchResultCount);

                  return   sendGET(requestWithTotalResult,client);

       }

     private static SearchOutput  convertToSearchOutput(String response) throws  Exception{

         ObjectMapper objectMapper=new ObjectMapper();
         SearchOutput searchOutput= objectMapper.readValue(response, SearchOutput.class);
         System.out.println("total: " +searchOutput.getPagedResults().getTotal());
         Set<String> returnedIds = new HashSet<>();
         returnedIds.addAll(extractIds(searchOutput));
         searchResultCount = searchOutput.getPagedResults().getTotal();
         return  searchOutput;

       }

       private static SearchResult  convertToSearchResult(SearchOutput searchOutput){
           Set<String> returnedIds = new HashSet<>();
           returnedIds.addAll(extractIds(searchOutput));
           int searchResultCount = searchOutput.getPagedResults().getTotal();
           SearchResult searchResult= new SearchResult(returnedIds, searchResultCount);
           return  searchResult;

       }

       private  static  String searchResultIds(SearchResult searchResult){
           return StringUtils.join(searchResult.getResults(), ';');
       }

       private static  void writeSearchResultToFile(String data) throws  Exception{

           LocalDateTime currentTime = LocalDateTime.now();
           LocalDateTime timeStamp= currentTime.now();


          // File file = new File("C:\\Users\\U6015446\\Desktop\\searchResults\\SearchResultIds_"+timeStamp.now()+".csv");
           String str = "1986-04-08 12:30";
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
           LocalDateTime dateTime = LocalDateTime.parse(timeStamp.toString(), formatter);

           String fileTimeStamp  =dateTime.toString().replace(":", "_").replace(".","_");
           File file = new File("C:\\Users\\U6015446\\Desktop\\searchResults\\searchResultIds_"+fileTimeStamp+".csv");

          try(FileOutputStream fos = new FileOutputStream(file)){
              PrintWriter w = new PrintWriter(fos);
              w.println("Report Time: " +currentTime);
              w.println("");
              w.println("Total : " +searchResultCount);
              w.println("");
              w.println("length: "+data.length());
              w.println("");
              w.println("no.of ids : "+countOfIds);
              w.println("");
              w.println(data);
              w.println("");

           }
       }
}
