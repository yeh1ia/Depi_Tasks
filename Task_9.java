package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task_9 {

    ChromeDriver Driver = new ChromeDriver();

    @BeforeMethod
    void setup()
    {
        Driver.get("http://automationexercise.com");

    }
    @Test
    void Search()
    {
        SoftAssert Soft =new SoftAssert();

        // 1- Verify that home page is visible successfully
        boolean x = Driver.findElements(By.cssSelector("img[alt=\"Website for automation practice\"]")).isEmpty();
        Soft.assertEquals(x,false);

        // 2- Click on Products Button
        Driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        // 3- Verfiy that products page is visible successfully
        boolean y = Driver.findElements(By.className("form-control")).isEmpty();
        Soft.assertEquals(y , false);

        // 4-Enter product name in search input and click search button

        Driver.findElement(By.id("search_product")).click();

        Driver.findElement(By.id("search_product")).sendKeys("pink");

        Driver.findElement(By.id("submit_search")).click();

        // 5- Verify 'SEARCHED PRODUCTS' is visible
        boolean z = Driver.findElements(By.cssSelector("img[src=\"/get_product_picture/12\"]")).isEmpty();
        Soft.assertEquals(z,false);

        // 6- Verify all the products related to search are visible
        boolean p = Driver.findElements(By.cssSelector("img[alt=\"ecommerce website products\"]")).isEmpty();
        Soft.assertEquals(p,false);

        Soft.assertAll(); // To Ensure that if one of the test cases fail all will be fail

    }
    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }

}
