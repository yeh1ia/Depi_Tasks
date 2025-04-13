package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task_13 {

    EdgeDriver Driver = new EdgeDriver();

    @BeforeMethod

    void setup()
        {
            Driver.get("http://automationexercise.com");
        }

        @Test
        void TC_13()
        {
            SoftAssert Soft =new SoftAssert();

            // 1- Verify that home page is visible successfully
            boolean x = Driver.findElements(By.cssSelector("img[alt=\"Website for automation practice\"]")).isEmpty();
            Soft.assertEquals(x,false);

            Driver.findElement(By.cssSelector("a[href=\"/product_details/4\"]")).click();

            boolean y = Driver.findElements(By.className("cart")).isEmpty();
            Soft.assertEquals(y,false);

            Driver.findElement(By.id("quantity")).clear();
            Driver.findElement(By.id("quantity")).sendKeys("4");

            Driver.findElement(By.className("cart")).click();
            Driver.findElement(By.xpath("//a[.=\"View Cart\"]//parent::a")).click();






        }

    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
     //   Driver.quit();

    }








}
