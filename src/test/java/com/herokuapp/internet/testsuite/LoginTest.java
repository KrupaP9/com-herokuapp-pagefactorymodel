package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.pages.HomePage;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    //method to login with valid credentials
    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //send valid username
        loginPage.sendTextToUsernameField("tomsmith");
        //send valid password
        loginPage.sendTextToPasswordField("SuperSecretPassword!");
        //click login
        loginPage.clickLoginButton();
        String expectedSecureAreaMessage = "Secure Area";
        String actualSecureAreaMessage = homePage.getSecureAreaText();
        //verify secure area
        Assert.assertEquals(actualSecureAreaMessage,expectedSecureAreaMessage,"Secure Area Message Not Displayed");
    }
    //method to attempt login with invalid username
    @Test(groups = {"smoke","regression"})
    public void verifyTheUsernameErrorMessage(){
        //send invalid username
        loginPage.sendTextToUsernameField("tomsmith1");
        //send valid password
        loginPage.sendTextToPasswordField("SuperSecretPassword!");
        loginPage.clickLoginButton();
        String expectedUsernameError = "Your username is invalid!"+"\n×";
        String actualUsernameError = loginPage.getUsernameErrorMessage();
        //verify username error
        Assert.assertEquals(actualUsernameError,expectedUsernameError,"Error Not Displayed");
    }
    //method to attempt login with invalid username
    @Test(groups = {"smoke","regression"})
    public void verifyThePasswordErrorMessage(){
        //send valid username
        loginPage.sendTextToUsernameField("tomsmith");
        //send invalid password
        loginPage.sendTextToPasswordField("SuperSecretPassword");
        //click login
        loginPage.clickLoginButton();
        String expectedPasswordErrorMessage = "Your password is invalid!"+"\n×";
        String actualPasswordErrorMessage = loginPage.getPasswordErrorMessage();
        //verify error
        Assert.assertEquals(actualPasswordErrorMessage,expectedPasswordErrorMessage,"Password Error Message Not Displayed");
    }
}
