package steps;

import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHome {

    private WebDriver driver;


    @Given("I am on ebay Home page")
    public void iAmOnEbayHomePage() {
        driver.get("https://www.ebay.com");
    }

    @When("I click advanced search")
    public void iClickAdvancedSearch() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("verify I am navigated to the next page")
    public void verifyIAmNavigatedToTheNextPage() {
        String text = driver.findElement(By.linkText("using advanced search options")).getText();
        Assert.assertEquals(text,"using advanced search options");
    }

    @And("verify the new url")
    public void verifyTheNewUrl() {

        String expected_url = driver.getCurrentUrl();
        System.out.println(expected_url);
        Assert.assertEquals(expected_url,"https://www.ebay.com/sch/ebayadvsearch");
    }
    //String url = driver.getCurrentUrl();
      // Assert.assertTrue(url.contains(""));


}
