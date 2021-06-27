package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "features",
        glue = "steps",
        dryRun = false,
        monochrome = true,
        tags = "@testapi001"


)
public class TestRunner {
}
