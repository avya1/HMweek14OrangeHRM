package com.orangehrmlive.demo.testsuite;

import com.google.common.base.Verify;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void setup(){
        loginPage=new LoginPage();
        homePage=new HomePage();
    }
   @Test(groups = {"smoke","regression"})
    public void verifyUserShouldLoginSuccessfully(){
        loginPage.userShouldLoginSuccessfully();
        homePage.verifyTheWelcomeMessage();
       /* Enter username
        Enter password
        Click on Login Button
        Verify "WelCome" Message

        */

    }
    @Test(groups = {"sanity","regression"})
    public void verifyThatLogoDisplayOnHomePage(){
        verifyUserShouldLoginSuccessfully();
        homePage.verifyLogoIsDisplay();
        /*
         Login To The application
   Verify Logo is Displayed

         */

    }
    @Test(groups = "regression")
    public void verifyUserShouldLogOutSuccessfully(){
        verifyUserShouldLoginSuccessfully();
        homePage.clickOnProfileLogo();
        homePage.clickOnLogoutLink();
        String exp="LOGIN Panel";
        loginPage.verifyLoginPanelInLoginPage(exp);
        /*
        Login To The application
   Click on User Profile logo
   Mouse hover on "Logout" and click
   Verify the text "Login Panel" is displayed
         */

    }
}
