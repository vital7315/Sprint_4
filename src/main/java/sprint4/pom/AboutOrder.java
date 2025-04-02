package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutOrder {
    //Страница "Про аренду"

    //Поле "Когда привезти самокат"
    public By whenToDeliveryScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Конкретная дата 06.03.2025 в календаре
    private By dateDelivery = By.xpath("//div[@aria-label='Choose воскресенье, 6-е апреля 2025 г.']");
    //Поле "Срок аренды"
    private By lastsRent = By.xpath(".//div[contains(@class, 'Dropdown-placeholder') and text()='* Срок аренды']");
    //Кнопка "сутки"
    private By oneDay = By.cssSelector("div.Dropdown-menu div:first-child");
    //Чек-бокс "Чёрный жемчуг"
    private By blackPearl = By.xpath(".//input[@id='black']");
    //Поле "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//*[starts-with(@class,'Order_Content')]//button[text()='Заказать']");

    private final WebDriver webDriver;

    public AboutOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void setWhenToDeliveryScooter() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(whenToDeliveryScooter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dateDelivery)).click();
        webDriver.findElement(whenToDeliveryScooter).sendKeys(Keys.ESCAPE);
    }
    public void setLastsRent() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].scrollIntoView(true);",
                webDriver.findElement(lastsRent)
        );
        wait.until(ExpectedConditions.elementToBeClickable(lastsRent)).click();
        wait.until(ExpectedConditions.elementToBeClickable(oneDay)).click();
    }

    public void setColourOfScooter() {
        webDriver.findElement(blackPearl).click();
    }
    public void fillingCommentField(String comment) {
        webDriver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }
}
