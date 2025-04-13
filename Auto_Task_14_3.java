import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_Task_14_3 {
    FirefoxDriver Driver ;
    @BeforeMethod

    void setup()
    {
        Driver = new FirefoxDriver();

        Driver.get("https://automationexercise.com/signup");
    }

    @Test //  Enter Values In Sign Up Page
    void TC_1() throws InterruptedException {

        Driver.findElement(By.name("name")).sendKeys("Yehia");// Enter Username
        // xpath By.xpath("//input[@data-qa=\"signup-email\"]")
        Driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys("LOL11@LOL.com");
        Driver.findElements(By.className("btn")).get(1).click();
        Driver.findElement(By.id("id_gender1")).click();
        Driver.findElement(By.id("password")).sendKeys("LOL123");
        WebElement ele = Driver.findElement(By.id("days"));
        Select sel = new Select(ele);
        sel.selectByVisibleText("13");
        WebElement ele2 = Driver.findElement(By.id("months"));
        Select sel2 = new Select(ele2);
        sel2.selectByVisibleText("November");
        WebElement ele3 = Driver.findElement(By.id("years"));
        Select sel3 = new Select(ele3);
        sel3.selectByVisibleText("2003");
        Driver.findElement(By.id("first_name")).sendKeys("LOL");
        Driver.findElement(By.id("last_name")).sendKeys("TOLL");
        Driver.findElement(By.id("company")).sendKeys("BMW");
        Driver.findElement(By.name("address1")).sendKeys("123 streat cairo");

        WebElement ele4 = Driver.findElement(By.id("country"));
        Select sel4 = new Select(ele4);
        sel4.selectByValue("Singapore");

        Driver.findElement(By.id("state")).sendKeys("Cairo");
        Driver.findElement(By.id("city")).sendKeys("Cairo");
        Driver.findElement(By.id("zipcode")).sendKeys("11111");
        Driver.findElement(By.id("mobile_number")).sendKeys("232038392802");
        Driver.findElement(By.className("btn-default")).click();
        Thread.sleep(3000);
    }



    @AfterMethod

    void close() throws InterruptedException {
        Thread.sleep(5000);
        Driver.quit();

    }
}
