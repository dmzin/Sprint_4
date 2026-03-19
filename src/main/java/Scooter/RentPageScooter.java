package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentPageScooter {
    private WebDriver driver;

    // Поле когда привезти самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле срок аренды
    private By rentalField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Кнопка Заказать
    private By orderButton = By.xpath("(//button[contains(text(),'Заказать')])[2]");

    public RentPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void setDeliveryDate(String date) {
        WebElement dateInField = driver.findElement(dateField);
        dateInField.sendKeys(date);
        dateInField.sendKeys(Keys.ENTER);
    }

    public void selectRentalPeriod(String period) {
        driver.findElement(rentalField).click();
        driver.findElement(By.xpath("//div[text()='" + period + "']")).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void fillRentForm(String date, String rentalPeriod){
        setDeliveryDate(date);
        selectRentalPeriod(rentalPeriod);
        clickOrderButton();
    }

}
