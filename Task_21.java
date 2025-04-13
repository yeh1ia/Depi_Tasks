package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task_21 {

    EdgeDriver Driver = new EdgeDriver();

    @BeforeMethod
        void setup()
        {
            Driver.get("http://automationexercise.com");

        }

    @Test
    void TC_21()
    {

        SoftAssert Soft = new SoftAssert();

        Driver.findElement(By.cssSelector("[href=\"/products\"]")).click();

        boolean x = Driver.findElements(By.className("productinfo")).isEmpty();

        Soft.assertEquals(x,false);

        Driver.findElement(By.cssSelector("[href=\"/product_details/1\"]")).click();

        boolean y = Driver.findElements(By.id("button-review")).isEmpty();

        Soft.assertEquals(y,false);

        Driver.findElement(By.cssSelector("input[id=\"name\"]")).sendKeys("Yehia");
        Driver.findElement(By.cssSelector("input[id=\"email\"]")).sendKeys("yahyaezzat51@gmail.com");
        Driver.findElement(By.cssSelector("textarea[id=\"review\"]")).sendKeys("Hello World");
        Driver.findElement(By.cssSelector("button[id=\"button-review\"]")).click();

        boolean z = Driver.findElement(By.partialLinkText("Thank you for your review.")).isDisplayed();

        Soft.assertEquals(z,true);
    }

    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }
}
