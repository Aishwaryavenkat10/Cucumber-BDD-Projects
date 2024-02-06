package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
   //1.By Locators
    private By userName = By.xpath("//input[@type='email']");
    private By verificationBtn = By.xpath("//button[@type='submit']");
    private By password = By.xpath("//div[@class='form-group']//input");
    private By loginBtn = By.xpath("//button[@type='submit']");

    //2.Constructor of page class
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //3.Actions

    public String getLoginPageTitle(){
        return driver.getTitle();
    }
    public void enterUserName(String username) throws InterruptedException {

        driver.findElement(userName).sendKeys(username);
        Thread.sleep(5000);

    }
    public void clickOnVerificationBtn() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(verificationBtn).click();
    }
    public void enterPassword(String pwd) throws InterruptedException {
        Thread.sleep(5000);

        driver.findElement(password).sendKeys(pwd);
    }
    public void clickOnLoginBtn() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(loginBtn).click();
    }

    public PostPage doLogin(String un,String pwd) throws InterruptedException {
        System.out.println("Login with: "+un+"and"+pwd);
        driver.findElement(userName).sendKeys(un);
        Thread.sleep(5000);
        driver.findElement(verificationBtn).click();
        Thread.sleep(5000);
        driver.findElement(password).sendKeys(pwd);
        Thread.sleep(5000);
        driver.findElement(loginBtn).click();

        return new PostPage(driver);

    }


}
