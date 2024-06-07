package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.FacebookPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }











}
