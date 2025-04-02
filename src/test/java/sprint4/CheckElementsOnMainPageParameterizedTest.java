package sprint4;

import org.openqa.selenium.support.ui.ExpectedConditions;
import sprint4.pom.MainPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckElementsOnMainPageParameterizedTest extends BaseTest {

private final By listButton;
private final By textAnswer;

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
    public void additionalSetUp() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.scrollToTextImportantQuestionsFor();
    }
    @Test
    public void checkListButton() {
        webDriver.findElement(listButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAnswer));
        assertTrue(webDriver.findElement(textAnswer).isDisplayed());
    }
}
