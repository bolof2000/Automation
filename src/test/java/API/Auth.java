package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import utils.Links;
import utils.Path_local;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Auth {

  public static Response response;
  public static String access_key;
  public static String createOrderPath = "/v2/checkout/orders";


  @Test(priority = 1)
    public void authToken(){

        response = given().param("grant_type","client_credentials").
                auth().preemptive().
                basic(Links.PAYPAL_CLIENT_ID,Links.PAYPAL_SECRET_KEY).
                when().
                post(Links.PAYPAL_AUTH_URL);
        access_key =  response.getBody().jsonPath().get("access_token").toString();

    }

    @Test(priority = 2,dependsOnMethods = "authToken")
    public void createOrder() throws IOException {

        RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
        response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_key)
                .body(Files.readAllBytes(Paths.get(Path_local.PAYPAL_DATA_JSON_PATH+"CreateOrder.json")))
                .when().post(createOrderPath);


        response.prettyPrint();
        System.out.println(response.statusCode());

        Assert.assertNotEquals(response.getBody().jsonPath().<String>get("status"),"APPROVED");
        Assert.assertNotEquals(response.statusCode(),200);

    }
}
