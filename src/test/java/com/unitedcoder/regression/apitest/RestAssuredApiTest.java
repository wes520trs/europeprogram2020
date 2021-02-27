package com.unitedcoder.regression.apitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredApiTest {

    private static String baseURL = "http://api.openweathermap.org/data/2.5/weather";
    private static String apiKey = "4c8a6dcefbe6b5fc317ba76043de1ee5";


    @Test(description = "Weather forecast Api test")
    public void getCurrentWeatherByCityName() {
        Response response = RestAssured.given().param("q","London").param("appid",apiKey).
                when().get(baseURL);
        System.out.println(response.getBody().prettyPeek());
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        Assert.assertTrue(response.getBody().jsonPath().getString("name").equals("London"));
    }
}
