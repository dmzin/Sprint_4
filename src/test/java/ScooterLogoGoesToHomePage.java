import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class ScooterLogoGoesToHomePage extends BaseTest{

    @Test
    public void shouldLogoGoesToHomePage() {

        objMainPage.clickLogoScooter();
        objMainPage.waitForLoadHomePage();

        String actualUrl = objMainPage.getUrl();

        MatcherAssert.assertThat("Должна открыться главная страница Самоката", actualUrl, containsString("qa-scooter.praktikum-services.ru"));

    }

}
