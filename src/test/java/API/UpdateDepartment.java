package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateDepartment {
    @Given("an existing department with id {string}")
    public void anExistingDepartmentWithId(String id) {
    }

    @And("content type is set to application Json")
    public void contentTypeIsSetToApplicationJson() {
    }

    @When("I send a patch request to the department resource")
    public void iSendAPatchRequestToTheDepartmentResource() {
    }

    @Then("I should get a response status code of {string}")
    public void iShouldGetAResponseStatusCodeOf(String statusCode) {
    }

    @And("the response body should contained updated id record")
    public void theResponseBodyShouldContainedUpdatedIdRecord() {
    }

    @Given("a request body with valid {string},{string},{string}")
    public void aRequestBodyWithValid(String departmentName, String departmentAddress, String departmentCode) {
    }

    @And("I set content type to application Json")
    public void iSetContentTypeToApplicationJson() {
    }

    @When("I send a put request to the department resource")
    public void iSendAPutRequestToTheDepartmentResource() {
    }

    @Then("I should get a status code of {string}")
    public void iShouldGetAStatusCodeOf(String statusCode) {
    }

    @And("The response body should contains updated resource")
    public void theResponseBodyShouldContainsUpdatedResource() {

    }
}
