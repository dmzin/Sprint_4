package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationPage {
    private WebDriver driver;

    // Кнопка Да
    private By agreeButton = By.xpath ("//button[contains(text(),'Да')]");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgreeButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(agreeButton));
        driver.findElement(agreeButton).click();
    }

    // Сообщение, что заказ оформлен
    private By successfulOrder = By.className("Order_ModalHeader__3FDaJ");

    public void waitForSuccessfulOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(successfulOrder));
    }

    public String getSuccessfulOrderText(){
        return driver.findElement(successfulOrder).getText();
    }
}
