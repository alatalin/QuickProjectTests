package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchVinPage {

    private final SelenideElement
            errorAuthResult = $(".no-login-data-wrap");

    @Step("Проверяем вывод сообщения о необходимости авторизации/регистрации")
    public SearchVinPage checkErrorAuthResult() {
        errorAuthResult.shouldHave(text("Для подбора запчастей по по VIN/FRAME, каталогу или гос. номеру необходимо войти в аккаунт или пройти регистрацию."));
        return this;
    }
}
