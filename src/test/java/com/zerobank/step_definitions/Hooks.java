package com.zerobank.step_definitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        BrowserUtils.waitFor(3);
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tthis is connecting to database");
    }

    @After("@db")
    public void closedb(){
        System.out.println("\tthis is connecting to database");
    }



}
