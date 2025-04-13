import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class F01_Login {

    public static void main(String[] args) throws InterruptedException {



        FirefoxDriver Driver = new FirefoxDriver();

        // Positive Senario
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("tomsmith");
        Driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Driver.findElement(By.className("fa-sign-in")).click();
        Thread.sleep(3000);
        // Negative Senario_1
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("tomswdmith");
        Driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Driver.findElement(By.className("fa-sign-in")).click();
        Thread.sleep(3000);
        // Negative Senario_2
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("tomsmith");
        Driver.findElement(By.id("password")).sendKeys("SuperSecretPassword11!");
        Driver.findElement(By.className("fa-sign-in")).click();
        Thread.sleep(3000);
        // Negative Senario_3
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("");
        Driver.findElement(By.id("password")).sendKeys("SuperSecretPassword11!");
        Driver.findElement(By.className("fa-sign-in")).click();
        Thread.sleep(3000);
        // Negative Senario_4
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("tomsmith");
        Driver.findElement(By.id("password")).sendKeys("");
        Driver.findElement(By.className("fa-sign-in")).click();
        Thread.sleep(3000);
        // Negative Senario_5
        Driver.get("https://the-internet.herokuapp.com/login");
        Driver.findElement(By.id("username")).sendKeys("");
        Driver.findElement(By.id("password")).sendKeys("");
        Driver.findElement(By.className("fa-sign-in")).click();



    }

}
