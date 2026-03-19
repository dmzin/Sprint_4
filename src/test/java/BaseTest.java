import Scooter.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
    WebDriver driver;
    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    MainPageScooter objMainPage;
    OrderPageScooter objOrderPage;
    RentPageScooter objRentPage;
    OrderConfirmationPage objOrderConfirmationPage;
    YandexMainPage objYandexMainPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }

        driver.get(BASE_URL);

        objMainPage = new MainPageScooter(driver);
        objOrderPage = new OrderPageScooter(driver);
        objRentPage = new RentPageScooter(driver);
        objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objYandexMainPage = new YandexMainPage(driver);

        objMainPage.clickCookieButton();
    }

    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void startBrowserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
