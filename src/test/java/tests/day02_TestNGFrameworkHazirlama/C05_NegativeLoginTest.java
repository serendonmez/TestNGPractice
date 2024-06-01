package tests.day02_TestNGFrameworkHazirlama;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebdriverUniversity;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C05_NegativeLoginTest {

    @Test
    public void negativeLoginTest(){


        //1."http://webdriveruniversity.com/" adresine gidin


        Driver.getDriver().get("http://webdriveruniversity.com/");

        String ilkWebPage= Driver.getDriver().getWindowHandle();
        System.out.println(ilkWebPage); //D3788743EDF6190F89C17B739F3DC213

        //2."Login Portal" a  kadar asagi inin

        WebdriverUniversity webdriverUniversity= new WebdriverUniversity();

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",webdriverUniversity.loginPortal);




        //3."Login Portal" a tiklayin

        webdriverUniversity.loginPortal.click();


         Set<String> handles= Driver.getDriver().getWindowHandles();

        ilkWebPage= Driver.getDriver().getWindowHandle();

         String ikinciWHD="";
         for ( String each
                  :  handles ) {
            if (! each.equals(ilkWebPage)){
               ikinciWHD=each;
            }
         }





        //4.Diger window'a gecin

        Driver.getDriver().switchTo().window(ikinciWHD);


        //5."username" ve  "password" kutularina fake deger yazdirin
        Faker faker=new Faker();
        webdriverUniversity.username.sendKeys(faker.name().username());
        webdriverUniversity.password.sendKeys(faker.internet().password());

        //6."login" butonuna basin

        webdriverUniversity.loginButton.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedTaxt="validation failed";
        String actualText= Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedTaxt);


        //8.Ok diyerek Popup'i kapatin

        Driver.getDriver().switchTo().alert().accept();
        //9.Ilk sayfaya geri donun


        Driver.getDriver().switchTo().window(ilkWebPage);


        //10.Ilk sayfaya donuldugunu test edin

        String expectedTitle= "WebDriverUniversity.com";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.getDriver().quit();

    }














}
