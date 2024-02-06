package Config;

import Data.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Api {

    @Step("{method}")
    public static Response addClient(String requestBody) {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .body(requestBody)
                .when()
                .post("/clients.json").then().statusCode(201).extract().response();
    }

    @Step("{method}")
    public static String getClientId() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("entities[0].id").toString();
    }

    @Step("{method}")
    public static List<Integer> getClientIdList() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("entities.id");
    }

    @Step("{method}")
    public static String getClientsCount() {
        return given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").path("metainfo.count").toString();
    }

    @Step("{method}")
    public static void deleteClient(Integer id) {
        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when()
                .delete("clients/" + id + ".json");
    }


}
