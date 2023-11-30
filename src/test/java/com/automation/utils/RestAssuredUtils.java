package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {

    static RequestSpecification reqSpec = RestAssured.given();
    static String endpoint;
    static Response response;

    public static void setEndpoint(String endpoint) {
        RestAssuredUtils.endpoint = endpoint;
    }

    public static void setBody(String body) {
        reqSpec = reqSpec.body(body);
    }

    public static void setHeader(String key, String value) {
        reqSpec = reqSpec.header(key, value);
    }

    public static void get() {
        response = reqSpec.log().all().get(endpoint);
    }

    public static void post() {
        response = reqSpec.log().all().post(endpoint);
    }

    public static void put() {
        response = reqSpec.log().all().put(endpoint);
    }

    public static void setQueryParam(String param, String value) {
        reqSpec = reqSpec.queryParam(param, value);
    }

    public static int getStatusCode() {
        return response.getStatusCode();
    }

    public static String getResponseField(String path) {
        JsonPath jsonPath = new JsonPath(response.asString());
        return jsonPath.getString(path);
    }

}
