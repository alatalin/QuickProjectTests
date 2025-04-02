package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchVinPage {

    private final SelenideElement
            errorSearchResult = $("#error");

    @Step("Проверяем вывод ошибки поиска")
    public SearchVinPage checkErrorSearchResult(String value) {
        errorSearchResult.shouldHave(text("Извините, у вас нет прав для использования поиска по Vin/Frame или подбору запчастей по каталогу."));
        return this;
    }

}
