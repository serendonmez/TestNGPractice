package tests.day01_TestNGFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priority {

    // 3 farkli test method'u olusturun
    // ve her bir method'da asagida verilen websayfalarindan birine gidip
    // o sayfaya gidildigini test edin
    // 1- testotomasyonu.com,
    // 2- wisequarter.com
    // 3- bestbuy.com


    WebDriver driver;



    @BeforeClass // before class ya da before method yapmak degistirmeyecek // her test methodunda quit etmeye gerek yok

    public void setup(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    @AfterClass
    public void teardown (){

        driver.quit();

    }

    /*
    TestNG de testler alfabetik isim sirasina göre calisir
    priority koydugumuzda sayi numaralari kücükten büyüge dogru calistirir.
    priority atamazsak degeri default olarak 0 olur


     */


    @Test (priority = 1)
    public void testotomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com/");

        String expectedURL = "testotomasyonu";
        String actualURLTest= driver.getCurrentUrl();

        Assert.assertTrue(actualURLTest.contains(expectedURL));

    }

    @Test (priority = 2)
    public void wisetesti(){


        driver.get("https://wisequarter.com/");


        String expectedURL = "wisequarter";
        String actualURLTest= driver.getCurrentUrl();

        Assert.assertTrue(actualURLTest.contains(expectedURL));
    }

    @Test (priority = 3)
    public  void bestBuyTesti(){


        driver.get("https://www.bestbuy.com/");


        String expectedURL = "bestbuy";
        String actualURLTest= driver.getCurrentUrl();

        Assert.assertTrue(actualURLTest.contains(expectedURL));

    }







}
