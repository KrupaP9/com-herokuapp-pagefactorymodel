package com.herokuapp.internet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.internet.customlisteners.CustomListeners;
import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='example']/h2")
    WebElement secureAreaText;

    public String getSecureAreaText() {
        Reporter.log("Getting Secure Area Test " + secureAreaText.toString());
        CustomListeners.test.log(Status.PASS,"Get secure area text");
        return getTextFromElement(secureAreaText);
    }
}
