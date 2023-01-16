package com.unitedcoder.regression.apitest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

// import manuel, because it is static
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class RestAssuredApiTest {

    private static String baseURL = "http://api.openweathermap.org/data/2.5/weather";
    private static String apiKey = "4c8a6dcefbe6b5fc317ba76043de1ee5";


    @Test(description = "Weather forecast Api test")
    public void getCurrentWeatherByCityName() {
        Response response = RestAssured.given().param("q","Istanbul").param("appid",apiKey).
                when().get(baseURL);
        System.out.println(response.getBody().prettyPeek());
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        Assert.assertTrue(response.getBody().jsonPath().getString("name").equals("Istanbul"));
        Assert.assertTrue(response.getBody().jsonPath().get("id").equals(745042));
    }

    @Test
    public void createSingleUser(){
        RestAssured.baseURI="https://reqres.in/";
        given().header("Content-Type","application/json").body("{\n" +
                "    \"name\": \"Sammy\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").when().post("/api/users").then().log().all().assertThat().
                statusCode(201).body("name",equalTo("Sammy")).
                header("X-Powered-By","Express").
                header("Content-Length","81");
        // log().all() displays detailed info
    }

    @Test
    public void updateUser(){
        RestAssured.baseURI="https://reqres.in/";
        given().header("Content-Type","application/json").body("{\n" +
                "    \"name\": \"Sean\",\n" +
                "    \"job\": \"Manager\"\n" +
                "}").when().put("/api/users/2").then().log().all().
                assertThat().statusCode(200).
                body("name",equalTo("Sean")).
                body("job",Matchers.equalTo("Manager")).
                header("X-Powered-By","Express").
                header("Content-Length","70");
        // log().all() displays detailed info
    }

    @Test
    public void deleteUser(){
        RestAssured.baseURI="https://reqres.in/";
        given().header("Content-Type","application/json").when().delete("/api/users/2").then().log().all().
                assertThat().statusCode(204);

    }

    @Test
    void getWeatherDetails() {
        // Specify the base URI
        RestAssured.baseURI = "https://reqres.in/";
        // Create request object
        RequestSpecification httpRequest = RestAssured.given();
        // Create response object
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");
        // Print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
        // Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        // Status line verification
        String statusLine = response.getStatusLine();
        System.out.println("status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
        String header = response.getHeader("page");
        System.out.println("header is: "+header);
    }

}
