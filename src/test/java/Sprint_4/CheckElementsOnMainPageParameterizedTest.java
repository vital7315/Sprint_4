package Sprint_4;

import Sprint_4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckElementsOnMainPageParameterizedTest {

private final By listButton;
private final By textAnswer;
WebDriver webDriver;
MainPage mainPage;

public CheckElementsOnMainPageParameterizedTest(By listButton, By textAnswer) {
    this.listButton = listButton;
    this.textAnswer = textAnswer;
}
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {MainPage.FIRST_LIST_BUTTON, MainPage.FIRST_ANSWER_LIST_BUTTON},
                {MainPage.SECOND_LIST_BUTTON, MainPage.SECOND_ANSWER_LIST_BUTTON},
                {MainPage.THIRD_LIST_BUTTON, MainPage.THIRD_ANSWER_LIST_BUTTON},
                {MainPage.FOURTH_LIST_BUTTON, MainPage.FOURTH_ANSWER_LIST_BUTTON},
                {MainPage.FIFTH_LIST_BUTTON, MainPage.FIFTH_ANSWER_LIST_BUTTON},
                {MainPage.SIXTH_LIST_BUTTON, MainPage.SIXTH_ANSWER_LIST_BUTTON},
                {MainPage.SEVENTH_LIST_BUTTON, MainPage.SEVENTH_ANSWER_LIST_BUTTON},
                {MainPage.EIGHTH_LIST_BUTTON, MainPage.EIGHTH_ANSWER_LIST_BUTTON}
        });
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
        mainPage.scrollToTextImportantQuestionsFor();
    }
    @Test
    public void checkListButton() throws InterruptedException {
        webDriver.findElement(listButton).click();
        Thread.sleep(5000);
        assertTrue(webDriver.findElement(textAnswer).isDisplayed());
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
