package Sprint_4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrderPage {
    //Окно успешного оформления заказа

    //Сообщение "Заказ оформлен"
    private final By successMessage = By.xpath("//*[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");

    private final WebDriver webDriver;

    public SuccessfulOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean isOrderMessageDisplayed(){
        return webDriver.findElement(successMessage).isDisplayed();
    }
}
