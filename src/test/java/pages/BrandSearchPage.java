package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BrandSearchPage {

    private final SelenideElement
            inputSearchBrand = $("#brandfilter input[type='text']"),
            searchBrandResult = $("#block-views-brand-list");

    @Step("Заполняем поле поиска по брэнду")
    public BrandSearchPage setInputSearchBrand(String value) {
        inputSearchBrand.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Проверяем результаты поиска по бренду {value}")
    public BrandSearchPage checkSearchBrandResult(String value) {
        searchBrandResult.shouldHave(text(value));
        return this;
    }
}
