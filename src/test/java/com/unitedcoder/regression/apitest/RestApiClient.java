package com.unitedcoder.regression.apitest;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestApiClient {
    //httpMethod -- Get request

    //get request without header
    public CloseableHttpResponse getRequest(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse httpResponse=httpClient.execute(httpGet);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code is: " + statusCode);
//        String responseString= EntityUtils.toString(httpResponse.getEntity());
        String responseString = null;
        try {
            responseString = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(responseString);
        System.out.println("Json response is: " + jsonObject);
        Header[] responseHeader = httpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<>();
        for (Header header : responseHeader) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers: " + allHeaders);
        return httpResponse;
    }

    //get request with header
    public CloseableHttpResponse getRequestWithHeader(String url, HashMap<String, String> requestHeder) {
        CloseableHttpResponse httpResponse = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            // for request header
            for (Map.Entry<String, String> entry : requestHeder.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
            httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("Status code is: " + statusCode);
            String responseString = EntityUtils.toString(httpResponse.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            System.out.println("Json response is: " + jsonObject);
            Header[] responseHeader = httpResponse.getAllHeaders();
            HashMap<String, String> allHeaders = new HashMap<>();
            for (Header header : responseHeader) {
                allHeaders.put(header.getName(), header.getValue());
            }
            System.out.println("Headers: " + allHeaders);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return httpResponse;
    }

    //post request
    public CloseableHttpResponse postRequest(String url, String entityString, HashMap<String, String> requestHeader) {
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            //Json payload
            httpPost.setEntity(new StringEntity(entityString));
            //headers
            for (Map.Entry<String, String> entry : requestHeader.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}





