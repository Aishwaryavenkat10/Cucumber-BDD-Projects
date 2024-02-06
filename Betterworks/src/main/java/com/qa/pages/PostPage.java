package com.qa.pages;

import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PostPage {
    private WebDriver driver;

//    ElementUtil element = new ElementUtil();

    private By sideNavBarNames = By.xpath("//div[@class='sidebar-nav-container']//li/a");
    private By createPostBtn = By.xpath("//button[@id='create-button']");
    private By postOption = By.xpath("//span[text()='Anonymous']/parent::label//input");
    private By postType = By.xpath("//div/button[text()='OPEN']");
    private By dropDownBtn = By.xpath("//span[@class='Select-arrow']");
    private By postGroup = By.xpath("//div[@class='Select-menu-outer']/div/div/div[text()='Arnaud only']");
    private By selectBtn = By.xpath("//div/button[text()='Select']");
    private By textArea = By.xpath("//div[@class='form-group']/textarea");
    private By publishPostBtn = By.xpath("//button[text()='Publish post']");
    public PostPage(WebDriver driver){
        this.driver = driver;

    }
    public String getPostPageTitle(){

        return driver.getTitle();
    }
    public int getSidePanelCount(){
       int countList =  driver.findElements(sideNavBarNames).size();
        System.out.println("Count List is: "+countList);
       return countList;
    }
    public List<String> getSidePanelList(){
        List<String> panelList = new ArrayList<>();
        List<WebElement> panelHeaderList = driver.findElements(sideNavBarNames);
        for (WebElement e : panelHeaderList){
            String text = e.getText();
            System.out.println(text);
            panelList.add(text);
        }
        return panelList;
    }
    public void clickOnCreatePostBtn(){

        driver.findElement(createPostBtn).click();
    }
    public void creatingPostByOptions(){
        driver.findElement(postOption).click();
        driver.findElement(postType).click();
        driver.findElement(dropDownBtn).click();
        driver.findElement(postGroup).click();
        driver.findElement(selectBtn).click();


    }
    public void clickPublishBtn(){

        driver.findElement(publishPostBtn).click();
//        element.doClick(publishPostBtn);
    }


}
