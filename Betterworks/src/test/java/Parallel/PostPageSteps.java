package Parallel;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.PostPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PostPageSteps {

    private static String title;
    private PostPage postPage;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("user is already logged in to the application")
    public void user_is_already_logged_in_to_the_application(DataTable credTable) throws InterruptedException {
        List<Map<String, String>> creadList = credTable.asMaps();
        String userName = creadList.get(0).get("username");
        String password = creadList.get(0).get("password");
        DriverFactory.getDriver().get("https://engage-web.betterworks.com/signin");
        postPage = loginPage.doLogin(userName,password);

    }

    @Given("user is on Create Post Page")
    public void user_is_on_create_post_page() {
        postPage.getPostPageTitle();

    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = postPage.getPostPageTitle();
        System.out.println("Page title is :"+title);

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));

    }
    @When("user clicks on CREATE NEW POST BUTTON")
    public void user_clicks_on_create_new_post_button() {
        postPage.clickOnCreatePostBtn();

    }

    @Then("user should select the options")
    public void user_should_select_the_options() {
        postPage.creatingPostByOptions();

    }

    @Then("user should click the PUBLISH POST button")
    public void user_should_click_the_publish_post_button() {
        postPage.clickPublishBtn();

    }

}
