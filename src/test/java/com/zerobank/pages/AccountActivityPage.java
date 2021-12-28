package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.WeakHashMap;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement AccountDropDown;

    @FindBy(id = "all_transactions_for_account")
    public WebElement transactionsTable;

    @FindBy(xpath = "//*[@id='all_transactions_for_account']/table/thead/tr/th")
    public List<WebElement> transactionTableColumnNames;

    public AccountActivityPage(){PageFactory.initElements(Driver.get(),this);}

}
