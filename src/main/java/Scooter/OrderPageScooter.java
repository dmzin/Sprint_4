package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageScooter {
    private WebDriver driver;

    // Поле имя
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    // Поле фамилия
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле адрес
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле станция метро
    private By metroField = By.className("select-search__input");
    // Поле телефон
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private By furtherButton = By.xpath("//button[contains(text(),'Далее')]");
    // Ошибка под полем имя
    private By nameError = By.xpath("//input[@placeholder='* Имя']/following-sibling::div");
    // Ошибка под полем фамилия
    private By surnameError = By.xpath("//input[@placeholder='* Фамилия']/following-sibling::div");
    // Ошибка под полем станция метро
    private By metroError = By.className("Order_MetroError__1BtZb");
    // Ошибка под полем телефон
    private By phoneError = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']/following-sibling::div");

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(username);
    }

    public void setUserSurname(String surname) {

        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setUserAddress(String address) {

        driver.findElement(addressField).sendKeys(address);
    }

    public void clickMetroField() {

        driver.findElement(metroField).click();
    }

    public void selectMetroStation(String stationName) {
        driver.findElement(By.xpath("//div[text()='" + stationName + "']")).click();
    }

    public void setUserPhone(String phone) {

        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickFurtherButton() {

        driver.findElement(furtherButton).click();
    }

    public void fillOrderForm(String username, String surname, String address, String stationName, String phone) {
        setUserName(username);
        setUserSurname(surname);
        setUserAddress(address);
        clickMetroField();
        selectMetroStation(stationName);
        setUserPhone(phone);
        clickFurtherButton();
    }

    public String getNameError() {
        return driver.findElement(nameError).getText();
    }

    public String getSurnameError() {
        return driver.findElement(surnameError).getText();
    }

    public String getMetroError() {
        return driver.findElement(metroError).getText();
    }

    public String getPhoneError() {
        return driver.findElement(phoneError).getText();
    }

}
