package main.java;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.util.List;

public class MyThreads  implements  Runnable{
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
