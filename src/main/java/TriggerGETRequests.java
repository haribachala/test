package main.java;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class TriggerGETRequests {
    public static void main(String[] args) {

    }
    protected void sendGET(String requestsFileName, List<String> requests, HttpClient client) throws Exception {
        HttpGet getRequest =null;

        String url = "";
        for (int i=0;i<requests.size();i++) {
            getRequest = new HttpGet(requests.get(i).toString());
            HttpResponse response = client.execute(getRequest);
            int responseCode = response.getStatusLine().getStatusCode();
            System.out.println(i + " Response Code : " + responseCode);
            if(responseCode!=200){
                FileOutputStream fileOutputStream=null;
                PrintWriter printWriter=null;
                try {
                     fileOutputStream=new FileOutputStream(requestsFileName);
                     printWriter=new PrintWriter(fileOutputStream);
                    printWriter.println(getRequest);
                    printWriter.println(response);
                }finally {
                    fileOutputStream.close();
                    printWriter.close();
                }


            }



        //    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            Thread.sleep(60*300);
        }

    }

    }



