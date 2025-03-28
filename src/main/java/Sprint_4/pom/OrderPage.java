package Sprint_4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    //Страница заказа

    //Поле "Имя"
    private final By firstNameField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(1) > input");
    //Поле "Фамилия"
    private final By secondNameField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(2) > input");
    //Поле "Адрес"
    private final By addressField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(3) > input");
    //Поле "Станция метро"
    private final By metroStation = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(4) > div > div > input");
    //Кнопка в выпадающем списке поля "Станция метро" - "Бульвар Рокоссовского"
    private final By bulvarRokossovskogo = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button/div[2]");
    //Поле "Телефон"
    private final By phoneField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(5) > input");
    //Кнопка "Далее"
    private final By next = By.xpath("/html/body/div/div/div[2]/div[3]/button");

    private final WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void fillingMetroStation() throws InterruptedException {
        webDriver.findElement(metroStation).click();
        Thread.sleep(5000);
        webDriver.findElement(bulvarRokossovskogo).click();
    }
    public void fillingFirstNameField(String firstName){
        webDriver.findElement(firstNameField).sendKeys(firstName);
    }
    public void fillingSecondNameField(String secondName) {
        webDriver.findElement(secondNameField).sendKeys(secondName);
    }
    public void fillingAddressField(String adress){
        webDriver.findElement(addressField).sendKeys(adress);
    }
    public void fillingPhone(String phone){
        webDriver.findElement(phoneField).sendKeys(phone);
    }
    public void clickNextButton(){
        webDriver.findElement(next).click();
    }
}