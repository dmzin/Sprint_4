import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


import static org.hamcrest.CoreMatchers.is;

public class CheckErrorsInOrderForm extends BaseTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void checkErrorsInOrderForm() {

        objMainPage.clickOrderUpperButton();
        objOrderPage.clickFurtherButton();

        collector.checkThat("Сообщение должно быть: Введите корректное имя", objOrderPage.getNameError(), is("Введите корректное имя"));
        collector.checkThat("Сообщение должно быть: Введите корректную фамилию", objOrderPage.getSurnameError(), is("Введите корректную фамилию"));
        collector.checkThat("Сообщение должно быть: Выберите станцию", objOrderPage.getMetroError(), is("Выберите станцию"));
        collector.checkThat("Сообщение должно быть: Введите корректный номер", objOrderPage.getPhoneError(), is("Введите корректный номер"));

        //TODO
        // Остальные ошибки не реализованы, при реализации надо будет проверить ошибку в поле адрес (не показывается)
        // Так же проверить ошибки на странице Про аренду, где нет пока ни одной ошибки

    }
}
