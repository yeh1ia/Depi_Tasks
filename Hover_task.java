import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hover_task {
    FirefoxDriver Driver ;

    @BeforeMethod
    void setup()
    {
        Driver = new FirefoxDriver();

        Driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    void tc_b()
    {

        Actions act = new Actions(Driver);
        act.moveToElement(Driver.findElement(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]"))).perform();

        Driver.findElement(By.linkText("View profile")).click();
    }
    @AfterMethod

    void close() throws InterruptedException {
        Thread.sleep(5000);
        Driver.quit();

    }
}
