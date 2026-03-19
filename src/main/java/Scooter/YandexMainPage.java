package Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexMainPage {
    private WebDriver driver;
    String originalWindow;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void saveCurrentWindow(){
        originalWindow = driver.getWindowHandle();
    }

    public void waitForNewWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.getWindowHandles().size() > 1);
    }

    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void waitForLoadYandexPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dzen-layout--desktop-base-header__logoContainer-pu dzen-layout--desktop-base-header__isMorda-2n']")));
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

}
