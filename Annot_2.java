import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Annot_2 {
    FirefoxDriver Driver ;
    @BeforeTest

    void setup()
    {
        Driver = new FirefoxDriver();

        Driver.get("https://www.saucedemo.com/");
    }

    @Test

    void TC_A() throws InterruptedException {
        Driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Password
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // submit
        Driver.findElement(By.name("login-button")).click();
        Thread.sleep(2000);
        Driver.findElement(By.id("react-burger-menu-btn")).click();

        Driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @Test
    void TC_B() throws InterruptedException {
        Driver.findElement(By.id("user-name")).sendKeys("visual_user");
        Driver.findElement(By.id("password")).sendKeys("secre12t_sauce");
        Driver.findElement(By.name("login-button")).click();
        Thread.sleep(2000);
        Driver.findElement(By.id("react-burger-menu-btn")).click();

        Driver.findElement(By.id("logout_sidebar_link")).click();


    }

    @AfterTest

    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();

    }
}
