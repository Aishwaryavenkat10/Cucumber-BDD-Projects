package Parallel;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
    DriverFactory.getDriver().get("https://engage-web.betterworks.com/signin");
    }
    @When("user enters the username {string}")
    public void user_enters_the_username(String un) throws InterruptedException {
        loginPage.enterUserName(un);

    }
    @When("clicks user clicks on SEND ME A VERIFICATION CODE BUTTON")
    public void clicks_user_clicks_on_send_me_a_verification_code_button() throws InterruptedException {
        loginPage.clickOnVerificationBtn();

    }
    @Then("user enters verification code {string}")
    public void user_enters_verification_code(String passwd) throws InterruptedException {
        loginPage.enterPassword(passwd);

    }
    @Then("user clicks on LOG IN button")
    public void user_clicks_on_log_in_button() throws InterruptedException {
        loginPage.clickOnLoginBtn();
    }



}
