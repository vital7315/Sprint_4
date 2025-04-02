package sprint4;

import sprint4.pom.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PlaceOrderTest extends BaseTest {
    private OrderPage orderPage;
    private MainPage mainPage;
    private AboutOrder aboutOrder;
    private ConfirmPage confirmPage;
    private SuccessfulOrderPage successfulOrderPage;

    private final String firstNameField;
    private final String secondNameField;
    private final String addressField;
    private final String phoneField;
    private final String commentField;

    public PlaceOrderTest(String firstNameField, String secondNameField,
                          String addressField, String phoneField, String commentField) {
        this.firstNameField = firstNameField;
        this.secondNameField = secondNameField;
        this.addressField = addressField;
        this.phoneField = phoneField;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "ул. Ленина, 1", "79991112233", "Позвонить за час"},
                {"Петр", "Петров", "ул. Пушкина, 2", "79994445566", "Не звонить"}
        });
    }

    @Before
    public void additionalSetUp() {
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickUpOrderButton();

        orderPage = new OrderPage(webDriver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPage.forWhomScooterForm));
        orderPage.fillingMetroStation();
    }

    @Test
    public void assurancePlaceOrderTest() {
        orderPage.fillingFirstNameField(firstNameField);
        orderPage.fillingSecondNameField(secondNameField);
        orderPage.fillingAddressField(addressField);
        orderPage.fillingPhone(phoneField);
        orderPage.clickNextButton();

        aboutOrder = new AboutOrder(webDriver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutOrder.whenToDeliveryScooter));

        aboutOrder.setWhenToDeliveryScooter();
        aboutOrder.setLastsRent();
        aboutOrder.setColourOfScooter();
        aboutOrder.fillingCommentField(commentField);
        aboutOrder.clickOrderButton();

        confirmPage = new ConfirmPage(webDriver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPage.yesButton));
        confirmPage.clickYesButton();

        successfulOrderPage = new SuccessfulOrderPage(webDriver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulOrderPage.successMessage));
        Assert.assertTrue("Должно отображаться сообщение об успешном заказе",
                successfulOrderPage.isOrderMessageDisplayed());
    }
}





