package tests.day04_softAssertion_XmlDosyalar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebApp;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class C02_SoftAssertion {



    @Test(groups = {"smoke","E2E"})
    public void Test(){


//1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webAppUrl"));
        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin

        String expectedUrl= ConfigReader.getProperty("webAppUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl);
        // 3. Sign in butonuna basin

        WebApp webApp=new WebApp();
        webApp.homePageSignInButton.click();
        // 4. Login kutusuna “username” yazin

        webApp.userNameButton.sendKeys(ConfigReader.getProperty("webAppUsername"));



        // 5. Password kutusuna “password” yazin
        webApp.passwordButton.sendKeys(ConfigReader.getProperty("webAppPassword"));
        // 6. Sign in tusuna basin

        webApp.signInButton.click();
        // 7. Back tusuna basin

        Driver.getDriver().navigate().back();
        // 8. Giris yapilabildigini dogrulayin
       // Driver.getDriver().switchTo().alert().accept();
        softAssert.assertTrue(webApp.userNameIcon.isDisplayed());

        // 9. Online banking menusunu tiklayin
        webApp.onlineBanking.click();
        //10. Pay Bills sayfasina gidin
        webApp.payBillLink.click();
        //11. “Purchase Foreign Currency” tusuna basin
        webApp.purchaseForeignCurrency.click();
        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
           softAssert.assertTrue( webApp.currencyddm.isEnabled());
        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select currencyDDMSelect= new Select(webApp.currencyddm);
        currencyDDMSelect.selectByValue("EUR");
        //14. "Eurozone (euro)" secildigini dogrulayin

        String actualSecilenKur=currencyDDMSelect.getFirstSelectedOption().getText();
        String expectedSecilenKur=ConfigReader.getProperty("webAppSelectedCurrency");
        softAssert.assertEquals(actualSecilenKur,expectedSecilenKur);


       List<WebElement> secilenTumDDElementleri= currencyDDMSelect.getAllSelectedOptions();
       for ( WebElement each : secilenTumDDElementleri) {
           System.out.println("getAllSelectedOption Ne verir :"+ each.getText());
       }



        List<WebElement> DDMtumOptions=currencyDDMSelect.getOptions();


        //15. Dropdown menude 16 option bulundugunu dogrulayin.

        Integer actualDDMSize= currencyDDMSelect.getOptions().size();
        String expectedDDMSize= ConfigReader.getProperty("webAppDropdownBoyut");
       softAssert.assertEquals (actualDDMSize+"",expectedDDMSize ,"DDM size i  16 ya esit degil");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        boolean optiondaVarMi=false;
        for ( WebElement each:DDMtumOptions ) {
          if( each.getText().equals(ConfigReader.getProperty("webAppDropdownIcerik"))){
              optiondaVarMi=true;
          }
        }

       softAssert.assertTrue(optiondaVarMi,"DDm in optionlarinda Dolar secenegi yok");

        List<String> DDMElementleriStringList= new ArrayList<>();
        for ( WebElement each: DDMtumOptions) {
           DDMElementleriStringList.add(each.getText());
        }

        softAssert.assertTrue(  DDMElementleriStringList.contains(ConfigReader.getProperty("webAppDropdownIcerik")));

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();




    }
}


