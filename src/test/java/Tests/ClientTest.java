package Tests;

import Config.RequestBody;
import Data.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

import static Config.Api.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ClientTest extends BaseTest{





    @Test
    public void addNewClient(){
        addClient(RequestBody.getRequestBody("default"))

                .then()
                .statusCode(201)
                .body("first_name",equalTo("Heronin"))
                .body("business_activity_kind",equalTo("private_person"));

    }

    @Test
    public void getClientDetails(){
        addClient(RequestBody.getRequestBody("default"));

        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type","application/json")
                .header("X-inFakt-ApiKey",User.apiKey)
                .when()
                .get("clients/"+getClientId()+".json")
                .then().statusCode(200);


    }

    @Test
    public void editClient(){
        addClient(RequestBody.getRequestBody("default"));

        given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type","application/json")
                .header("X-inFakt-ApiKey",User.apiKey)
                .body(RequestBody.putRequestBody)
                .when().put("clients/"+getClientId()+".json")
                .then().statusCode(200)
                .body("first_name",equalTo("Ziemniak"));


    }

    @Test
    public void addThreeClientsThenCheckCount(){
        addClient(RequestBody.getRequestBody("private_person"));
        addClient(RequestBody.getRequestBody("self_employed"));
        addClient(RequestBody.getRequestBody("other_business"));
         given()
                .baseUri("https://api.sandbox-infakt.pl/api/v3")
                .header("Content-type","application/json")
                .header("X-inFakt-ApiKey",User.apiKey)
                .when().get("clients.json").then().body("metainfo.count",equalTo(3));

    }



    @AfterTest
    public void deleteClients(){
        List<Integer> clientsIdList = getClientIdList();
        for(Integer id : clientsIdList){
            deleteClient(id);
        }

}}
