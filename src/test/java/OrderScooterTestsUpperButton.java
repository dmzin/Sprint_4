import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class OrderScooterTestsUpperButton extends BaseTest{

    private final String username;
    private final String surname;
    private final String address;
    private final String stationName;
    private final String phone;
    private final String date;
    private final String rentalPeriod;

    public OrderScooterTestsUpperButton(String username, String surname, String address, String stationName, String phone, String date, String rentalPeriod) {
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
                {"Дмитрий", "Смирнов", "ул. Ленина 1", "Комсомольская", "+79990001122", "25.03.2026", "сутки"},
                {"Ольга", "Кузнецова", "пр-т Мира 45", "Таганская", "+79876543210", "28.03.2026", "двое суток"}
        };
    }

    @Test
    public void shouldCreateOrderSuccessfully() {

        objMainPage.clickOrderUpperButton();

        objOrderPage.fillOrderForm(username, surname, address, stationName, phone);

        objRentPage.fillRentForm(date, rentalPeriod);

        objOrderConfirmationPage.clickAgreeButton();

        objOrderConfirmationPage.waitForSuccessfulOrder();
        String textInSuccessfulOrder = objOrderConfirmationPage.getSuccessfulOrderText();
        MatcherAssert.assertThat("Должно появиться окно Заказ оформлен", textInSuccessfulOrder, containsString("Заказ оформлен"));

    }

}
