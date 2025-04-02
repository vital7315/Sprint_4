package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    //Окно подтверждения заказа

    //Кнопка "Да"
    public By yesButton = By.xpath("//button[text()='Да']");

    private final WebDriver webDriver;

    public ConfirmPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }
}
