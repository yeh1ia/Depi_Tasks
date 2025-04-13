
package Tasks_21_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Task_6 {

    EdgeDriver Driver = new EdgeDriver();

    @BeforeMethod
    void setup()
    {
        Driver.get("http://automationexercise.com");
    }

    @Test
    void Contact_Us_Form() throws InterruptedException {
        SoftAssert Soft = new SoftAssert();

        //Verify that home page is visible successfully
        boolean x = Driver.findElements(By.cssSelector("img[src=\"/static/images/home/logo.png\"]")).isEmpty();
        Soft.assertEquals(x, false);

        //Click on 'Contact Us' button
        Driver.findElement(By.cssSelector("a[href=\"/contact_us\"]")).click();

        //Verify 'GET IN TOUCH' is visible
        boolean y = Driver.findElements(By.xpath("//h2[.=\"Get In Touch\"]")).isEmpty();
        Soft.assertEquals(y, false);

        //Enter name, email, subject and message
        Driver.findElement(By.cssSelector("input[name=\"name\"]")).sendKeys("Yehia Fargaly");
        Driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("yahyaezzat51@gmail.com");
        Driver.findElement(By.cssSelector("input[name=\"subject\"]")).sendKeys("Automation Task");
        Driver.findElement(By.cssSelector("textarea[id=\"message\"]")).sendKeys("Hello This is My New Automation Task ");

        //Upload file
        Driver.findElement(By.cssSelector("input[name=\"upload_file\"]")).sendKeys("F:\\HTB_Notes\\BlockBlock\\Notes.md");

        //Click submit button using JavaScript executor to avoid ElementClickInterceptedException
        WebElement submitButton = Driver.findElement(By.cssSelector("input[name=\"submit\"]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver;

        // Scroll to the submit button first
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500); // Give a moment for the page to settle

        // Use JavaScript to click the button
        js.executeScript("arguments[0].click();", submitButton);

        //Handle alert popup
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept(); // Clicks OK

        //Verify success message
        boolean z = Driver.findElements(By.cssSelector("div[class=\"status alert alert-success\"]")).isEmpty();
        Soft.assertEquals(z, false);

        //Assert all the soft assertions
        Soft.assertAll();
    }
    @AfterMethod
    void end() throws InterruptedException {
        Thread.sleep(5000);
        Driver.quit();
    }
}

