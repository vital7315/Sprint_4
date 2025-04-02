package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    //Страница заказа

    //Название формы заказа: "Для кого самокат"
    public final By forWhomScooterForm = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Header__BZXOb");
    //Поле "Имя"
    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Кнопка в выпадающем списке поля "Станция метро" - "Бульвар Рокоссовского"
    private final By bulvarRokossovskogo = By.xpath(".//div[@class='Order_Text__2broi' and text()='Черкизовская']");
    //Поле "Телефон"
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By next = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    private final WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void fillingMetroStation() {
        webDriver.findElement(metroStation).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                bulvarRokossovskogo)).click();

    }
    public void fillingFirstNameField(String firstName){
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }
    public void fillingSecondNameField(String secondName) {
        webDriver.findElement(secondNameField).sendKeys(secondName);
    }
    public void fillingAddressField(String address){
        webDriver.findElement(addressField).sendKeys(address);
    }
    public void fillingPhone(String phone){
        webDriver.findElement(phoneField).sendKeys(phone);
    }
    public void clickNextButton(){
        webDriver.findElement(next).click();
    }
}