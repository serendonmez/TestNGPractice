package tests.day07_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestotomasyonuPage1;
import utilities.ConfigReader;

import utilities.TestBaseCross;


public class C01_AramaTesti extends TestBaseCross  {

@Test
    public  void aramaTest(){

    // testotomasyonu anasayfaya gidin
    driver.get(ConfigReader.getProperty("toUrl"));

    // belirlenmis aranacak kelime icin arama yapin
    TestotomasyonuPage1 testotomasyonuPage1=new TestotomasyonuPage1();
    testotomasyonuPage1.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
    // arama sonucunda urun bulunabildigini test edin
    Assert.assertTrue(testotomasyonuPage1.bulunanUrunlerList.size()>0);




}

}
