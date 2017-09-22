package main.java;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SearchLog {
    public static void main(String[] args) throws Exception {
        List<String> requestsLists = SearchLog.getRequest();
        SearchLog.writeRequestToFile(requestsLists);
        TriggerGETRequests  triggerGETRequests= new TriggerGETRequests();
        HttpClient client=new DefaultHttpClient();
        triggerGETRequests.sendGET("Search_Service_Status.txt",requestsLists,client);

    }


    private static List<String> getRequest() throws Exception {
        List<String> requests = new ArrayList();
        String logFile = "C:\\Users\\U6015446\\Desktop\\Logs\\EDC\\GUI\\cortellis-gui.log-20170824\\cortellis-gui.log";
        BufferedReader br = new BufferedReader(new FileReader(logFile));
        String currentLine;
        String request = null;
        while ((currentLine = br.readLine()) != null) {
            // System.out.println(sCurrentLine.indexOf("[http://ngs-mwb-prod-edc.int.thomsonreuters.com:9180"));
            if (currentLine.indexOf("[http://ngs-prod-edc.tshhosting.com:8335/mr/RestSearchService/v4/") > -1){
                int urlIndex  = currentLine.indexOf("http");
                request = currentLine.substring(urlIndex);
                int length = request.length();
                request = request.substring(0, length-1);
                request =request.replace("ngs-prod-edc.tshhosting.com","mwa.eu-west-1.prodeu.prod.cortellis.int.clarivate.com");
                //  System.out.println("");
                System.out.println(request);
                System.out.println("");
                requests.add(request);
            }
        }
        br.close();

        System.out.println("Total requests:"+requests.size());
        return requests;
    }
    static  private void writeRequestToFile(List<String> requests) throws Exception {
        String file = "C:\\Users\\U6015446\\Desktop\\Logs\\ServiceRequests\\Search_Service.txt";
        FileOutputStream fos = new FileOutputStream(file);
        PrintWriter w = new PrintWriter(fos);
        String request = "";
        for(int i=0;i<requests.size();i++) {
            request = requests.get(i);
            w.println(i);
            w.println(request);
            w.println("");
        }
        w.close();
    }
}

