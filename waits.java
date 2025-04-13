package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class waits {

    EdgeDriver Driver;

    @BeforeMethod
     void setup()
    {
        Driver = new EdgeDriver();
        Driver.get("https://the-internet.herokuapp.com/hovers");
        Driver.manage().window().maximize();
    }

    @Test
    void TC_1()
    {
        Actions Act = new Actions(Driver);
        Act.moveToElement(Driver.findElement(By.cssSelector("img[src=\"/img/avatar-blank.jpg\"]"))).perform();

        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("View profile")));

        Driver.findElement(By.linkText("View profile")).click();

        boolean x = Driver.getCurrentUrl().contains("users");

        Assert.assertEquals( x ,true);


    }


}
