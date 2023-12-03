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
       authResponseJsonPath.prettyPrint();
       String authToken = authResponseJsonPath.getString( "authToken");
        System.out.println(authToken);

        Response getUserResponse = given()
                .header("Authorization","Bearer "+ authToken)
                .pathParam("id", 4532)
                .when()
                .get("user/{id}");

        JsonPath userResponseJsonPath = getUserResponse.jsonPath();

        getUserResponse.prettyPrint();

        int actualId = userResponseJsonPath.getInt("id");
        System.out.println(actualId);
        String actualUsername = userResponseJsonPath.getString("username");
        System.out.println(actualUsername);

        boolean actualEnabled = userResponseJsonPath.getBoolean("enabled");
        boolean actualAccountNonExpired = userResponseJsonPath.getBoolean("accountNonExpired");
        boolean actualAccountNonLocked = userResponseJsonPath.getBoolean("accountNonLocked");
        boolean actualCredentialsNonExpired = userResponseJsonPath.getBoolean("credentialsNonExpired");

        System.out.println(actualEnabled);
        System.out.println(actualAccountNonExpired);
        System.out.println(actualAccountNonLocked);
        System.out.println(actualCredentialsNonExpired);

        int userProfileId = userResponseJsonPath.getInt("userProfile.id");
        System.out.println(userProfileId);

        String firstName = userResponseJsonPath.getString("userProfile.firstName");
        System.out.println(firstName);

        char gender = userResponseJsonPath.getChar("userProfile.gender");
        System.out.println(gender);

        String dob = userResponseJsonPath.getString("userProfile.dob");
        System.out.println(dob);
    }
}
