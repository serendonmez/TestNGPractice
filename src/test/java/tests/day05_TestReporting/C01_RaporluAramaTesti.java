package tests.day05_TestReporting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class C01_RaporluAramaTesti extends TestBaseReport {


    @Test
    public void aramaTesti() {
        extentTest= extentReports.createTest("aramaTesti","belirlenen kelimenin " +
                "bulunabildigini test eder");
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici Testotomasyonu sitesine gider");

        // belirlenen arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys(ConfigReader
                .getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("kullanici belirlenen kelimeyi aratir.");
        // arama sonucunda urun bulunabildigini test edin
        String actualBulunanUrun=testotomasyonuPage.bulunanUrunSayisiText.getText();
        String unexpectedBulunnaUrunSayisi="0 Products found";
        ReusableMethods.bekle(2);
        Assert.assertEquals(actualBulunanUrun,unexpectedBulunnaUrunSayisi);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder.");


    }
}
