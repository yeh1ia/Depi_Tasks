import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Automation_task_21_3 {
    FirefoxDriver Driver = new FirefoxDriver();

    @BeforeMethod
    void setup()
    {
       Driver.get("https://the-internet.herokuapp.com/hover");
    }
//        @Test // Related With This Website https://www.saucedemo.com/
//        void Assertion_1()
//        {
//            Driver.findElement(By.id("user-name")).sendKeys("standard_user");
//            Driver.findElement(By.id("password")).sendKeys("secret_sauce");
//            Driver.findElement(By.id("login-button")).click();
//
//            boolean x = Driver.findElements(By.className("menu-item")).isEmpty(); // isEmpty Related With Source Code
//            //boolean x= Driver.findElement(By.className("app_logo")).isDisplayed(); // isDisplayed Related With UI Any Word on It
//            Assert.assertEquals(x,false); // Compare acutal results and Expected results
//        }
//        @Test
//        void Assertion_2()
//        {
//            Driver.findElement(By.id("user-name")).sendKeys("standard_user");
//            Driver.findElement(By.id("password")).sendKeys("se1332_sauce");
//            Driver.findElement(By.id("login-button")).click();
//
//            // hard assertion
//            //boolean x = Driver.findElements(By.cssSelector("h3[data-test=\"error\"]")).isEmpty(); // Error
//            boolean x= Driver.findElement(By.id("login-button")).isDisplayed();
//            Assert.assertEquals(x,true);
//        }

// Xpath //tagname[.="Linktext"]//parent::tagname//parent::tagname//tagname




    @Test
    void Dropdown()
    {


//        Select sel = new Select(Driver.findElement(By.id("dropdown")));
//        sel.selectByVisibleText("Option 2");
//
//        // soft Assertion
//        SoftAssert soft = new SoftAssert();
//        boolean x = Driver.findElement(By.cssSelector("option[value=\"2\"]")).isSelected();
//        soft.assertTrue(x);
    }

    @AfterMethod
    void close() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();
    }

}
