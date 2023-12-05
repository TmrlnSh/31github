package restapi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restapi.jackson.domains.AuthToken;
import restapi.jackson.domains.User;

import static io.restassured.RestAssured.given;

public class Jackson2Deserialization {
    public static void main(String[] args) throws JsonProcessingException {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");

        ObjectMapper mapper = new ObjectMapper();

        AuthToken authToken = mapper.readValue(authRequestResponse.asString(), AuthToken.class);
        System.out.println(authToken.getAuthToken());

        Response getUserResponse = given()
                .header("Authorization", "Bearer " + authToken.getAuthToken())
                .pathParam("id", 4532)
                .when()
                .get("user/{id}");

        User userResponse = mapper.readValue(getUserResponse.asString(), User.class);

        getUserResponse.prettyPrint();
        System.out.println(userResponse.getId());
        System.out.println(userResponse.getUsername());
        System.out.println(userResponse.isEnabled());
        System.out.println(userResponse.isAccountNonExpired());
        System.out.println(userResponse.isAccountNonLocked());
        System.out.println(userResponse.isCredentialsNonExpired());
        System.out.println(userResponse.getUsername());
        System.out.println(userResponse.getUserProfile().getId());
        System.out.println(userResponse.getUserProfile().getFirstName());
        System.out.println(userResponse.getUserProfile().getLastName());
        System.out.println(userResponse.getUserProfile().getTitle());
        System.out.println(userResponse.getUserProfile().getGender());
        System.out.println(userResponse.getUserProfile().getSsn());
        System.out.println(userResponse.getUserProfile().getDob());
        System.out.println(userResponse.getUserProfile().getDom());
        System.out.println(userResponse.getUserProfile().getEmailAddress());
        System.out.println(userResponse.getUserProfile().getHomePhone());
        System.out.println(userResponse.getUserProfile().getMobilePhone());
        System.out.println(userResponse.getUserProfile().getWorkPhone());
        System.out.println(userResponse.getUserProfile().getAddress());
        System.out.println(userResponse.getUserProfile().getLocality());
        System.out.println(userResponse.getUserProfile().getRegion());
        System.out.println(userResponse.getUserProfile().getPostalCode());
        System.out.println(userResponse.getUserProfile().getCountry());
    }
}
