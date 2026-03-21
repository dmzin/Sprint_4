import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class YandexLogoGoesToYandexPage extends BaseTest{

    @Test
    public void shouldYandexLogoGoesToYandexHomePage(){

        objYandexMainPage.saveCurrentWindow();
        objMainPage.clickLogoYandex();
        objYandexMainPage.waitForNewWindow();
        objYandexMainPage.switchToNewWindow();
        objYandexMainPage.waitForLoadYandexPage();

        String actualUrl = objYandexMainPage.getUrl();

        MatcherAssert.assertThat("Должна открыться главная страница Яндекса", actualUrl, containsString("dzen.ru"));
    }

}
