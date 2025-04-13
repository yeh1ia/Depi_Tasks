package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class alert {
    EdgeDriver Driver = new EdgeDriver();

    @BeforeMethod
    void setup()
    {
        Driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    void TC_21() {

        SoftAssert Soft = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(9));

        Driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Driver.switchTo().alert().accept();

        String S = Driver.switchTo().alert().getText();

        if (S == "I am a JS Confirm") {
            Driver.switchTo().alert().accept();
            Soft.assertEquals(S, true);
        } else {
            Driver.switchTo().alert().dismiss();
        }
        Soft.assertAll();

    }
        @Test
        void TC_22()
        {
            SoftAssert Soft = new SoftAssert();

            WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(3));


            Driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]")).click();

            wait.until(ExpectedConditions.alertIsPresent());
            Driver.switchTo().alert().sendKeys("Yehia");
            Driver.switchTo().alert().accept();
            String Y = Driver.switchTo().alert().getText();
            if (Y.equals("You entered: Yehia")) {
                Driver.switchTo().alert().accept();
                Soft.assertEquals(Y, true);
            } else {
                Driver.switchTo().alert().dismiss();
            }

            Soft.assertAll();
        }



    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }






}
