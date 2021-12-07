package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class UsersTest extends TestBase {
HomePage homePage;
AddUserPage addUserPage;
AdminPage adminPage;
LoginPage loginPage;
@BeforeMethod(groups = {"sanity","smoke","regression"})
public void init(){
    homePage=new HomePage();
    addUserPage=new AddUserPage();
    adminPage=new AdminPage();
    loginPage=new LoginPage();
}
    @Test(groups = {"smoke","regression"})
    public void adminShouldAddUserSuccessfully() throws InterruptedException {
        /*
         Login to Application
	click On "Admin" Tab
	Verify "System Users" Text
	click On "Add" button
	Verify "Add User" Text
	Select User Role "Admin"
	enter Employee Name "Ananya Dash"
	enter Username
	Select status "Disable"
	enter psaaword
	enter Confirm Password
	click On "Save" Button
	verify message "Successfully Saved"
         */
        loginPage.userShouldLoginSuccessfully();
        homePage.clickOnAdminTabOnHomePage();
        adminPage.verifySystemUserText();
        adminPage.clickOnAddButton();
        addUserPage.verifyAddUserText();
        addUserPage.clickOnUserRoleAndSelectAdmin();
        addUserPage.enterEmployeeNameAnanyaDash();
        addUserPage.enterUserName();
        Thread.sleep(3000);
        addUserPage.selectStatus();
        addUserPage.enterPassword();
        addUserPage.enterConfirmPassword();
        addUserPage.clickOnSaveButton();
       // Assert.assertTrue("Successfully Saved",
         //       driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[2]/div")).isEnabled());
       // System.out.println("Successfully Saved");
        //adminPage.verifySuccessfullySavedText();
    }
    @Test(groups = {"sanity","regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {


        adminShouldAddUserSuccessfully();
/*
Login to Application
	click On "Admin" Tab
	Verify "System Users" Text
	Enter Username
	Select User Role
	Select Satatus
	Click on "Search" Button
	Verify the User should be in Result list.

 *///loginPage.userShouldLoginSuccessfully();
        homePage.clickOnAdminTabOnHomePage();
        adminPage.verifySystemUserText();
        adminPage.enterUserName();
        adminPage.enterUserRole();
        Thread.sleep(2000);
        adminPage.enterEmployeeName();
        Thread.sleep(3000);
        adminPage.selectStatus();
        adminPage.enterSearchButton();


    }
    @Test(groups = {"sanity","regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() throws InterruptedException {
        adminShouldAddUserSuccessfully();
        homePage.clickOnAdminTabOnHomePage();
        adminPage.verifySystemUserText();
        adminPage.enterUserName();
        adminPage.enterUserRole();
        Thread.sleep(2000);
        adminPage.enterEmployeeName();
        Thread.sleep(3000);
        adminPage.selectStatus();
        adminPage.enterSearchButton();
        adminPage.clickOnCheckBox();
        adminPage.clickOnDelete();
        adminPage.clickOnOkPopUP();
/*
Login to Application
	click On "Admin" Tab
	Verify "System Users" Text
	Enter Username
	Select User Role
	Select Satatus
	Click on "Search" Button
	Verify the User should be in Result list.
	Click on Check box
	Click on Delete Button
	Popup will display
	Click on Ok Button on Popup
	verify message "Successfully Deleted"
 */

    }
    @Test(groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {

        /*
        Login to Application
	click On "Admin" Tab
	Verify "System Users" Text
	Enter Username
	Select User Role
	Select Satatus
	Click on "Search" Button
	verify message "No Records Found"
         */loginPage.userShouldLoginSuccessfully();
        homePage.clickOnAdminTabOnHomePage();
        adminPage.verifySystemUserText();
        adminPage.enterUserName();
        adminPage.enterUserRole();
        Thread.sleep(2000);
        adminPage.enterEmployeeName();
        Thread.sleep(3000);
        adminPage.selectStatus();
        adminPage.enterSearchButton();
        adminPage.verifyNoRecordFound();



    }


}
