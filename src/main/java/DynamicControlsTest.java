import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControlsTest {

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

    public void DynamicControlsTest1() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's back!"));

    }

    @Test
    public void DynamicControlsTest2() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's disabled!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
