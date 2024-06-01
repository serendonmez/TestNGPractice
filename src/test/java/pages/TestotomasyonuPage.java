package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuPage {

    public TestotomasyonuPage() {


        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramakutusu;

    @FindBy (xpath ="//*[text()='4 Products Found']" )
    public WebElement bulunanUrunSayisi;

    @FindBy (className = "prod-img")
    public List<WebElement> bulunanUrunlerList;










}
