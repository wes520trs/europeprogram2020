package com.unitedcoder.regression.apitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class demo1 {

    private static String main_url = "https://api.trello.com";
    private static String trelloKey = "599ec3892579fd07a09a4e7dfd471690";
    private static String trelloToken = "28bdf0974f06cb8661ff8f1804bbf2ae48319602d47679d067b7655568181880";
    private static String idBoard = "61bdb9cd3c954f02ea6b6705";
    private static String idList = "61bdc1e72cb5990485452c6d";
    private static String cardContent = "I'm adding 2 cards";
    private static String boardName = "myBoard01";

    @Test
//Trello üzerinde bir board oluşturunuz.
    public void createBoard() {

        RestAssured.baseURI = main_url;
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParam = new JSONObject();
        requestParam.put("key", trelloKey);
        requestParam.put("token", trelloToken);
        requestParam.put("name", boardName);

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParam.toString());

        Response response = httpRequest.post("/1/boards/");

        String responsebody = response.getBody().toString();
        System.out.println("response body is: " + responsebody);
        int statusCode = response.getStatusCode();
        System.out.println("status code is: " + statusCode);
        String boardID = response.jsonPath().getString("id");
        System.out.println("Board id is: " + boardID);
        System.out.println(response.prettyPrint());

    }
}
