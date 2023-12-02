package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssured5Headers2 {
    public static void main(String[] args) {
        RestAssured.baseURI="http://18.118.14.155:8080/bank/api/v1";
       String responsePayLoad = given()
                .queryParam("username","admin@demo.io")
                .queryParam("password","Demo123!")
                .when()
                .post("/auth").asString();
       String authToken = responsePayLoad.substring(responsePayLoad.indexOf("eyJhbGciOiJIUzI1NiJ9"),responsePayLoad.lastIndexOf("\""));
        System.out.println(authToken);

        given()
                .header("Authorization","Bearer "+ authToken)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .prettyPrint();
    }
}
