package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pojo.Department;
import utils.Links;

import static io.restassured.RestAssured.*;

public class CreateDepartment {

   public Department department = new Department();
    private RequestSpecification request;
    private Response response;
    SoftAssert softAssert = new SoftAssert();

    @Given("I have the data to create department with {string},{string},{string}")
    public void iHaveTheDataToCreateDepartmentWith(String departmentName, String departmentAddress, String departmentCode) {
        department.setDepartmentName(departmentName);
        department.setDepartmentAddress(departmentAddress);
        department.setDepartmentCode(departmentCode);
    }

    @And("I use department header")
    public void iUseDepartmentHeader() {
       request =  given().contentType(ContentType.JSON);
    }

    @When("I send a post request to department resource")
    public void iSendAPostRequestToDepartmentResource() {
        response = request.
                when().
                body(department).
                log().
                body().
                post(Links.JSON_DEPARTMENT_SERVER);
        response.getBody().prettyPrint();

    }

    @Then("I get status code {int} from the database")
    public void iGetStatusCodeFromTheDatabase(int statusCode) {
        Assert.assertEquals(response.statusCode(),200);

    }


}
