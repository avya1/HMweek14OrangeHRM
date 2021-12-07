package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {
    //userRoleDropDown,employeeName,userName,statusDropDown,password,confirmPassword,save,cancel
    public AddUserPage() {
        PageFactory.initElements(driver,this);
    }
  //  @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    //WebElement admin;

    @FindBy(id = "systemUser_status")
    WebElement status;
    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserText;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement save;
    public void clickOnSaveButton(){
        clickOnElement(save);
    }
    public void enterPassword()
    {
        sendTextToElement(password,"Akshat@1234");
    }
    public void enterConfirmPassword()
    {
        sendTextToElement(confirmPassword,"Akshat@1234");
    }



    public void verifyAddUserText(){
        String exp="Add User";
        verifyPage(exp,addUserText);
    }
    public void clickOnUserRoleAndSelectAdmin(){
        clickOnElement(userRoleDropDown);
        selectByVisibleTextFromDropDown(userRoleDropDown,"Admin");
    }
    public void enterEmployeeNameAnanyaDash(){
        sendTextToElement(employeeName,"Ananya Dash");
    }
    public void enterUserName(){
        sendTextToElement(userName,"Akshat");
    }
    public void selectStatus(){
        clickOnElement(status);
        selectByVisibleTextFromDropDown(status,"Disabled");
    }

}
