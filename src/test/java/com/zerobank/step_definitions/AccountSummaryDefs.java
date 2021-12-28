package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryDefs {


    @When("{string} page should have title {string}")
    public void page_should_have_title(String page, String pageTitle) {
        try{
            Assert.assertEquals("Verifying page title",Driver.get().getTitle(),pageTitle);
        }catch (Exception e){
            Assert.fail("Actual :"+Driver.get().getTitle()+" Expected: "+pageTitle);
        }
    }

    @When("the {string} page should have Account type: {string}")
    public void the_page_should_have(String page, String accountType) {
        List<String> typesList=BrowserUtils.getElementsText( new AccountSummaryPage().accountTypes);
        try{
            Assert.assertTrue(typesList.contains(accountType));
        }catch (Exception e){
            Assert.fail(accountType+" Does not exist in the "+page);
        }
    }
    @When("the user is in {string} table")
    public void the_user_is_in_table(String module) {
        String moduleLocator ="//h2[@class='board-header'][.='"+module+"']";
        try{
            WebElement pageElement = Driver.get().findElement(By.xpath(moduleLocator));
            new Actions(Driver.get()).moveToElement(pageElement).pause(200).build().perform();
        }catch(Exception e){
            BrowserUtils.clickWithWait(By.xpath(moduleLocator),5);
        }
    }

    @Then("the {string} table must have columns {string}")
    public void the_table_must_have_columns(String accountType, String column) {

        String tableLocator="//h2[.='"+accountType+"']/..//div[3]/div/table/thead/tr/th";
        List<WebElement> tableElement=Driver.get().findElements(By.xpath(tableLocator));
        List<String> list= BrowserUtils.getElementsText(tableElement);
        try{
            Assert.assertTrue(list.contains(column));
        }catch (Exception e){
            Assert.fail(column+" Does not exist in the "+accountType);
        }


    }
}
