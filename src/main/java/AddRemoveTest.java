import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class AddRemoveTest {
    WebDriver driver;

    @BeforeMethod

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void AddRemoveTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement Add = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        Add.click();
        Add.click();
        WebElement Del = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        Del.click();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
