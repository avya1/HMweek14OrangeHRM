package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Utility {
   public HomePage() {
        PageFactory.initElements(driver, this);
    }
    //store orangehrm logo,admin,pin,leave,dashboard,welcome text,locators
    @FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement orangeHRMLogo;
    @FindBy(xpath = "//b[normalize-space()='Admin']")
    WebElement admin;
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeText;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;
    public void verifyTheWelcomeMessage(){
        String s1 = "Welcome Paul";
        String expectedMessage = s1.substring(0, 6);
        String s2 = getTextFromElement(welcomeText);
        String actualMessage = s2.substring(0,6);
        Assert.assertEquals(expectedMessage,actualMessage, "Welcome Message is displayed incorrectly" );
    }

    public void clickOnProfileLogo(){
        clickOnElement(welcomeText);
    }
    public void clickOnLogoutLink(){
        clickOnElement(logout);
    }
    public void verifyLogoIsDisplay(){
        boolean isDisplay=orangeHRMLogo.isDisplayed();
        if(isDisplay)
            System.out.println("Logo is Displayed on page");

    }
    public void clickOnAdminTabOnHomePage(){
        clickOnElement(admin);
    }
}
