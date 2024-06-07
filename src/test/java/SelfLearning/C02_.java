package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;


import java.time.Duration;

public class C02_ {

    @Test
    public void Test() {


        //1. Launch browser
        Driver.getDriver().get("about:blank");
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().navigate().to(ConfigReader.getProperty("automationUrl"));
        AutomationExercisePage automationExercisePage=new AutomationExercisePage();
        // accept the cookies


        automationExercisePage.cookiesEinwilligen.click();
        //3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",automationExercisePage.firstProductViewProduct);


        softAssert.assertTrue(automationExercisePage.firstProductViewProduct.isDisplayed(),"ilk ürün görüntülenmedi");


        //4. Click 'View Product' for any product on home page
        Actions actions=new Actions(Driver.getDriver());
        automationExercisePage.firstProductViewProduct.click();

        //5. Verify product detail is opened
        wait.until(ExpectedConditions.visibilityOf(automationExercisePage.quantity));
        softAssert.assertTrue(automationExercisePage.quantity.isDisplayed(),"ürün sayisi(detayi) görüntülenmedi");
        //6. Increase quantity to 4

        actions.click(automationExercisePage.quantity).perform();
        automationExercisePage.quantity.clear();
        actions.sendKeys(automationExercisePage.quantity,"4").perform();


        //7. Click 'Add to cart' button
        automationExercisePage.addToCart.click();
        //8. Click 'View Cart' button
        automationExercisePage.viewCart.click();
        //9. Verify that product is displayed in cart page with exact quantity

       WebElement productCountinCart = webTable(1,4);
       String actualProductCount= productCountinCart.getText();
       String expectedProductCount=ConfigReader.getProperty("automationProductCount");
       softAssert.assertEquals(actualProductCount,expectedProductCount);

        softAssert.assertAll();
        Driver.getDriver().quit();
    }

    public WebElement webTable (int satir, int sutun){


        String urunWebTable= "//tbody/tr["+satir+"]/td["+sutun+"]";

        WebElement webTableDinamic= Driver.getDriver().findElement(By.xpath(urunWebTable));


        return webTableDinamic;
    }

}
