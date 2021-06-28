package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import utils.Links;
import utils.Path_local;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class PaypalOrder {

    public static  String access_token;
    Response response;
    RequestSpecification request;
    public static String baseURL = "https://api-m.sandbox.paypal.com/";
    public static String auth_path = "v1/oauth2/token";
    SoftAssert softAssert = new SoftAssert();


    @Given("I have a valid access token")
    public void iHaveAValidAccessToken() {

        access_token = given().param("grant_type","client_credentials")
                .contentType(ContentType.JSON)
                .auth().preemptive().
                        basic(Links.PAYPAL_CLIENT_ID,Links.PAYPAL_SECRET_KEY)
                .post(baseURL+auth_path).body().jsonPath().get("access_token").toString();


    }

    @And("the request body is defined as a Json file")
    public void theRequestBodyIsDefinedAsAJsonFile() throws IOException {

        System.out.println(access_token);

        if (!access_token.equals(" ")) {
            request = given().contentType(ContentType.JSON)
                    .auth().oauth2(access_token).body(Files.readAllBytes(Paths.get(Path_local.PAYPAL_DATA_JSON_PATH+"CreateOrder.json")));
        }

    }

    @When("I send a post create to the {string}")
    public void iSendAPostCreateToThe(String resource) {
        response = request.post(baseURL+resource);
    }

    @Then("I should get status code of {int}")
    public void iShouldGetStatusCodeOf(int statusCode) {

        Assert.assertEquals((response.statusCode()),statusCode);
    }

    @And("the response Body should contains status {string}")
    public void theResponseBodyShouldContainsStatus(String paypalStatus) {

        response.getBody().prettyPrint();
        Assert.assertEquals(response.getBody().jsonPath().get("status").toString(),paypalStatus);
        softAssert.assertNotEquals(response.getBody().jsonPath().<String>get("status").toString(),paypalStatus);
    }

}
