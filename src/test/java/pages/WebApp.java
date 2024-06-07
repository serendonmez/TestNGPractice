package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebApp {

    public WebApp() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


@FindBy(className = "icon-signin")
    public WebElement homePageSignInButton;

@FindBy(xpath= "//*[@id='user_login']")
public WebElement userNameButton;

@FindBy (id = "user_password")
    public WebElement passwordButton;
@FindBy (xpath = "//*[@name='submit']")
    public WebElement signInButton;
@FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement userNameIcon;
@FindBy(xpath = "(//*[text()='Online Banking'])[1]")
    public WebElement onlineBanking;

@FindBy (id = "pay_bills_link")
public WebElement payBillLink;

@FindBy(xpath = "//*[@href='#ui-tabs-3']")
    public WebElement purchaseForeignCurrency;

@FindBy(xpath = "//*[@name='currency']")
    public WebElement currencyddm;



}
