package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {
    public AdminPage() {
        PageFactory.initElements(driver,this);
    }
    //userManager,job,organization
    @FindBy(xpath = "//div[@id='successBodyEdit']")
    WebElement successfullySaved;

    @FindBy(xpath = "//input[@name='btnAdd']")
    WebElement addButton;
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement status;
    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement userName;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRole;
    @FindBy(className = "ac_input")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;
    @FindBy(partialLinkText = "AnayaDas")
    WebElement resultText;
    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;
    @FindBy(id="btnDelete")
    WebElement deleteButton;
    @FindBy(id= "dialogDeleteBtn")
    WebElement popUpOkButton;
    @FindBy(xpath = "//div[@class='head']")
    WebElement systemUser;
    @FindBy(xpath = "//td[text()='No Records Found']")
    WebElement noRecordFound;
    public void clickOnCheckBox(){
        clickOnElement(checkBox);
    }
    public void clickOnDelete(){
       clickOnElement(deleteButton);
    }
    public void clickOnOkPopUP(){
       // clickOnElement(popUpOkButton);
    }
    public void verifyNoRecordFound(){
        String exp="No Records Found";
        verifyPage(exp,noRecordFound);
    }
    public void verifyUserIsInResultList(){
        String exp="Ananya Dash";
        verifyPage(exp,resultText);
    }

    public void enterSearchButton(){
        clickOnElement(searchButton);
    }
    public void enterUserName(){
        sendTextToElement(userName,"Akshat");
    }
    public void enterEmployeeName(){
        sendTextToElement(employeeName,"Ananya Dash");
    }
    public void selectStatus(){
        clickOnElement(status);
        selectByVisibleTextFromDropDown(status,"Disabled");
    }

public void enterUserRole(){
    clickOnElement(userRole);
    selectByVisibleTextFromDropDown(userRole,"Admin");
}
    public void verifySystemUserText()
    {
        String exp="System Users";
        verifyPage(exp,systemUser);
    }
    public void clickOnAddButton(){
        clickOnElement(addButton);
    }
    public void verifySuccessfullySavedText()
    {
        String exp="Successfully Saved";
        verifyPage(exp,successfullySaved);
    }



    /*
    public void verifyResultLst(){
        String exp="Ankit";
        verifyPage(exp,);
    };

    public void enterUserName() {
        sendTextElement(userName, "Ankit");

    }
    public void selectUserRole(){
        selectFromDropDown(userRol,"1");
        //selectByVisibleTextFromDropDown(userRol,"Admin");
    }
    public void enterEmployeeName(){
        sendTextElement(employeeName,"Ananya Dash");
    }
    public void selectStatus(){
        selectFromDropDown(status,"0");
    }
    public void clickOnSearchButton(){
        clickOnElement(search);
    }

     */


}
