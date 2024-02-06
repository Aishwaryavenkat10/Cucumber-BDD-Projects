package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadlocal driver on the basis of given browser
     * @param browser
     * @return the tlDriver
     */
    public WebDriver init_driver(String browser){
        System.out.println("browser name is:"+browser);
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else if(browser.equals("safari")){
            tlDriver.set(new SafariDriver());
        }
        else {
            System.out.println("Please provide the correct browser name"+browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }

    /**
     * this is used to get the driver with threadlocal
     * @return
     */
    public static synchronized WebDriver getDriver(){

        return tlDriver.get();
    }
}
