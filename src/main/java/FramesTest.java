import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FramesTest {

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
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/a")).click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement Goes = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        assertEquals(Goes, "Your content goes here.", "Your content goes here.");





    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
