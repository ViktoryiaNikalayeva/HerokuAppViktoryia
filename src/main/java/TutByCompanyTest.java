import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class TutByCompanyTest {
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
    public void TutByСompanyTest() {
        driver.get("https://vitebsk.jobs.tut.by");
        WebElement Search = driver.findElement(By.name("text"));
        Search.sendKeys("водитель");
        WebElement Button = driver.findElement(By.className("supernova-search-submit-text"));
        Button.click();
       // WebElement Emp1 = driver.findElement(By.className("data-qa='vacancy-serp__vacancy-employer'"));
    }

    //1. Поиск по ключевому слову
//2. Получение имен 3 любых компаний из списка вакансий
// (либо по имени либо по индексу/номеру в списке) и вывод их в консоль
    // Подсказка: локаторы по принципу By.cssSelector("[data-qa=BLABLA]")
    // где вместо BLABLA - значение атрибута data-qa внутри верстки

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
