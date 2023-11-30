package restapi;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class RestAssured2PathParam {
    public static void main(String[] args) {
        //we set the baseURI using static baseURI field

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        given()
                .pathParam("id",1)
                .when()
                .get("/employee/{id}").prettyPrint();
        //pretty print -> prints out the response body in pretty format

    }
}
