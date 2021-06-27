package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojo.Department;
import utils.Links;

import static io.restassured.RestAssured.given;

public class GetAllDepartment {



  //  public Department department = new Department();
    private RequestSpecification request;
    private Response response;
    SoftAssert softAssert = new SoftAssert();

    @Given("I set the content type to application json")
    public void iSetTheContentTypeToApplicationJson() {
        request = given().contentType(ContentType.JSON);
    }

    @When("I sent a get request to the department resource")
    public void iSentAGetRequestToTheDepartmentResource() {
        response = request.when().get(Links.JSON_DEPARTMENT_SERVER_GET_ALL);
    }


    @And("the response body is logged")
    public void theResponseBodyIsLogged() {
        response.getBody().prettyPrint();
    }




  @Then("the status code should be  {string}")
  public void theStatusCodeShouldBe(String statusCode) {
      Assert.assertEquals(String.valueOf(response.statusCode()),statusCode);
  }
}
