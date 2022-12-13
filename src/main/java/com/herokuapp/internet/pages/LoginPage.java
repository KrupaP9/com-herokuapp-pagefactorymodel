package com.herokuapp.internet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
            @FindBy(id = "username")
    WebElement usernameField;
    @CacheLookup
            @FindBy(id = "password")
            WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(id = "flash")
    WebElement usernameErrorMessage;

    @CacheLookup
    @FindBy(id = "flash")
    WebElement passwordErrorMessage;

    public void sendTextToUsernameField(String username){
        Reporter.log("Enter username"+username+ "to username field "+usernameField.toString());
        sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS,"Enter username " + username);
    }
    public void sendTextToPasswordField(String password){
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }
    public void clickLoginButton(){
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }
    public String getUsernameErrorMessage(){
        Reporter.log("Getting username error message " + usernameErrorMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From Welcome Back");
        return getTextFromElement(usernameErrorMessage);
    }
    public String getPasswordErrorMessage(){
        Reporter.log("Getting password error message " + passwordErrorMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From Welcome Back");
        return getTextFromElement(passwordErrorMessage);
    }
}
