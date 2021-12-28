package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{


    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//h2[.='Cash Accounts']/..//div[3]/div/table")
    public List<WebElement> cashAccountsTable;

    @FindBy(xpath = "//h2[.='Investment Accounts']/..//div[3]/div/table")
    public List<WebElement> investmentAccountsTable;

   @FindBy(xpath = "//h2[.='Credit Accounts']/..//div[3]/div/table")
   public List<WebElement> creditCardAccountsTable;

    @FindBy(xpath = "//h2[.='Loan Accounts']/..//div[3]/div/table")
    public List<WebElement> loanAccountsTable;


    public AccountSummaryPage(){PageFactory.initElements(Driver.get(),this);}



}
