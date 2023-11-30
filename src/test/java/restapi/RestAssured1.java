package restapi;

import io.restassured.RestAssured;

public class RestAssured1 {

    public static void main(String[] args) {
        //all methods in restAssured are static methods

        //given - is used for re conditions
        //auth
        //headers like content type
        //accept
        //query param
         //request param
        //uri

        //when -> CRUD methods.
        //then -> for validating.

        //all methods are chained in RestAssured

        //baseURI-> is a method that is used for specifying base URI
        //http://18.118.14.155:8080/bank
        RestAssured.given().baseUri("https://dummy.restapiexample.com/")
                .when()
                .get("/employee")
                .then().statusCode(200);

        System.out.println("Successfully sent request");
    }
}
