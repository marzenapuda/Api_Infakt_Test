package Config;

import Data.User;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Api {
    public static Response addClient(String requestBody) {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .body(requestBody)
                .when()
                .post("/clients.json").then().log().all().statusCode(201).extract().response();
    }

    public static String getClientId() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("entities[0].id").toString();
    }

    public static List<Integer> getClientIdList() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("entities.id");
    }

    public static String getClientsCount() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("metainfo.count").toString();
    }

    public static void deleteClient(Integer id) {
        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when()
                .delete("clients/" + id + ".json");
    }


}
