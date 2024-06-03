package tests.day03_TestDatasiKullanimi;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeLoginTest {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
//2- account linkine basin
// 3- 3 farkli test method’u olusturun.
// - gecerli email, gecersiz password
// - gecersiz email, gecerli password
// - gecersiz email, gecersiz password.
//4- Login butonuna basarak login olmayi deneyin
//5- Basarili olarak giris yapilamadigini test edin
    static TestotomasyonuPage testotomasyonuPage= new TestotomasyonuPage(); ;
    @BeforeMethod
    public void setup(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        //2- account linkine basin
        // 3- 3 farkli test method'u olusturun.
        // - gecerli email, gecersiz password
        // - gecersiz email, gecerli password
        // - gecersiz email, gecersiz password.
        //4- Login butonuna basarak login olmayi deneyin
        //5- Basarili olarak giris yapilamadigini test edin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonuPage.accountLink.click();

    }
    @Test  // - gecerli email, gecersiz password
    public void gecersizPasswordTest(){
        testotomasyonuPage.loginEmail.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginPassword.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
    }
    @Test // - gecersiz email, gecerli password
    public void gecersizEmailTest(){
        testotomasyonuPage.loginEmail.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPassword.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
    }
    @Test // - gecersiz email, gecersiz password.
    public void gecersizEmailPasswordTest(){
        testotomasyonuPage.loginEmail.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPassword.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
    }

    @AfterTest //4- Login butonuna basarak login olmayi deneyin
    public void teardown(){


        testotomasyonuPage.signInButonu.click();

        Assert.assertTrue(testotomasyonuPage.signInButonu.isDisplayed());



        Driver.getDriver().quit();

    }

}
