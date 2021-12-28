package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FindTransactionsTabPage extends BasePage{

    @FindBy(id ="aa_fromDate")
    public WebElement fromDates;

    @FindBy(id = "aa_toDate")
    public WebElement toDates;

    @FindBy(css = "[class='btn btn-primary']")
    public WebElement findButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[1]")
    public List<WebElement> dates;



    public FindTransactionsTabPage(){PageFactory.initElements(Driver.get(),this);}





}
