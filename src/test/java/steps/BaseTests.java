package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Path_local;

public class BaseTests {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty(Path_local.CHROME_DRIVER_SET, Path_local.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
        Thread.sleep(1000);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
