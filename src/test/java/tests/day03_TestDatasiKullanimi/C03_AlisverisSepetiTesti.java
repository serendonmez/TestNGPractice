package tests.day03_TestDatasiKullanimi;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AlisverisSepetiTesti {

@Test
 public void AlisverisSpetiTest()  {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin

    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    //2- phone icin arama yapin
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
    testotomasyonuPage.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);
    // 3- Listelenen sonuclardan ilkini tiklayin
    testotomasyonuPage.bulunanUrunlerList.get(0).click();
    //4- urun ismini kaydedin ve sepete ekleyin

    String ilkUrunIsmi=testotomasyonuPage.ilkUrunText.getText();




    //5- your cart linkine tiklayin
    JavascriptExecutor javascriptExecutor= (JavascriptExecutor) Driver.getDriver();
   javascriptExecutor.executeScript("arguments[0].click();",testotomasyonuPage.addToCart);


    //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin


    testotomasyonuPage.yourCart.click();




String sepettekiUrunText=testotomasyonuPage.sepettekiUrunText.getText();
Assert.assertEquals(sepettekiUrunText,ilkUrunIsmi);

//7- sayfayi kapatin
    Driver.getDriver().quit();

 }
}
