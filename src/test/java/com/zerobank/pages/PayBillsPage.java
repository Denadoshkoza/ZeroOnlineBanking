package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage{

    @FindBy(name = "payee")
    public WebElement PayeeDropDown;
    // Payee is the dropDown that you chose your bank

    @FindBy(name = "account")
    public WebElement AccountDropDown;

   @FindBy(name = "amount")
    public WebElement AmountInputBox;

   @FindBy(name = "date")
    public WebElement DateInputBox;

   @FindBy(name = "description")
    public WebElement DescriptionInputBox;

   @FindBy(id = "pay_saved_payees")
    public WebElement PayButton;

   @FindBy(id = "alert_content")
   public WebElement PaymentAlertContent;


   public PayBillsPage(){PageFactory.initElements(Driver.get(),this);}




}
