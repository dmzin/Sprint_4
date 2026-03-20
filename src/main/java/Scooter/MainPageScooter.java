package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageScooter {
    private WebDriver driver;
    // Кнопка да все привыкли в куки
    private By cookieButton = By.id("rcc-confirm-button");
    // Кнопка Заказать вверху страницы
    private By orderUpperButton = By.xpath("//button[@class='Button_Button__ra12g']");
    // Кнопка Заказать внизу страницы
    private By orderLowerButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Выпадающий список в разделе «Вопросы о важном»
    private By listOfImportantQuestionsField = By.className("accordion__button");
    // Текст в пункте раздела «Вопросы о важном»
    private By textInListOfImportantQuestionsField = By.className("accordion__panel");
    // Логотип Самоката
    private By scooterLogo = By.xpath("//img[@alt='Scooter']");
    // Логотип Яндекса
    private By yandexLogo = By.xpath("//img[@alt='Yandex']");
    // Кнопка Статус заказа
    private By statusOrderButton = By.xpath("//button[contains(text(),'Статус заказа')]");
    // Поле ввода номера заказа
    private By inputOrderNumberField = By.xpath("//input[@placeholder='Введите номер заказа']");
    // Кнопка Go!
    private By goButton = By.xpath("//button[contains(text(),'Go!')]");
    // Главная страница Яндекс Самоката
    private By scooterMainPage = By.className("Home_HomePage__ZXKIX");
    // Картинка такого заказа нет
    private By noOrderPicture = By.xpath("//img[@alt='Not found']");


    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderUpperButton() {
        driver.findElement(orderUpperButton).click();
    }

    public void clickOrderLowerButton() {
        WebElement lowerButton = driver.findElement(orderLowerButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lowerButton);
        lowerButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderLowerButton));
        lowerButton.click();
    }

    public String getQuestionText(int index) {
        List<WebElement> questions = driver.findElements(listOfImportantQuestionsField);
        WebElement question = questions.get(index);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        return question.getText();
    }

    public void clickQuestion(int index) {
        List<WebElement> questions = driver.findElements(listOfImportantQuestionsField);
        WebElement question = questions.get(index);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(question));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }

    public String getAnswerText(int index) {
        List<WebElement> answers = driver.findElements(textInListOfImportantQuestionsField);
        WebElement answer = answers.get(index);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(answer));
        return answer.getText();
    }

    public void clickLogoScooter() {
        driver.findElement(scooterLogo).click();
    }

    public void waitForLoadHomePage(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(scooterMainPage));
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void clickLogoYandex() {
        driver.findElement(yandexLogo).click();
    }

    public void clickStatusOrderButton() {
        driver.findElement(statusOrderButton).click();
    }

    public void setOrderNumber(String orderNumber) {
        WebElement orderNumberField = driver.findElement(inputOrderNumberField);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(orderNumberField));
        orderNumberField.sendKeys(orderNumber);
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void waitForLoadErrorOrderPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(noOrderPicture));
    }

    public WebElement getNoOrderPicture() {
        return driver.findElement(noOrderPicture);
    }

}
