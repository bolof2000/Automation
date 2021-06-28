package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.Links;

import static io.restassured.RestAssured.given;

public class GetOrder extends BaseAPI {

   public static Response response;
    public static RequestSpecification request;
    public static String access_token;

    @Given("I am authorized withe valid authentication token")
    public void iAmAuthorizedWitheValidAuthenticationToken() {

        access_token = BaseAPI.accessToken();
         {
            request = given()
                    .contentType(ContentType.JSON)
                    .auth()
                    .preemptive()
                    .oauth2(access_token);
        }

        System.out.println(access_token);
    }

    @When("I send a get request to the department {string} with a valid ID as {string}")
    public void iSendAGetRequestToTheDepartmentWithAValidIDAs(String resource, String id) {
        response = request.pathParam("id",id)
                .when()
                .get(Links.baseURL+resource+"{id}");
        response.getBody().prettyPrint();
        System.out.println(response.statusCode());

    }
}
