package restapi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restapi.jackson.domains.AuthToken;
import restapi.jackson.domains.UserCreation;
import restapi.jackson.domains.UserProfile;

import static io.restassured.RestAssured.given;

public class Jackson5Serialize {
    public static void main(String[] args) throws JsonProcessingException {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");

        ObjectMapper mapper = new ObjectMapper();

        AuthToken authToken = mapper.readValue(authRequestResponse.asString(), AuthToken.class);

        UserCreation userProfile = new UserCreation();
        userProfile.setAddress("1 Infinite loop");
        userProfile.setCountry("USA");
        userProfile.setDob("01/05/2020");
        userProfile.setEmailAddress("adach@bk.ru");
        userProfile.setFirstName("Tim");
        userProfile.setLastName("Cook");
        userProfile.setGender('M');
        userProfile.setHomePhone("0312232323");
        userProfile.setLocality("CA");
        userProfile.setPassword("Test123$$");
        userProfile.setPostalCode("60001");
        userProfile.setRegion("Cupertino");
        userProfile.setSsn("123-22-2233");
        userProfile.setTitle("Mr.");

       String jsonRequestPayLoad =  mapper.writeValueAsString(userProfile);


        Response response = given()
                .header("Authorization", "Bearer " + authToken.getAuthToken())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonRequestPayLoad)
                .when()
                .post("/user");

        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }
}
