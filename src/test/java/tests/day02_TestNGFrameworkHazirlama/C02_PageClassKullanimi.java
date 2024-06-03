package tests.day02_TestNGFrameworkHazirlama;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C02_PageClassKullanimi {



    @Test

    public void test01(){

        // testotomasyonu sayfasina gidin

        Driver.getDriver().get("https://www.testotomasyonu.com/");
        // phone icin arama yapin

        TestotomasyonuPage testotomasyonuPage= new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys("phone", Keys.ENTER);


        // POM'de Page class'larindaki locate'leri kullanmak icin
        // page class'larindan Obje Olusturma yontemi benimsenmistir

        // arama sonucunda urun bulunabildigini test edin

        String unExpectedBulunanUrun= "0 Products Found";
        String actualBulunanUrun= testotomasyonuPage.bulunanUrunSayisiText.getText();
        Assert.assertNotEquals(actualBulunanUrun,unExpectedBulunanUrun);

        // sayfayi kapatin

        Driver.getDriver().quit();

    }

}
