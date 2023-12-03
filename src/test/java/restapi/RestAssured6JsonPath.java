package restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RestAssured6JsonPath {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");
       JsonPath authResponseJsonPath = authRequestResponse.jsonPath();
       String authToken = authResponseJsonPath.getString( "authToken");
        System.out.println(authToken);

        Response getUserResponse = given()
                .header("Authorization","Bearer "+ authToken)
                .pathParam("id", 125)
                .when()
                .get("user/{id}");

        JsonPath userResponseJsonPath = getUserResponse.jsonPath();
        int actualId = userResponseJsonPath.getInt("id");
        System.out.println(actualId);

        String actualUsername = userResponseJsonPath.getString("username");
        System.out.println(actualUsername);

        boolean actualEnabled = userResponseJsonPath.getBoolean("enabled");
        System.out.println(actualEnabled);

        boolean actualAccountNonExpired = userResponseJsonPath.getBoolean("accountNonExpired");
        System.out.println(actualAccountNonExpired);

        boolean actualCredentialsNonExpired = userResponseJsonPath.getBoolean("credentialsNonExpired");
        System.out.println(actualCredentialsNonExpired);

    }
}
