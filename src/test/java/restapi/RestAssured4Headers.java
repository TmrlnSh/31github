package restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.given;

public class RestAssured4Headers {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        String bodyPayload = "{\"name\":\"Elon\",\"salary\":\"35000\",\"age\":\"25\"}";
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(bodyPayload)
                .when()
                .post("/create")
                .prettyPrint();
    }
}
