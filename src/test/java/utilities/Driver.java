package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {


    // driver classi webDriver i olusturup gerekli ayarlari yapacagimiz class olacak

    //Hedef confiuration propertiesden hangi browser secilirse
    // bize o browser i uretecek bir class olusturmak

    // Driver classinda bize driver döndürecek getdriver olacak


    public static WebDriver driver;
 public static WebDriver getDriver(){

     if (driver==null) {
         driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

     return driver;
 }



 public static void quitDriver(){

     driver.quit();
     driver=null;
 }
}
