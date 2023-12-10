package restapi.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restapi.jackson.domains.AuthToken;
import restapi.jackson.domains.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Jackson3DeserializeArrays {
    public static void main(String[] args) throws JsonProcessingException {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");

        ObjectMapper mapper = new ObjectMapper();

        AuthToken authToken = mapper.readValue(authRequestResponse.asString(), AuthToken.class);

        Response response = given()
                .header("Authorization", "Bearer " + authToken.getAuthToken())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("/users");
        response.prettyPrint();

        User[] usersArray = mapper.readValue(response.asString(), User[].class);
//        System.out.println(usersArray[0].getUsername());
//        System.out.println(usersArray[1].getUsername());
//        System.out.println(usersArray[2].getUsername());

        for (User user : usersArray) {
            System.out.println(user.getUsername());
            System.out.println(user.getUserProfile().getFirstName());
            System.out.println(user.getUserProfile().getLastName());
            System.out.println("-----------------");
        }
        System.out.println("================");
        List<User> userList = mapper.readValue(response.asString(), new TypeReference<List<User>>() {});
        System.out.println(userList.get(0).getUsername());

    }
}
