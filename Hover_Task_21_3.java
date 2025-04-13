package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hover_Task_21_3 {

        ChromeDriver Driver = new ChromeDriver();

        @BeforeMethod
        void setup()
        {

            Driver.get("https://the-internet.herokuapp.com/hovers");
        }

        @Test
        void tc_b()
        {

            Actions act = new Actions(Driver);
            act.moveToElement(Driver.findElement(By.xpath("//h5[.=\"name: user2\"]//parent::div//parent::div//img"))).perform();

            Driver.findElement(By.linkText("View profile")).click();
        }
        @AfterMethod

        void close() throws InterruptedException {
            Thread.sleep(5000);
            Driver.quit();

        }
    }


