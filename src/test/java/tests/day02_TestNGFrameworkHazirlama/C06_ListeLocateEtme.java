package tests.day02_TestNGFrameworkHazirlama;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_ListeLocateEtme {

    @Test
    public void listLocateTest(){
        // 1- testotomasyonu anasayfaya gidin

        Driver.getDriver().get("https://testotomasyonu.com/");
        // 2- phone icin arama yapin

        TestotomasyonuPage testotomasyonuPage= new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys("phone"+ Keys.ENTER);
        //    arama sonucunda urun bulunabildigini test edelim
        //    bulunan sonuclari bir liste olarak kaydedip, size'ini test edelim


     List<String> bulunanurunler= ReusableMethods.stringListesineDonustur(testotomasyonuPage.bulunanUrunlerList);
        System.out.println(bulunanurunler);


        int expectedBulunanUrunSayisi=4;
        int actualBulunanUrunSayisi=testotomasyonuPage.bulunanUrunlerList.size();
        Assert.assertEquals(actualBulunanUrunSayisi,expectedBulunanUrunSayisi);


        Driver.getDriver().quit();

    }
}
