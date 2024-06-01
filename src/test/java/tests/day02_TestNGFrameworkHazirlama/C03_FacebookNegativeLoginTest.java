package tests.day02_TestNGFrameworkHazirlama;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookNegativeLoginTest {


    @Test
    public void facebookTest(){

        //1 - https://www.facebook.com/ adresine gidin


        Driver.getDriver().get("https://www.facebook.com/");

        // cikiyorsa cookies'i kabul edin

        FacebookPage facebookPage= new FacebookPage();
        facebookPage.cookies.click();
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin

        Faker faker = new Faker();


        facebookPage.email.sendKeys(faker.internet().emailAddress());

        facebookPage.password.sendKeys(faker.internet().password());

        facebookPage.girisButonu.click();

        //4- Basarili giris yapilamadigini test edin


        Assert.assertTrue(facebookPage.hataliGiris.isDisplayed());


        //5- sayfayi kapatin
        Driver.getDriver().quit();

    }
}
