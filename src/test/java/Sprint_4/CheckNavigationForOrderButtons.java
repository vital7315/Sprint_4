package Sprint_4;

import Sprint_4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class CheckNavigationForOrderButtons {

    WebDriver webDriver;
    MainPage mainPage;

    //Название формы заказа: "Для кого самокат"
    private By forWhomScooterFOrm = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Header__BZXOb");

    public CheckNavigationForOrderButtons() {
        this.webDriver = new ChromeDriver();
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(webDriver);
        mainPage.open();
    }
    @Test
    public void checkNavigaationForUpOrderButton() throws InterruptedException {
        mainPage.clickUpOrderButton();
        Thread.sleep(5000);
        assertTrue(webDriver.findElement(forWhomScooterFOrm).isDisplayed());
    }
    @Test
    public void checkNavigaationForDownOrderButton() throws InterruptedException {
        mainPage.scrollToDownOrderButton();
        mainPage.clickDownOrderButton();
        Thread.sleep(5000);
        assertTrue(webDriver.findElement(forWhomScooterFOrm).isDisplayed());
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}





