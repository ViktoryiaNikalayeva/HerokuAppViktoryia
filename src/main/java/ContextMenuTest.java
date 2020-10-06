
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContextMenuTest {
    ChromeDriver driver;



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

    public void ContextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        WebElement Card = driver.findElement(By.id("hot-spot"));
        action.contextClick(Card);
        Alert alert = driver.switchTo().alert();
        //WebElement Alert = driver.findElement(By.xpath("//*[contains(text(),'selected')]"));
        driver.findElement(By.cssSelector("OK")).click();

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
