package sprint4;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

//Прячем Before и After для всех 3х тестовых классов (для чистоты кода)
public class BaseTest {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.webDriver = new ChromeDriver(options);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
            webDriver.quit();
    }
}