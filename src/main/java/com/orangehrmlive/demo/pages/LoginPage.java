package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Utility {
   public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    // name,password,loginButton,LoginPanel
    @FindBy(id= "txtUsername")
    WebElement userName;
    @FindBy(id ="txtPassword")
    WebElement password;
    @FindBy(id = "btnLogin")
    WebElement loginButton;
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPanel;

    public void enterUserName(){
        sendTextToElement(userName,"Admin");
        //sendTextToElement(driver.findElement(By.xpath("//input[@id='txtUsername']")),"Admin");
    }
    public void enterPassword(){
       sendTextToElement(password,"admin123");
       // sendTextToElement(driver.findElement(By.xpath("//input[@id='txtUsername']")),"admin123");
    }
    public void clickOnLoginButtonOnHomePage(){
        clickOnElement(loginButton);
    }
    public void userShouldLoginSuccessfully(){
        enterUserName();
        enterPassword();
        clickOnLoginButtonOnHomePage();
    }
    public void verifyLoginPanelInLoginPage(String exp)
    {
        verifyPage(exp,loginPanel);
    }
}
