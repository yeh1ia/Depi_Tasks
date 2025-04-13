package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task_12 {
    ChromeDriver Driver = new ChromeDriver();
    @BeforeMethod
    void setup()
    {
        Driver.get("http://automationexercise.com");

    }

    @Test
    void Add_to_card() throws InterruptedException {
        SoftAssert Soft =new SoftAssert();

        // 1- Verify that home page is visible successfully
        boolean x = Driver.findElements(By.cssSelector("img[alt=\"Website for automation practice\"]")).isEmpty();
        Soft.assertEquals(x,false);

        // 2- Click on Products Button
        Driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        Actions act = new Actions(Driver);

        act.moveToElement(Driver.findElement(By.cssSelector("img[src=\"/get_product_picture/1\"]"))).perform();

        Driver.findElement(By.xpath("(//a[normalize-space()='Add to cart'])[2]")).click();
        Thread.sleep(2000);


    }


    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }






}
