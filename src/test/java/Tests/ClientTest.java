package Tests;

import Config.RequestBody;
import Data.User;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static Config.Api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class ClientTest extends BaseTest {

    @Step("{method}")
    @Test
    public void addNewClient() {
        addClient(RequestBody.getRequestBody("default"))
                .then()
                .statusCode(201)
                .body("first_name", equalTo("Jan"))
                .body("business_activity_kind", equalTo("private_person"))
                .body("last_name",equalTo("Jeleń"))
                .body("street",equalTo("Zielona"))
                .body("street_number",equalTo("33"))
                .body("city",equalTo("Radom"))
                .body("country",equalTo("PL"))
                .body("postal_code",equalTo("22-222"));

    }

    @Step("{method}")
    @Test
    public void getClientDetails() {
        addClient(RequestBody.getRequestBody("default"));

        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when()
                .get("clients/" + getClientId() + ".json")
                .then().statusCode(200)
                .body("first_name", equalTo("Jan"))
                .body("business_activity_kind", equalTo("private_person"))
                .body("last_name",equalTo("Jeleń"))
                .body("street",equalTo("Zielona"))
                .body("street_number",equalTo("33"))
                .body("city",equalTo("Radom"))
                .body("country",equalTo("PL"))
                .body("postal_code",equalTo("22-222"));

    }

    @Step("{method}")
    @Test
    public void editClient() {
        addClient(RequestBody.getRequestBody("default"));

        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .body(RequestBody.putRequestBody)
                .when().put("clients/" + getClientId() + ".json")
                .then().statusCode(200)
                .body("first_name", equalTo("Roman"))
                .body("business_activity_kind", equalTo("private_person"))
                .body("last_name",equalTo("Jeleń"))
                .body("street",equalTo("Zielona"))
                .body("street_number",equalTo("33"))
                .body("city",equalTo("Radom"))
                .body("country",equalTo("PL"))
                .body("postal_code",equalTo("22-222"));;

    }

    @Step("{method}")
    @Test
    public void addThreeClientsThenCheckCount() {
        addClient(RequestBody.getRequestBody("private_person"));
        addClient(RequestBody.getRequestBody("self_employed"));
        addClient(RequestBody.getRequestBody("other_business"));
        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type", "application/json")
                .header("X-inFakt-ApiKey", User.apiKey)
                .when().get("clients.json").then()
                .body("metainfo.count", equalTo(3))
                .body("entities.company_name", containsInAnyOrder("Restauracja","ZOO",null));

    }

    @Step("{method}")
    @AfterMethod
    public void deleteClients() {
        List<Integer> clientsIdList = getClientIdList();
        for (Integer id : clientsIdList) {
            deleteClient(id);
        }

    }
}
