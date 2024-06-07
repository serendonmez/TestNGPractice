package tests.day05_TestReporting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C02_RaporluPozitifLoginTesti extends TestBaseReport {


    @Test
    public void loginTesti(){



        extentTest=extentReports.createTest("login Testi","gecerli bilgilerle" +
                "sisteme giris yapilabilir");


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu sf ina gider");
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLink.click();
        extentTest.info("account linkine tiklar");
        // 3- Kullanici email'i olarak gecerli email girin

        testotomasyonuPage.loginEmail.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("gecerli email adresini girer");
        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginPassword.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("gecerli passwordu girer");
        // 5- Login butonuna basarak login olun

        testotomasyonuPage.signInButonu.click();
        extentTest.info("sign in butonuna tiklar");
        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue( testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("basari bir sekilde giris yapar");
        Driver.getDriver().quit();










    }
}
