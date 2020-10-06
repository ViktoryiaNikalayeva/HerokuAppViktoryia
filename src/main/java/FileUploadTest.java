import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FileUploadTest {

    ChromeDriver driver;
    WebDriverWait wait;


    @BeforeMethod

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test

    public void FileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("drag-drop-upload")).click();
        driver.findElement(By.xpath("'C:'+File.separator+'Users'+File.separator+'Теория Циклы.pdf'"));
        driver.findElement(By.name("Upload")).click();
        WebElement Upload = driver.findElement(By.id("uploaded-files"));
        assertEquals(Upload, "Теория Циклы.pdf", "Должно быть Теория Циклы.pdf");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
