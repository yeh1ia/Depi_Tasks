import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.DataProviderInvocationException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Driven {
    EdgeDriver Driver;

    @BeforeMethod
    void setup()
    {
        Driver = new EdgeDriver();
        Driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "Login" , enabled = true) // parameter priority = 0  , enabled = false if it false copmlier will comment test case , dependsonMethod = {"TC_B"} dependson stronger than priority ,invocationCount = 3 this repeat test cases 3 times
    void TC_0(String username , String Password)
    {
        SoftAssert Soft = new SoftAssert();

        // username
        Driver.findElement(By.id("user-name")).sendKeys(username);
        // Password
        Driver.findElement(By.id("password")).sendKeys(Password);
        // submit
        Driver.findElement(By.name("login-button")).click();

        boolean x = Driver.findElements(By.className("app_logo")).isEmpty();

        // Different between findElements , findElement (findElements more handling error)

        Soft.assertEquals(x,false);

        Soft.assertAll();
    }

    @DataProvider(name = "Login")
    String[][] GiveData() {
        String[][] Data = {

                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}


        };
        return Data;
    }

    @Test(priority = 0 , dependsOnMethods = {"TC_2"} , enabled = true , invocationCount = 2)
    void TC_1()
    {
        Driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Password
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // submit
        Driver.findElement(By.name("login-button")).click();

        boolean x = Driver.findElements(By.className("app_logo")).isEmpty();

        // Different between findElements , findElement (findElements more handling error)
        SoftAssert Soft = new SoftAssert();

        Soft.assertEquals(x,false);
    }

    @Test(priority = 0)
    void TC_2()
    {
        Driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        // Password
        Driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // submit
        Driver.findElement(By.name("login-button")).click();

        boolean x = Driver.findElements(By.className("app_logo")).isEmpty();

        // Different between findElements , findElement (findElements more handling error)
        SoftAssert Soft = new SoftAssert();

        Soft.assertEquals(x,false);
    }





















    @AfterMethod
    void end() throws InterruptedException {
        Thread.sleep(2000);
        Driver.quit();
    }
}
