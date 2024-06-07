package tests.day07_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import pages.TestotomasyonuPage1;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_PozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTest(){




        //1- https://www.testotomasyonu.com/ anasayfasina gidin
            driver.get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage1 testotomasyonuPage1=new TestotomasyonuPage1();
        testotomasyonuPage1.accountLink.click();
        ReusableMethods.bekle(2);
        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage1.loginEmail.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        ReusableMethods.bekle(2);
        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage1.loginPassword.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(2);
        //5- Login butonuna basarak login olun
        testotomasyonuPage1.signInButonu.click();
        //6- Basarili olarak giris yapilabildigini test edin
        ReusableMethods.bekle(2);
        Assert.assertTrue(testotomasyonuPage1.logoutButonu.isDisplayed());


    }
}
