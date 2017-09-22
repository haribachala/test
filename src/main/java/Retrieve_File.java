package main.java;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Retrieve_File {
    public static void main(String[] args) throws Exception {
        List<String> requestsLists = Retrieve_File.getRequest();
        Retrieve_File.writeRequestToFile(requestsLists);
        TriggerGETRequests  triggerGETRequests= new TriggerGETRequests();
        HttpClient client=new DefaultHttpClient();
        List<Thread> threads = new ArrayList<Thread>();
        Retrieve_File retrieve_file=new Retrieve_File();
        for(int i=0;i<1;i++) {
            Thread t = null;//new Thread(new MyThreads(requestsLists, "C:\\Users\\U6015446\\Desktop\\Logs\\EDC\\Retrieve_File_Status.txt"));
            threads.add(t);
            t.start();
            Thread.sleep(30000);
        }
        for(Thread t:threads) {
            try {
                t.join();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        //http.sendPost(requests);
        System.out.println("Done");

       // triggerGETRequests.sendGET("Retrieve_File_Status.txt",requestsLists,client);

    }


    private static List<String> getRequest() throws Exception {
        List<String> requests = new ArrayList();
        String logFile = "C:\\Users\\U6015446\\Desktop\\Logs\\EDC\\GUI\\cortellis-gui.log-20170824\\cortellis-gui.log";
        BufferedReader br = new BufferedReader(new FileReader(logFile));
        String currentLine;
        String request = null;
        while ((currentLine = br.readLine()) != null) {
            // System.out.println(sCurrentLine.indexOf("[http://ngs-mwb-prod-edc.int.thomsonreuters.com:9180"));
            if (currentLine.indexOf("[http://ngs-prod-edc.tshhosting.com:8200/mr/RetrieveFileService/") > -1){
                int urlIndex  = currentLine.indexOf("http");
                request = currentLine.substring(urlIndex);
                int length = request.length();
                request = request.substring(0, length-1);
              //  request =request.replace("ngs-prod-edc.tshhosting.com","mwa.eu-west-1.prodeu.prod.cortellis.int.clarivate.com");
                request =request.replace("ngs-prod-edc.tshhosting.com","localhost");
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
        FileOutputStream fos =null;
        PrintWriter w=null;

        try {
            String file = "C:\\Users\\U6015446\\Desktop\\Logs\\ServiceRequests\\Retrieve_File.txt";
             fos = new FileOutputStream(file);
             w = new PrintWriter(fos);
            String request = "";
            for (int i = 0; i < requests.size(); i++) {
                request = requests.get(i);
                w.println(i);
                w.println(request);
                w.println("");
            }
        }
        finally {
            fos.close();
            w.close();
        }

    }
    private class MyThreads  implements  Runnable{
        private List<String> requests;
        private  String fileName;
        MyThreads(List<String> requests, String fileName) {
            this.requests=requests;
            this.fileName=fileName;

        }

        @Override
        public void run() {
            HttpClient client;

            HttpParams httpParameters = new BasicHttpParams();
            // Set the timeout in milliseconds until a connection is established.
            int timeoutConnection = 120000;
            HttpConnectionParams.setConnectionTimeout(httpParameters,
                    timeoutConnection);
            // Set the default socket timeout (SO_TIMEOUT)
            // in milliseconds which is the timeout for waiting for data.
            int timeoutSocket = 120000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            client = new DefaultHttpClient(httpParameters);

            try {
                TriggerGETRequests triggerGETRequests=new TriggerGETRequests();
                triggerGETRequests.sendGET(fileName,requests,client);
            }catch(Exception e) {}
        }

    }
}
