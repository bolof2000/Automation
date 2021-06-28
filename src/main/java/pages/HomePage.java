package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By formAthutentication = By.linkText("Form Authentication");


    public LoginPage clickFormAuthentication(){
        driver.findElement(formAthutentication).click();
        return new LoginPage(driver);
    }
}
