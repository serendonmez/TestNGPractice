package tests.day07_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage1;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C03_UrunSepetiTesti extends TestBaseCross {


    @Test
    public void urunSepetiTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        // belirlenen arama kelimesini aratin
        TestotomasyonuPage1 testotomasyonuPage1=new TestotomasyonuPage1();
        testotomasyonuPage1.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        // bulunan urunlerden ilkini tiklayin
        testotomasyonuPage1.bulunanUrunlerList.get(0).click();
        // acilan urun sayfasinda urun ismini kaydedin
       String ilkUrunText= testotomasyonuPage1.ilkUrunText.getText();
        // urunu sepete ekleyin
        testotomasyonuPage1.addToCart.click();
        // sepete gidin
        testotomasyonuPage1.yourCart.click();
        // sepetteki urun ismi ile, kaydettigimiz urun isminin ayni oldugunu test edin
       String actualSepettekiUrunText= testotomasyonuPage1.sepettekiUrunText.getText();
        String expectedUrunText=ConfigReader.getProperty("toAranacakKelime");
        Assert.assertEquals(actualSepettekiUrunText,expectedUrunText);











    }
}
