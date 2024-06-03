package tests.day03_TestDatasiKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PozitifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3- Kullanici email'i olarak gecerli email girin
    // 4- Kullanici sifresi olarak gecerli password girin
    // 5- Login butonuna basarak login olun
    // 6- Basarili olarak giris yapilabildigini test edin

    @Test
    public void pozitifLoginTesti(){



        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();
        // 3- Kullanici email'i olarak gecerli email girin

        testotomasyonuPage.loginEmail.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginPassword.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        // 5- Login butonuna basarak login olun

        testotomasyonuPage.signInButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin

       Assert.assertTrue( testotomasyonuPage.logoutButonu.isDisplayed());

Driver.getDriver().quit();

    }



}
