package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {


        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//*[text()='Alle Cookies erlauben'])[2]")
    public WebElement cookies;

    @FindBy (id = "email")
    public WebElement email;

    @FindBy (id = "pass")
    public WebElement password;


    @FindBy (xpath = "//*[@data-testid='royal_login_button']")
    public WebElement girisButonu;

    @FindBy(className = "_9ay7")
    public WebElement hataliGiris;

}
