package Sprint_4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutOrder {
    //Страница "Про аренду"

    //Поле "Когда привезти самокат"
    private By whenToDeliveryScooter = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    //Конкретная дата 06.03.2025 в календаре
    private By dateDelivery = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[6]/div[7]");
    //Поле "Срок аренды"
    private By lastsRent = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root > div > div.Dropdown-placeholder");
    //Кнопка "сутки"
    private By oneDay = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //Чек-бокс "Чёрный жемчуг"
    private By blackPearl = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]/input");
    //Поле "Комментарий для курьера"
    private By commentField = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");
    //Кнопка "Заказать"
    private By orderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");

    private final WebDriver webDriver;

    public AboutOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void setWhenToDeliveryScooter() throws InterruptedException {
        webDriver.findElement(whenToDeliveryScooter).click();
        Thread.sleep(5000);
        webDriver.findElement(dateDelivery).click();
    }
    public void setLastsRent() {
        webDriver.findElement(lastsRent).click();
        webDriver.findElement(oneDay).click();
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
