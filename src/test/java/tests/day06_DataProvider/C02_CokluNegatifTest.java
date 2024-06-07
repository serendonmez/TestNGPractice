package tests.day06_DataProvider;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class C02_CokluNegatifTest extends TestBaseReport {


    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        String [][] kullaniciBilgileriArr={ {"banu@gmail.com", "898989"} ,
            {"sedat@yahoo.com", "989887"},
            {"orkong@tmail.com" ,"122334"},
            {"fatih@hotmail.com", "454545"},
            {"arzu@senmail.com", "676767"},
            {"mehmet@mynet.com",   "878987"}};

        return kullaniciBilgileriArr;
    }

    @Test (dataProvider = "kullaniciBilgileri")
    public void cokluNegatifTest(String email, String sifre){



         /*
        1. testotomasyonu anasayfaya gidin
        2. Account linkine tiklayin
        3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        4.  banu@gmail.com     898989
            sedat@yahoo.com    989887
            orkong@tmail.com   122334
            fatih@hotmail.com  454545
            arzu@senmail.com   676767
            mehmet@mynet.com   878987

     */
       extentTest=extentReports.createTest("coklu negatif login Test", "gecersiz kullanici bilgileriyle" +
               "login islemi yapilamayacagini gösterir") ;

        // 1. testotomasyonu anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici testotomasyonu anasayfasina gider");
        //        2. Account linkine tiklayin
        TestotomasyonuPage testotomasyonuPage=new TestotomasyonuPage();
        testotomasyonuPage.accountLink.click();
        extentTest.info("account a tiklar");
        //        3. Asagida verilen kullanici adi ve sifreleri ile giris yapilamadigini test edin
        //        4.  banu@gmail.com     898989
        //            sedat@yahoo.com    989887
        //            orkong@tmail.com   122334
        //            fatih@hotmail.com  454545
        //            arzu@senmail.com   676767
        //            mehmet@mynet.com   878987
        testotomasyonuPage.loginEmail.sendKeys(email);
        testotomasyonuPage.loginPassword.sendKeys(sifre);
        testotomasyonuPage.signInButonu.click();
        extentTest.info("gecersiz bilgileri email ve password girisini dener");
        ReusableMethods.bekle(2);
        Assert.assertTrue(testotomasyonuPage.loginEmail.isDisplayed());

        extentTest.pass("gecersiz bilgilerle giris yapilamayacagini test eder.");





    }

    @AfterTest
    public void teardown(){

        Driver.quitDriver();
    }
}
