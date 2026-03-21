import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderScooterTestsLowerButton extends BaseTest {

    @Test
    public void shouldOpenOrderPageFromLowerButton() {

        objMainPage.clickOrderLowerButton();
        String textInOrderPage = objOrderPage.getOrderHeader();
        MatcherAssert.assertThat("Должна открыться страница оформления заказа", textInOrderPage, containsString("Для кого самокат"));

    }
}
