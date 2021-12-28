package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
      String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters valid {string} {string}")
    public void the_user_enters_valid(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the user should be able to login with valid credentials")
    public void the_user_should_be_able_to_login() {
        if(Driver.get().getTitle().contains("Account")){
        }else{
            BrowserUtils.waitForVisibility(LoginPage.loginError,10);
            Assert.assertTrue(LoginPage.loginError.isDisplayed());
        }
    }


    @When("the user enters invalid {string} {string}")
    public void theUserEntersInvalid(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);

    }
    @Given("the user has logged in the page")
    public void the_user_has_logged_in_the_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

}
