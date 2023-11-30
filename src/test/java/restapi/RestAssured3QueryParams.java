package restapi;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class RestAssured3QueryParams {
    public static void main(String[] args) {
        RestAssured.baseURI="http://18.118.14.155:8080/bank/api/v1";
        given()
                .queryParam("username","admin@demo.io")
                .queryParam("password","Demo123!")
                .when()
                .post("/auth")
                .prettyPrint();
    }
}
