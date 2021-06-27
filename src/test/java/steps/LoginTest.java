package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest {
    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    LoginTest(BaseTests baseTests){
        this.driver = baseTests.getDriver();
    }
    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        driver.get("");

    }

    @When("I click on the form Authentication link")
    public void iClickOnTheFormAuthenticationLink() {
        homePage.clickFormAuthentication();

    }

    @And("I enter the username as {string} and password as {string}")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) {
        loginPage.login(username,password);
    }


    @Then("verify the I am on the secure page area")
    public void verifyTheIAmOnTheSecurePageArea() {

    }
}
