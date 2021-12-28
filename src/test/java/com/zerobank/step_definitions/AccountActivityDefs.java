package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class AccountActivityDefs {


    @When("the user navigates to page {string}")
    public void the_user_navigates_to_page(String page) {
        new AccountSummaryPage().navigateToPage(page);
    }

    @Then("in the Account drop down default option should be Savings")
    public void in_the_Account_drop_down_default_option_should_be_Savings() {
                  Select select=new Select(new AccountActivityPage().AccountDropDown);
                  String  selectedOption= select.getFirstSelectedOption().getText();
                  Assert.assertEquals("Savings",selectedOption);
    }

    @Then("Account drop down should have the options {string}")
    public void account_drop_down_should_have_the_options(String option) {
        Select select=new Select(new AccountActivityPage().AccountDropDown);
        List<String> dropDownOptions=BrowserUtils.getElementsText(select.getOptions());
        Assert.assertTrue(dropDownOptions.contains(option));
    }

    @Then("Transactions table should have following column names")
    public void transactions_table_should_have_following_column_names(List<String> columnNames) {
        BrowserUtils.waitFor(3);
           List<String> namesList= BrowserUtils.getElementsText(new AccountActivityPage().transactionTableColumnNames);
           Assert.assertEquals(columnNames,namesList);
    }

}
