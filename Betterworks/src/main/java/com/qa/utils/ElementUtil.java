package com.qa.utils;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class ElementUtil {

    private WebDriver driver;


//    DriverFactory driverFactory = new DriverFactory();


    Properties prop;

//    String browserName =  prop.getProperty("browser");
//    driverFactory = new DriverFactory();
//    driver = driverFactory.init_driver(browserName);
//
//    public ElementUtil(WebDriver driver){
//
//        this.driver = driver;
//    }

    public WebElement getElement(By locator){

        return driver.findElement(locator);
    }

    public void doClick(By locator){
        getElement(locator).click();
    }
    public  void doSendKeys(By locator, String value){

        getElement(locator).sendKeys(value);
    }
}
