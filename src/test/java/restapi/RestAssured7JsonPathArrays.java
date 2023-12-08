package restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured7JsonPathArrays {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://18.118.14.155:8080/bank/api/v1";
        Response authRequestResponse = given()
                .queryParam("username", "admin@demo.io")
                .queryParam("password", "Demo123!")
                .when()
                .post("/auth");
        JsonPath authResponseJsonPath = authRequestResponse.jsonPath();
        String authToken = authResponseJsonPath.getString("authToken");

        Response userAccountsResponse = given()
                .header("Authorization", "Bearer " + authToken)
                .pathParam("id", 2453)
                .when()
                .get("user/{id}/account");

        userAccountsResponse.prettyPrint();

        JsonPath userAccountsJsonPath = userAccountsResponse.jsonPath();

        int firstAccountId = userAccountsJsonPath.getInt("[0].id");
        System.out.println(firstAccountId);

        int firstAccountNumber = userAccountsJsonPath.getInt("[0].accountNumber");
        System.out.println(firstAccountNumber);

        int thirdAccountId = userAccountsJsonPath.getInt("[2].id");
        System.out.println(thirdAccountId);

        int thirdAccountNumber = userAccountsJsonPath.getInt("[2].accountNumber");
        System.out.println(thirdAccountNumber);
        //fasfasfasfSDFDS
        //lksafbjdv;kcsakdojfiahusldkvjid
    }
}
