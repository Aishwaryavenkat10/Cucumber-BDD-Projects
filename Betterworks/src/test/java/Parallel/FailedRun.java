package Parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/failedrerun.txt"},
        glue = {"parallel"},
        monochrome = true,
        plugin = {"pretty",
                "rerun:target/failedrerun.txt"
        }
)

public class FailedRun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios(){
        return super.scenarios();

}


}
