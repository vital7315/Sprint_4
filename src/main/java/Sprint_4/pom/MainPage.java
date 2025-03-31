package Sprint_4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {

    // URL страницы
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Локаторы элементов
    // Первый вопрос:
    public static final By FIRST_LIST_BUTTON = By.xpath("//div[contains(text(), 'Сколько это стоит? И как оплатить?')]");
    // Текст ответа на первый вопрос: "Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    public static final By FIRST_ANSWER_LIST_BUTTON = By.xpath("//p[contains(text(), 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]");
    // Второй вопрос: "Хочу сразу несколько самокатов! Так можно?"
    public static final By SECOND_LIST_BUTTON = By.id("accordion__heading-1");
    // Текст ответа на второй вопрос: "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
    public static final By SECOND_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-1 > p");
    // Третий вопрос: "Как рассчитывается время аренды?"
    public static final By THIRD_LIST_BUTTON = By.id("accordion__heading-2");
    // Текст ответа на третий вопрос: "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    public static final By THIRD_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-2 > p");
    // Четвёртый вопрос: "Можно ли заказать самокат прямо на сегодня?"
    public static final By FOURTH_LIST_BUTTON = By.id("accordion__heading-3");
    // Текст ответа на четвёртый вопрос: "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    public static final By FOURTH_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-3 > p");
    // Пятый вопрос: "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By FIFTH_LIST_BUTTON = By.id("accordion__heading-4");
    // Текст ответа на пятый вопрос: "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    public static final By FIFTH_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-4 > p");
    // Шестой вопрос: "Вы привозите зарядку вместе с самокатом?"
    public static final By SIXTH_LIST_BUTTON = By.id("accordion__heading-5");
    // Текст ответа на шестой вопрос: "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
    public static final By SIXTH_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-5 > p");
    // Седьмой вопрос: "Можно ли отменить заказ?"
    public static final By SEVENTH_LIST_BUTTON = By.id("accordion__heading-6");
    // Текст ответа на седьмой вопрос: "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    public static final By SEVENTH_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-6 > p");
    // Восьмой вопрос: "Я живу за МКАДом, привезёте?"
    public static final By EIGHTH_LIST_BUTTON = By.xpath("//div[contains(text(), 'Я жизу за МКАДом, привезёте?')]");
    // Текст ответа на восьмой вопрос: "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    public static final By EIGHTH_ANSWER_LIST_BUTTON = By.cssSelector("#accordion__panel-7 > p");
    // Верхняя кнопка "Заказать"
    private final By upOrderButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    //Нижняя кнопка "Заказать"
    private final By downOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void open() {
        webDriver.get(URL);
    }
    public void scrollToTextImportantQuestionsFor() {
        WebElement element = webDriver.findElement(EIGHTH_LIST_BUTTON);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickFirstListButton() {
        webDriver.findElement(FIRST_LIST_BUTTON).click();

    }
    public boolean checkFirstAnswerListButton() {
        return webDriver.findElement(FIRST_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickSecondListButton() {
        webDriver.findElement(SECOND_LIST_BUTTON).click();
    }
    public boolean checkSecondAnswerListButton() {
        return webDriver.findElement(SECOND_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickThirdListButton() {
        webDriver.findElement(THIRD_LIST_BUTTON).click();
    }
    public boolean checkThirdAnswerListButton() {
        return webDriver.findElement(THIRD_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickFourthListButton() {
        webDriver.findElement(FOURTH_LIST_BUTTON).click();
    }
    public boolean checkFourthAnswerListButton() {
        return webDriver.findElement(FOURTH_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickFifthListButton() {
        webDriver.findElement(FIFTH_LIST_BUTTON).click();
    }
    public boolean checkFifthAnswerListButton() {
        return webDriver.findElement(FIFTH_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickSixthListButton() {
        webDriver.findElement(SIXTH_LIST_BUTTON).click();
    }
    public boolean checkSixthAnswerListButton() {
        return webDriver.findElement(SIXTH_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickSeventhListButton() {
        webDriver.findElement(SEVENTH_LIST_BUTTON).click();
    }
    public boolean checkSeventhAnswerListButton() {
        return webDriver.findElement(SEVENTH_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickEighthListButton() {
        webDriver.findElement(EIGHTH_LIST_BUTTON).click();
    }
    public boolean checkEighthAnswerListButton() {
        return webDriver.findElement(EIGHTH_ANSWER_LIST_BUTTON).isDisplayed();
    }
    public void clickUpOrderButton() {
        webDriver.findElement(upOrderButton).click();
    }
    public void clickDownOrderButton() {
        webDriver.findElement(downOrderButton).click();
    }
    public void scrollToDownOrderButton() {
        WebElement element = webDriver.findElement(downOrderButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}