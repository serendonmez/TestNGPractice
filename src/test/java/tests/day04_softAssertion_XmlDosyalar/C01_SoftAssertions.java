package tests.day04_softAssertion_XmlDosyalar;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertions {

 /*
        SoftAssertion'da 3 adim var
        1- softAssert objesi olustur
        2- istenen tum assertion'lari softAssert objesini kullanarak yap
        3- assertion'lar bittikten sonra, softAssert'un rapor vermesi icin
           assertAll() calistir.
     */


    @Test(groups = {"smoke","E2E"})
    public void test(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

// anasayfaya gittiginizi test edin
String actualUrl= Driver.getDriver().getCurrentUrl();
String expectedUrl= ConfigReader.getProperty("toUrl");


// 1.adim softAssert objesi olustur
        SoftAssert softAssert=new SoftAssert();


// 2.adim olusturdugumuz obje ile istenen tum assertion'lari yapin
        softAssert.assertEquals(actualUrl,expectedUrl,"Web sayfalari ayni degil, row=32");

        // belirlenmis arama kelimesi icin arama yapin

        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin,
        softAssert.assertTrue(testotomasyonuPage.bulunanUrunlerList.size()>0,"bulunan urun sayisi istenen kadar degil, satir 43");

        // ilk urunu tiklayin
        testotomasyonuPage.bulunanUrunlerList.get(0).click();

        // acilan sayfadaki urun isminde case sensitive olmadan
        // aranacak kelime bulundugunu test edin
        String expectedText=testotomasyonuPage.ilkUrunText.getText().toLowerCase();
        String actualText=ConfigReader.getProperty("toAranacakKelime");

        softAssert.assertTrue(expectedText.contains(actualText),"ürün aranacak kelimeyi icermiyor");
        System.out.println(expectedText);
        // 3.adim softAssert'un raporlamasi icin assertAll() calistir
        softAssert.assertAll();
        // sayfayi kapatin
        Driver.getDriver().quit();



    }






}
