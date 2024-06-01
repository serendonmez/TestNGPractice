package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuFormPage {
    public TestotomasyonuFormPage() {


        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='form-control'])[3]")
    public WebElement gun;

    @FindBy (xpath = "(//*[@class='form-control'])[4]")
    public  WebElement ay;

    @FindBy (xpath = "(//*[@class='form-control'])[5]")
    public WebElement yil;



}
