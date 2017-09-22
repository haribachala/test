package com.play;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Asserts;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class SearchSoapRequest {


    public static void main(String[] args) throws Exception {
        HttpClient client;
        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is established.
        int timeoutConnection = 120000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for data.
        int timeoutSocket = 120000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        client = new DefaultHttpClient(httpParameters);
        int returnLimit = 4;

      //  sendPost(getRequest().replace("<returnLimit>4000</returnLimit>","<returnLimit>"+returnLimit+"</returnLimit>"),client);

         String response =  sendGET(prepareGetrequest(),client);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode  node= mapper.readTree(response);




       /* for (int i=4000; i< 100000; i=i+i ){
            sendPost(getRequest().replace("<returnLimit>4000</returnLimit>","<returnLimit>"+i+"</returnLimit>"),client);
        }*/
    }

    private static  void sendPost(String request, HttpClient client) throws Exception {
        String url = "http://ngs-prod-eagan.tshhosting.com:8335/mr/SearchService/v4";
        HttpPost post = new HttpPost(url);
        String body = "";
            HttpEntity entity = new StringEntity(request, HTTP.UTF_8);
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            int responseCode = response.getStatusLine().getStatusCode();
            System.out.println( " Response Code : " + responseCode);
       try( BufferedReader rd = new BufferedReader(new InputStreamReader( response.getEntity().getContent())))
        {

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            String finalResult= result.toString();
          int total=  finalResult.indexOf("total=");
          int firstRow =finalResult.indexOf("firstRow=\"1\"");
            System.out.println(finalResult.substring(total, firstRow));

          //  Asserts.check(finalResult.substring(total, firstRow).equalsIgnoreCase("total=\"113846\""), "Mismatch in search count ");
          String[]  pageResults=  result.toString().split("<Field name=\"patentFamilyId\" type=\"string\">");
           for (String pageResult : pageResults){
           String[]  pagerow  =   pageResult.split("</Field>");
               Arrays.stream(pagerow).forEach(System.out::println);


           }
        }




    }

    private static  String getRequest() throws Exception {
        String soapRequest ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sear=\"http://search.v4.soap.contract.service.soaservices.stack.soa.ls.thomson.com/\">\n" +
                "<soapenv:Header/>\n" +
                "<soapenv:Body>\n" +
                "<sear:search>\n" +
                "<searchInput>\n" +
                "<applicationID>nggui#5826</applicationID>\n" +
                "<userID>5374304</userID>\n" +
                "            <dataSet>patentFamily(breadth=\"extended\")</dataSet>\n" +
                "            <searchQuery>patentAbstractClassifications::2</searchQuery>\n" +
                "            <queryLanguage>ssql</queryLanguage>\n" +
                "          <returnFields>patentFamilyId</returnFields>\n" +
                "          <returnLimit>4000</returnLimit>         \n" +
                "            <offset>0</offset>\n" +
                "            <sortBy>none</sortBy>\n" +
                "</searchInput>\n" +
                "</sear:search>\n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>\n";


     //   System.out.println("request:"+request);
        return soapRequest;
    }

    private static  String prepareGetrequest() {
     return "http://localhost:8335/mr/RestSearchService/v4/search?offset=0&returnLimit=2&searchQuery=cancer&queryLanguage=uiql&returnFields=patentFamilyId%2CpatentNameDisplay%2CpatentOriginalTitle%2CpatentCompaniesOwner%2CpatentIndications%2CpatentActionsPrimary%2CpatentCompoundIdDisplay%2CpatentDrugNamesDisplay%2CpatentTechnologies%2CpatentTypes%2CpatentCompaniesThirdParty%2CpatentAbstractClassifications%2CpatentFamilyPublicationDateFirst%2CpatentDateChangeLast%2CpatentFamilyExpiryDateFirst&dataset=patentFamily(breadth%3D%22extended%22)&countDatasets=nextgendrugall(breadth%3D%22extended%22)%2Cnextgendealall(breadth%3D%22basic%22)%2CpatentFamily(breadth%3D%22extended%22)%2Ccompany(breadth%3D%22extended%22)%2Cprivateequityfirm(breadth%3D%22basic%22)%2Cliterature(breadth%3D%22basic%22)%2CsourcesConferenceDocument(breadth%3D%22basic%22)%2Ctrial(breadth%3D%22extended%22)%2Cregulatory(breadth%3D%22extended%22%2Cdepth%3D%22((regulatoryProdCategory%3D%5C%22Drugs%20and%20Biologics%5C%22)%20AND%20regulatoryRegion%3A%3AOR(%5C%22INT%5C%22%2C%5C%22CA%5C%22%2C%5C%22US%5C%22%2C%5C%22EU%5C%22%2C%5C%22AT%5C%22%2C%5C%22BE%5C%22%2C%5C%22BG%5C%22%2C%5C%22HR%5C%22%2C%5C%22CY%5C%22%2C%5C%22CZ%5C%22%2C%5C%22DK%5C%22%2C%5C%22EE%5C%22%2C%5C%22FI%5C%22%2C%5C%22FR%5C%22%2C%5C%22DE%5C%22%2C%5C%22GR%5C%22%2C%5C%22HU%5C%22%2C%5C%22IS%5C%22%2C%5C%22IR%5C%22%2C%5C%22IT%5C%22%2C%5C%22LV%5C%22%2C%5C%22LT%5C%22%2C%5C%22LU%5C%22%2C%5C%22MT%5C%22%2C%5C%22NL%5C%22%2C%5C%22NO%5C%22%2C%5C%22PL%5C%22%2C%5C%22PT%5C%22%2C%5C%22RO%5C%22%2C%5C%22RU%5C%22%2C%5C%22RS%5C%22%2C%5C%22SK%5C%22%2C%5C%22SI%5C%22%2C%5C%22SP%5C%22%2C%5C%22SE%5C%22%2C%5C%22CH%5C%22%2C%5C%22TR%5C%22%2C%5C%22UA%5C%22%2C%5C%22UK%5C%22%2C%5C%22ASE%5C%22%2C%5C%22AU%5C%22%2C%5C%22CN%5C%22%2C%5C%22HK%5C%22%2C%5C%22IN%5C%22%2C%5C%22ID%5C%22%2C%5C%22JP%5C%22%2C%5C%22MY%5C%22%2C%5C%22NZ%5C%22%2C%5C%22PH%5C%22%2C%5C%22SG%5C%22%2C%5C%22KR%5C%22%2C%5C%22TW%5C%22%2C%5C%22TH%5C%22%2C%5C%22VN%5C%22%2C%5C%22MER%5C%22%2C%5C%22SIC%5C%22%2C%5C%22AR%5C%22%2C%5C%22BR%5C%22%2C%5C%22CL%5C%22%2C%5C%22CO%5C%22%2C%5C%22CR%5C%22%2C%5C%22GT%5C%22%2C%5C%22MX%5C%22%2C%5C%22PA%5C%22%2C%5C%22PE%5C%22%2C%5C%22VE%5C%22%2C%5C%22GCC%5C%22%2C%5C%22DZ%5C%22%2C%5C%22EG%5C%22%2C%5C%22IQ%5C%22%2C%5C%22IL%5C%22%2C%5C%22JO%5C%22%2C%5C%22KE%5C%22%2C%5C%22LB%5C%22%2C%5C%22MA%5C%22%2C%5C%22NG%5C%22%2C%5C%22SA%5C%22%2C%5C%22ZA%5C%22%2C%5C%22TN%5C%22%2C%5C%22AE%5C%22))%20OR%20((regulatoryProdCategory%3D%5C%22Medical%20Devices%20and%20IVDs%5C%22)%20AND%20regulatoryRegion%3A%3AOR(%5C%22INT%5C%22%2C%5C%22CA%5C%22%2C%5C%22US%5C%22%2C%5C%22EU%5C%22%2C%5C%22AT%5C%22%2C%5C%22BE%5C%22%2C%5C%22BG%5C%22%2C%5C%22HR%5C%22%2C%5C%22CZ%5C%22%2C%5C%22DK%5C%22%2C%5C%22EE%5C%22%2C%5C%22FI%5C%22%2C%5C%22FR%5C%22%2C%5C%22DE%5C%22%2C%5C%22GR%5C%22%2C%5C%22HU%5C%22%2C%5C%22IR%5C%22%2C%5C%22IT%5C%22%2C%5C%22LV%5C%22%2C%5C%22LT%5C%22%2C%5C%22NL%5C%22%2C%5C%22NO%5C%22%2C%5C%22PL%5C%22%2C%5C%22PT%5C%22%2C%5C%22RO%5C%22%2C%5C%22RU%5C%22%2C%5C%22RS%5C%22%2C%5C%22SK%5C%22%2C%5C%22SI%5C%22%2C%5C%22SP%5C%22%2C%5C%22SE%5C%22%2C%5C%22CH%5C%22%2C%5C%22TR%5C%22%2C%5C%22UA%5C%22%2C%5C%22UK%5C%22%2C%5C%22AU%5C%22%2C%5C%22CN%5C%22%2C%5C%22HK%5C%22%2C%5C%22IN%5C%22%2C%5C%22ID%5C%22%2C%5C%22JP%5C%22%2C%5C%22MY%5C%22%2C%5C%22NZ%5C%22%2C%5C%22PH%5C%22%2C%5C%22SG%5C%22%2C%5C%22KR%5C%22%2C%5C%22TW%5C%22%2C%5C%22TH%5C%22%2C%5C%22VN%5C%22%2C%5C%22MER%5C%22%2C%5C%22AR%5C%22%2C%5C%22BR%5C%22%2C%5C%22CL%5C%22%2C%5C%22CO%5C%22%2C%5C%22CR%5C%22%2C%5C%22GT%5C%22%2C%5C%22MX%5C%22%2C%5C%22PA%5C%22%2C%5C%22PE%5C%22%2C%5C%22VE%5C%22%2C%5C%22DZ%5C%22%2C%5C%22EG%5C%22%2C%5C%22IQ%5C%22%2C%5C%22IL%5C%22%2C%5C%22JO%5C%22%2C%5C%22KE%5C%22%2C%5C%22LB%5C%22%2C%5C%22MA%5C%22%2C%5C%22NG%5C%22%2C%5C%22SA%5C%22%2C%5C%22ZA%5C%22%2C%5C%22TN%5C%22%2C%5C%22AE%5C%22))%22)%2CsourcesPressRelease(breadth%3D%22basic%22)%2CsiDrug%2CsiPharmacologyRes%2CsiDiseaseBriefing%2CeventTranscripts%2Cbrokerresearch(breadth%3D%22extended%22)%2CsiPharmacokinetics&filters=patentTypes(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentCompanyRelationships(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentFamilyPublicationDateFirstByDay(returnLimit%3D7000%2CsortBy%3Dvalue%2CsortDirection%3Ddescending%2Cprefix%3D%22%22)%2CpatentFamilyPriorityDatesAllByMonth(returnLimit%3D7000%2CsortBy%3Dvalue%2CsortDirection%3Ddescending%2Cprefix%3D%22%22)%2CpatentDateChangeLastByDay(returnLimit%3D7000%2CsortBy%3Dvalue%2CsortDirection%3Ddescending%2Cprefix%3D%22%22)%2CpatentAbstractClassifications(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentFamilyPublicationCountries(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentFamilyPublicationDatesAllByMonth(returnLimit%3D7000%2CsortBy%3Dvalue%2CsortDirection%3Ddescending%2Cprefix%3D%22%22)%2CpatentIndications(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentDrugRelationships(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentTechnologies(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentDrugNamesDisplay(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentCompaniesThirdParty(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentDateAddedByDay(returnLimit%3D7000%2CsortBy%3Dvalue%2CsortDirection%3Ddescending%2Cprefix%3D%22%22)%2CpatentActionsPrimary(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentIsTermAdjusted(returnLimit%3D3%2Cprefix%3D%22%22)%2CpatentCompaniesOwner(returnLimit%3D3%2Cprefix%3D%22%22)";
    }

    private static String  sendGET(String request, HttpClient client) throws Exception {
        HttpGet getRequest =null;

        String url = "";
     //   for (int i=0;i<requests.size();i++) {
            getRequest = new HttpGet(request.toString());
            HttpResponse response = client.execute(getRequest);

             String  responseString=  convertStreamToString(response);

            int responseCode = response.getStatusLine().getStatusCode();



      //      System.out.println(" Response Code : " + responseStream);
        System.out.println(responseString);



            //    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            Thread.sleep(60*300);

            return responseString;
     //   }

    }

    private static String convertStreamToString(HttpResponse response) throws  Exception{
        String finalResult =null;
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
}
