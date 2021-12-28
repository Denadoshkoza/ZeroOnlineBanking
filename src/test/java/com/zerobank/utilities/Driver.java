package com.zerobank.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver get() {
        // Test
        if (driver == null) {
            // this line will tell which browser should open based on the value from properties file
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    ChromeOptions handleSSL=new ChromeOptions();
                    handleSSL.setAcceptInsecureCerts(true);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(handleSSL);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.setAcceptInsecureCerts(false);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    DesiredCapabilities capabilities= DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver(capabilities);
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    EdgeOptions ssl=new EdgeOptions();
                    ssl.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(ssl);
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    DesiredCapabilities safari=DesiredCapabilities.safari();
                    safari.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver(safari);
                    break;
            }

        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
