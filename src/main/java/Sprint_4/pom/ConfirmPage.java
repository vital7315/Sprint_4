package Sprint_4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    //Окно подтверждения заказа

    //Кнопка "Да"
    private By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    private final WebDriver webDriver;

    public ConfirmPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickYesButton() {
        webDriver.findElement(yesButton).click();
    }
}
