import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WrongOrderNumberTest extends BaseTest {

    @Test
    public void wrongOrderNumberTest() {
        objMainPage.clickStatusOrderButton();
        objMainPage.setOrderNumber("000");
        objMainPage.clickGoButton();
        objMainPage.waitForLoadErrorOrderPage();
        assertTrue("Должно появиться сообщение об ошибке", objMainPage.getNoOrderPicture().isDisplayed());

    }

}
