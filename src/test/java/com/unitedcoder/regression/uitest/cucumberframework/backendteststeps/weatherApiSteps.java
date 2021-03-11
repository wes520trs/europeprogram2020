package com.unitedcoder.regression.uitest.cucumberframework.backendteststeps;

import com.unitedcoder.regression.apitest.RestApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;

public class weatherApiSteps {

    private static String baseURL = "http://api.openweathermap.org/data/2.5/weather";
    private static String apiKey = "4c8a6dcefbe6b5fc317ba76043de1ee5";
    private String city;
    private String country;
    private static CloseableHttpResponse closeableHttpResponse;

    @Given("a {string} and {string} and api key")
    public void aAndAndApiKey(String arg0, String arg1) {
        city = arg0;
        country = arg1;
    }

    @When("a user calls the weather api with the api key")
    public void aUserCallsTheWeatherApiWithTheApiKey() {
        RestApiClient client=new RestApiClient();
        String apiUrl=baseURL+"?q="+city+","+country+"&appid="+apiKey;
        closeableHttpResponse=client.getRequest(apiUrl);
        System.out.println("****closeableHttpResponse is:"+closeableHttpResponse.toString()+" END****");
    }

    @Then("user should see the weather data for the city")
    public void userShouldSeeTheWeatherDataForTheCity() {
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
