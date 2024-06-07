package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@class='fc-button-label'])[1]")  //(//*[@class='fc-button-label'])[1]
    public WebElement cookiesEinwilligen;

    @FindBy(xpath = "//*[@href='/products']")
    public WebElement productsLink;

    @FindBy(xpath = "(//*[@data-product-id='1'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//*[@data-dismiss='modal']")
    public WebElement contShopping;

    @FindBy(xpath = "(//*[@data-product-id='2'])[1]")
    public WebElement secondProduct;

    @FindBy (xpath = "(//*[@href='/view_cart'])[2]")
    public WebElement viewCart;

    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> productsTableList;
@FindBy(xpath = "//*[@href='/product_details/1' ]")  ////*[@href='/product_details/1']
    public WebElement firstProductViewProduct;

@FindBy(xpath = "//*[@name='quantity']")
    public WebElement increaseQuantity;

 @FindBy(xpath = "//*[@name='quantity']")
    public WebElement quantity;

 @FindBy (xpath = "//*[@class='btn btn-default cart']")
    public WebElement addToCart;




}
