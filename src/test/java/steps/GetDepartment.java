package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetDepartment {
    @Given("a path param as {string}")
    public void aPathParamAs(String arg0) {

    }

    @And("header is defined as application Json")
    public void headerIsDefinedAsApplicationJson() {
    }

    @When("I send a get request to the department resource")
    public void iSendAGetRequestToTheDepartmentResource() {
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int arg0) {
    }

    @And("the response body should contains {string},{string},{string}")
    public void theResponseBodyShouldContains(String arg0, String arg1, String arg2) {
    }
}
