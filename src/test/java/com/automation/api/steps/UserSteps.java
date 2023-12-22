package com.automation.api.steps;

import com.automation.api.models.User;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    @Given("the following user is in the db")
    public void the_following_user_is_in_the_db(List<User> users) {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");
        JsonPath authResponseJsonPath = authRequestResponse.jsonPath();
        String authToken = authResponseJsonPath.getString("authToken");

        Response userAccountsResponse = given()
                .header("Authorization", "Bearer " + authToken)
                .pathParam("id", 2453)
                .when()
                .get("user/{id}/account");

    }
}