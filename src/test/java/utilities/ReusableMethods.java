package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.FacebookPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static List<String> stringListesineDonustur(List<WebElement> webelementListesi){

        List<String> istenenStringList = new ArrayList<>();

        for (WebElement eachElement : webelementListesi
        ) {
            istenenStringList.add(eachElement.getText());
        }

        return istenenStringList;
    }


    public static void windowaGecWHD(String firstPageWHD, WebDriver driver){


        Set<String> handles = Driver.getDriver().getWindowHandles();

        String ikinciWHD="";

        for ( String each: handles) {
           if (!firstPageWHD.equals(each)){
               ikinciWHD=each;
           }
        }

        Driver.getDriver().switchTo().window(ikinciWHD);


    }

    public static void windowaGecURLIle(String url, WebDriver driver){


        Set<String> handles= Driver.getDriver().getWindowHandles();

        for ( String each:handles) {
           Driver.getDriver().switchTo().window(each);
           if (Driver.getDriver().getCurrentUrl().equals(url)){
               break;
           }

        }


    }


    public static void takeScreenshot(WebElement webElement){

        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmm");
        String tarihMuhru= ldt.format(dtf);

        TakesScreenshot tss= (TakesScreenshot) Driver.getDriver();
        File dosyaYolu=new File("target/screenshots"+tarihMuhru+".png");

        File geciciDosya= webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }












}
