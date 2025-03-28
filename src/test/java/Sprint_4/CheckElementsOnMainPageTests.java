package Sprint_4;

import Sprint_4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class CheckElementsOnMainPageTests {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
    }
    @Test
    public void checkFirstListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickFirstListButton();
        assertTrue(mainPage.checkFirstAnswerListButton());
    }
    @Test
    public void checkSecondListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickSecondListButton();
        assertTrue(mainPage.checkSecondAnswerListButton());
    }
    @Test
    public void checkThirdListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickThirdListButton();
        assertTrue(mainPage.checkThirdAnswerListButton());
    }
    @Test
    public void checkFourthListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickFourthListButton();
        assertTrue(mainPage.checkFourthAnswerListButton());
    }
    @Test
    public void checkFifthListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickFifthListButton();
        assertTrue(mainPage.checkFifthAnswerListButton());
    }
    @Test
    public void checkSixthListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickSixthListButton();
        assertTrue(mainPage.checkSixthAnswerListButton());
    }
    @Test
    public void checkSeventhListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickSeventhListButton();
        assertTrue(mainPage.checkSeventhAnswerListButton());
    }
    @Test
    public void checkEighthListButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
        mainPage.clickEighthListButton();
        assertTrue(mainPage.checkEighthAnswerListButton());
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}