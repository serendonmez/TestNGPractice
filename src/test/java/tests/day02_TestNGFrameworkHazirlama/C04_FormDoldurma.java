package tests.day02_TestNGFrameworkHazirlama;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuFormPage;
import pages.TestotomasyonuPage;
import utilities.Driver;

import java.util.List;

public class C04_FormDoldurma {


    @Test
    public void formDoldurmaTesti(){

        //1 - https://testotomasyonu.com/form adresine gidin

        Driver.getDriver().get("https://testotomasyonu.com/form");
        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        TestotomasyonuFormPage testotomasyonuform= new TestotomasyonuFormPage();
        Select selectGun=new Select(testotomasyonuform.gun);
        selectGun.selectByIndex(5);


        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        Select selectAy= new Select(testotomasyonuform.ay);

        selectAy.selectByValue("nisan");
        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        Select selectYil=new Select(testotomasyonuform.yil);
        selectYil.selectByVisibleText("1990");
        //5- Secilen değerleri konsolda yazdirin

        System.out.println("secilen option  degeleri:  "+selectGun.getFirstSelectedOption().getText()+" "
                +selectAy.getFirstSelectedOption().getText()+" "
                +selectYil.getFirstSelectedOption().getText());



        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> aylar= selectAy.getOptions();

        for ( WebElement each
                 : aylar  ) {
            System.out.println(each.getText());
        }

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int actualAySize= aylar.size();
        int expectedAySize= 13;

        Assert.assertEquals(actualAySize,expectedAySize);

        Driver.getDriver().quit();






    }
}
