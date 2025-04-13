import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation_Task {
    public static void main(String[] args) throws InterruptedException {

        FirefoxDriver Driver = new FirefoxDriver();

        Driver.get("https://www.saucedemo.com/");
        // Username
        Driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Password
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // submit
        Driver.findElement(By.name("login-button")).click();
        // Click_Option
        Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        Driver.findElement(By.id("logout_sidebar_link")).click();
        // Sleep
        Thread.sleep(3000);
        Driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.findElement(By.name("login-button")).click();
        Driver.navigate().refresh();
        //Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        //Driver.findElement(By.id("logout_sidebar_link")).click();
        //Thread.sleep(3000);
        Driver.findElement(By.id("user-name")).sendKeys("problem_user");
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.findElement(By.name("login-button")).click();
        Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        Driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(3000);
        Driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.findElement(By.name("login-button")).click();
        Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        Driver.findElement(By.id("logout_sidebar_link")).click();
        //Thread.sleep(3000);
        Driver.findElement(By.id("user-name")).sendKeys("error_user");
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.findElement(By.name("login-button")).click();
        Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        Driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(3000);
        Driver.findElement(By.id("user-name")).sendKeys("visual_user");
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.findElement(By.name("login-button")).click();
        Driver.findElement(By.id("react-burger-menu-btn")).click();
        // Click_Logout
        Driver.findElement(By.id("logout_sidebar_link")).click();

    }
}
