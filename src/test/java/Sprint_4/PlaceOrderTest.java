package Sprint_4;

import Sprint_4.pom.*;
import Sprint_4.pom.AboutOrder;
import Sprint_4.pom.OrderPage;
import Sprint_4.pom.MainPage;
import Sprint_4.pom.ConfirmPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PlaceOrderTest {

    WebDriver webDriver;
    OrderPage orderPage;
    MainPage mainPage;
    AboutOrder aboutOrder;
    ConfirmPage confirmPage;
    SuccessfulOrderPage successfulOrderPage;

    private final String firstNameField;
    private final String secondNameField;
    private final String addressField;
    private final String phoneField;
    private final String commentField;

    public PlaceOrderTest(String firstNameField, String secondNameField, String addressField, String phoneField, String commentField){
    this.firstNameField = firstNameField;
    this.secondNameField = secondNameField;
    this.addressField = addressField;
    this.phoneField = phoneField;
    this.commentField = commentField;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {
                        "Иван", "Иванов", "ул. Ленина, 1", "79991112233",
                        "Позвонить за час"
                },
                {
                        "Петр", "Петров", "ул. Пушкина, 2", "79994445566",
                        "Не звонить"
                }
        });
}
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickUpOrderButton();
        Thread.sleep(5000);
        orderPage = new OrderPage(webDriver);
        orderPage.fillingMetroStation();
    }
    @Test
    public void assurancePlaceOrderTest() throws InterruptedException {
        orderPage = new OrderPage(webDriver);
        orderPage.fillingFirstNameField(firstNameField);
        orderPage.fillingSecondNameField(secondNameField);
        orderPage.fillingAddressField(addressField);
        orderPage.fillingPhone(phoneField);
        orderPage.clickNextButton();

        aboutOrder = new AboutOrder(webDriver);
        aboutOrder.setWhenToDeliveryScooter();
        aboutOrder.setLastsRent();
        aboutOrder.setColourOfScooter();
        aboutOrder.fillingCommentField(commentField);
        aboutOrder.clickOrderButton();

        Thread.sleep(5000);
        confirmPage = new ConfirmPage(webDriver);
        confirmPage.clickYesButton();

        Thread.sleep(5000);
        successfulOrderPage = new SuccessfulOrderPage(webDriver);
        Assert.assertTrue("Должно отображаться сообщение об успешном заказе",
                successfulOrderPage.isOrderMessageDisplayed());
        }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}






