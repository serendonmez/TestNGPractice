package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebdriverUniversity {

    public WebdriverUniversity() {

        PageFactory.initElements(Driver.getDriver(),this);

    }


@FindBy(xpath = "//*[text()='Login Portal']")
    public WebElement loginPortal;

@FindBy (id = "text")
public WebElement username;

@FindBy(id = "password")
public WebElement password;

@FindBy(id = "login-button")
public WebElement loginButton;












}
