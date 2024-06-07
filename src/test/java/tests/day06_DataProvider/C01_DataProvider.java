package tests.day06_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_DataProvider extends TestBaseReport {


    @DataProvider
    public static Object[][] aranacakKelimeleriYolla() {

           /*
        DataProvider method'u ozel bir method'dur
        - bu method @DataProvider notasyonu kullanir
        - iki katli Object[][] array dondurur
     */

    String [][] aranacakKelimelerArr={{"phone"}, {"dress"}, {"java"}, {"iphone"}, {"samsung"},
            {"nutella"}, {"cokokrem"}  };

        return aranacakKelimelerArr;
    }

    @Test (dataProvider ="aranacakKelimeleriYolla" )
    public void cokluAramaTesti(String aranacakKelime) {

        extentTest=extentReports.createTest("verilen kelimeleri arama testi","arama sonucunda urun " +
                "bulunabildigini gösterir.");

    // testotomasyonu anasayfaya gidin

    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    extentTest.info("kullanici to anasf ya gider");
    // verilen kelime icin arama yapin
    // phone, dress, java, iphone, samsung, nutella ve cokokrem kelimeleri icin ayri ayri calistirin
    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    testotomasyonuPage.aramakutusu.sendKeys(aranacakKelime + Keys.ENTER);
    extentTest.info("arama kutusunda verilen kelimeleri aratir");
        // arama sonucunda urun bulunabildigini test edin


        Assert.assertNotEquals(testotomasyonuPage.aramaSonucElementi.getText(),"0 Products Found");
        extentTest.pass("arama sonucunda urun bulunabildigini test eder.");
        Driver.quitDriver();


    }

}
