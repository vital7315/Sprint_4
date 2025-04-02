package sprint4;

import org.openqa.selenium.support.ui.ExpectedConditions;
import sprint4.pom.MainPage;
import org.junit.Before;
import org.junit.Test;
import sprint4.pom.OrderPage;
import static org.junit.Assert.assertTrue;

public class CheckNavigationForOrderButtonsTests extends BaseTest {

    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void additionalSetUp() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        orderPage = new OrderPage(webDriver);
    }

    @Test
    public void checkNavigationForUpOrderButtonTest() {
        mainPage.clickUpOrderButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                orderPage.forWhomScooterForm
        ));
        assertTrue(webDriver.findElement(orderPage.forWhomScooterForm).isDisplayed());
    }

    @Test
    public void checkNavigationForDownOrderButtonTest() {
        mainPage.scrollToDownOrderButton();
        mainPage.clickDownOrderButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                orderPage.forWhomScooterForm
        ));
        assertTrue(webDriver.findElement(orderPage.forWhomScooterForm).isDisplayed());
    }
}


