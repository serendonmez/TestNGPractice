package SelfLearning;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.IConfigurable;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import pages.WebApp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01 {
@Test
    public void test(){

   //1. Launch browser
Driver.getDriver().get("about:blank");
    //2. Navigate to url 'http://automationexercise.com'
    Driver.getDriver().navigate().to(ConfigReader.getProperty("automationUrl"));
    AutomationExercisePage automationExercisePage=new AutomationExercisePage();
    // accept the cookies
    automationExercisePage.cookiesEinwilligen.click();
    //3. Verify that home page is visible successfully
    SoftAssert softAssert=new SoftAssert();
    String actualUrl= Driver.getDriver().getCurrentUrl();
    String expectedUrl=ConfigReader.getProperty("autoExerciseUrl");
    softAssert.assertEquals(actualUrl,expectedUrl);

    //4. Click 'Products' button

    automationExercisePage.productsLink.click();
    //5. Hover over first product and click 'Add to cart'


    ReusableMethods.bekle(3);

    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
    javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});" ,automationExercisePage.firstProduct);
    actions.moveToElement(automationExercisePage.firstProduct).click(automationExercisePage.firstProduct)
            .perform();

    //6. Click 'Continue Shopping' button

ReusableMethods.bekle(2);

    automationExercisePage.contShopping.click();
    //7. Hover over second product and click 'Add to cart'

    actions.moveToElement(automationExercisePage.secondProduct).click()
            .perform();

    //8. Click 'View Cart' button
    ReusableMethods.bekle(1);
    automationExercisePage.viewCart.click();
    //9. Verify both products are added to Cart
    softAssert.assertTrue(automationExercisePage.productsTableList.size()==2);

    String expectedIlkUrun=ConfigReader.getProperty("automationFirstProductName");
    String actualIlkUrun=automationExercisePage.productsTableList.get(0).getText();

    softAssert.assertTrue(actualIlkUrun.contains(expectedIlkUrun));


    String expectedIkinciUrun= ConfigReader.getProperty("automationSecondProductName");
    String actualIkinciUrun= automationExercisePage.productsTableList.get(1).getText();

    softAssert.assertTrue(actualIkinciUrun.contains(expectedIkinciUrun));


    //10. Verify their prices, quantity and total price  // //*[@class='ns-mup7j-e-16']
       String actualTotalPrice= webTable(1,5).getText();
       String expectedTotalPrice=ConfigReader.getProperty("automationWebTableIlkUrunPrice");
    softAssert.assertEquals(actualTotalPrice,expectedTotalPrice);

Driver.getDriver().quit();

}


   public WebElement webTable (int satir, int sutun){


    String urunWebTable= "//tbody/tr["+satir+"]/td["+sutun+"]";

    WebElement webTableDinamic= Driver.getDriver().findElement(By.xpath(urunWebTable));


      return webTableDinamic;
 }



}
