package Tasks_21_3;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class File_Upload {

    EdgeDriver Driver = new EdgeDriver();

    @BeforeMethod
    void Setup()
    {
        Driver.get("https://the-internet.herokuapp.com/upload");
    }
    @Test
    void TC_1()
    {
        Driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\yehia\\Desktop\\Energy.txt");

        Driver.findElement(By.id("file-submit")).click();

        SoftAssert Soft = new SoftAssert();

        boolean x = Driver.findElements(By.id("uploaded-files")).isEmpty();


        Soft.assertEquals(x,false);


    }


}
