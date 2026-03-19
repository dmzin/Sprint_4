import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderScooterTestsLowerButton extends BaseTest {

    private final String username;
    private final String surname;
    private final String address;
    private final String stationName;
    private final String phone;
    private final String date;
    private final String rentalPeriod;

    public OrderScooterTestsLowerButton(String username, String surname, String address, String stationName, String phone, String date, String rentalPeriod) {
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.stationName = stationName;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
    }

    @Parameterized.Parameters()
    public static Object[][] userData() {
        return new Object[][]{
                {"Александр", "Петров", "ул. Академика Королёва 12", "ВДНХ", "+79161234567", "05.04.2026", "трое суток"},
                {"Екатерина", "Иванова", "ул. 8 Марта 99", "Парк культуры", "+79260000000", "10.04.2026", "четверо суток"}
        };
    }

    @Test
    public void shouldCreateOrderSuccessfully() {

        objMainPage.clickOrderLowerButton();

        objOrderPage.fillOrderForm(username, surname, address, stationName, phone);

        objRentPage.fillRentForm(date, rentalPeriod);

        objOrderConfirmationPage.clickAgreeButton();

        objOrderConfirmationPage.waitForSuccessfulOrder();
        String textInSuccessfulOrder = objOrderConfirmationPage.getSuccessfulOrderText();
        MatcherAssert.assertThat("Должно появиться окно Заказ оформлен", textInSuccessfulOrder, containsString("Заказ оформлен"));

    }
}
