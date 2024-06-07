package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.DriverCross;

import java.util.List;

public class TestotomasyonuPage1 {
    static String kullanilacakBrowser;

    public TestotomasyonuPage1() {
        PageFactory.initElements(DriverCross.getDriver(kullanilacakBrowser), this);
    }

    @FindBy(id = "global-search")
    public WebElement aramakutusu;

    @FindBy (xpath ="//*[text()='4 Products Found']" )
    public WebElement bulunanUrunSayisiText;

    @FindBy (className = "prod-img")
    public List<WebElement> bulunanUrunlerList;


@FindBy(xpath = "(//*[@class='cart-bar'])[1]")
    public WebElement accountLink;

@FindBy (id = "email")
public WebElement loginEmail;

@FindBy (id = "password")
    public WebElement loginPassword;

@FindBy(className = "product-count-text")
    public WebElement aramaSonucElementi;


@FindBy(id = "submitlogin")
    public WebElement signInButonu;

 @FindBy (xpath = "(//*[@class='item'])[6]")
    public  WebElement logoutButonu;

@FindBy(xpath = "//*[@class=' heading-sm mb-4']")
public WebElement ilkUrunText;

@FindBy(xpath = "//*[@class='add-to-cart']")
    public WebElement addToCart;

@FindBy(xpath = "(//*[@class='menu-icon-text'])[3]")
    public WebElement yourCart;

@FindBy (xpath = "//*[@class='product-title text-center']")
    public WebElement sepettekiUrunText;

}
