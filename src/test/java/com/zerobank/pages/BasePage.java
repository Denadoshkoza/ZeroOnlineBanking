package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

   @FindBy(xpath = "//a[contains(@href,'/bank/redirect.html?url=')]")
   public List<WebElement> pageOptions;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement userName;

    @FindBy(className = "dropdown-toggle")
    public WebElement settings;

    @FindBy(id = "logout_link")
    public WebElement logOutLink;

    @FindBy(xpath = "//a[.='My Profile']")
    public WebElement myProfile;




    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToSettingsModule(String module){
        String moduleLink="(//*[.='"+module+"'])[2]";
        WebElement settingsModule= Driver.get().findElement(By.xpath(moduleLink));
        BrowserUtils.waitForVisibility(settingsModule,3).click();
    }

    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyProfile(){
      //  waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myProfile, 5).click();
    }

   public void navigateToPage(String page){
        String pageLocator ="//a[.='"+page+"']";
        try{
            BrowserUtils.waitForClickablility(By.xpath(pageLocator), 5);
            WebElement pageElement = Driver.get().findElement(By.xpath(pageLocator));
            new Actions(Driver.get()).moveToElement(pageElement).pause(200).doubleClick(pageElement).build().perform();

        }catch(Exception e){
            BrowserUtils.clickWithWait(By.xpath(pageLocator),5);
        }


   }



}
