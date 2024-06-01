package tests.day01_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMEthods {

    /*
    // 3 farkli test methodu olusturup, asagidaki gorevleri yerine getirin
    // 1- testotomasyonu anasayfaya gidin ve sayfaya gittiginizi test edin
    // 2- phone icin arama yapin ve urun bulunabildigini test edin
    // 3- ilk urune tiklayip, acilan safyada case sensitive olmaksizin
    //    urun isminin phone icerdigini test edin
     */

    WebDriver driver;

    // !!!!!!!!!!!!!!!birbirine bagli testlerde Dependson annottion i kullanmak gerekir
    // priority ile numaranlandirmak testler arasinda baglayici olmaz. ilk test calismasa bile
    // driver 2. teste gecer
    // bu sekilde birbirine bagimli testleri depends on ile baglarsak ilk test methodu failed olursa
    // diger testleri calistirmaz
    // dependson ayrica methodlari dogal olarak priority e göre calistirir.

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @AfterClass
    public void teardown(){


        driver.quit();
    }


    // 1- testotomasyonu anasayfaya gidin ve sayfaya gittiginizi test edin


    @Test
    public void anasayfaTesti(){
        driver.get("https://www.testotomasyonu.com/");
        String expectedURL= "test";
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));



    }
    // 2- phone icin arama yapin ve urun bulunabildigini test edin


    @Test (dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){

        WebElement searchBox= driver.findElement(By.id("global-search"));

        searchBox.sendKeys("phone"+ Keys.ENTER);
        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));


        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucYaziElementi.getText();

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);


    }
    // 3- ilk urune tiklayip, acilan safyada case sensitive olmaksizin
    //    urun isminin phone icerdigini test edin


    @Test (dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){


        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();
        String expectedIsimIcerigi = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualIsimKucukHarf = urunIsimElementi.getText()
                .toLowerCase();

        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerigi));




    }



}
