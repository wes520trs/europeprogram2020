package com.unitedcoder.regression.apitest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ApiPostRequest {

    CloseableHttpResponse httpResponse;
    RestApiClient apiClient;

    @Test
    public void postRequest() throws IOException {
        String url = "https://reqres.in/api/users";
        HashMap<String, String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/json");
        Users users = new Users("David", "SDET"); // java object
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("testdata//employee.jason"), users);
        //convert java object in json string
        String userJsonString = mapper.writeValueAsString(users);
        System.out.println(userJsonString);
        apiClient = new RestApiClient();
        httpResponse = apiClient.postRequest(url, userJsonString, requestHeader);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("The response from Api: " + responseJson);
        Users userResponseObject = mapper.readValue(responseString, Users.class);
        System.out.println(userResponseObject.getId() + ": " + userResponseObject.getCreatedAt());
        Assert.assertTrue(users.getName().equals(userResponseObject.getName()));
        Assert.assertTrue(users.getJob().equals(userResponseObject.getJob()));
    }
}
