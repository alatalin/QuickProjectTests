package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement
            searchResults = $("#search-result");

    @Step("Проверяем результаты поиска по ведёнными данными {value}")
    public SearchPage checkSearchResult(String value) {
        searchResults.shouldHave(text(value));
        return this;
    }
}
