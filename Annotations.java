import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

    FirefoxDriver Driver ;
    @BeforeMethod

    void setup()
    {
        Driver = new FirefoxDriver();

        Driver.get("https://www.saucedemo.com/");
    }

    @Test

    void TC_A()
    {
        Driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Password
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // submit
        Driver.findElement(By.name("login-button")).click();


    }

    @Test
    void TC_B()
    {
        Driver.findElement(By.id("user-name")).sendKeys("visual_user");
        Driver.findElement(By.id("password")).sendKeys("secre12t_sauce");
        Driver.findElement(By.name("login-button")).click();



    }

    @AfterMethod

    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }

}
