package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AvtoPaskerPage {

    TestData testData = new TestData();

    private final SelenideElement
    inputSearchText = $("#search-text"),
    inputSearchVIN = $("#search-text-vin"),
    searchResults = $("#search-result"),
    errorSearchResult = $("#error"),
    searchBrandButton = $(".menu a[href=\"/brand\"]"),
    searchCarBrandButton = $(".menu a[href=\"/search/acat\"]"),
    searchCarBrandMenu = $("#acat"),
    inputSearchBrand = $("#brandfilter input[type='text']"),
    searchBrandResult = $("#block-views-brand-list");

    @Step("Открываем страницу")
    public AvtoPaskerPage openPage() {
        open(testData.url);
        return this;
    }

    @Step("Заполняем поле поиска по тексту")
    public AvtoPaskerPage setInputSearchText(String value) {
        inputSearchText.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Заполняем поле поиска по VIN")
    public AvtoPaskerPage setInputSearchVIN(String value) {
        inputSearchVIN.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Нажимаем на кнопку 'Подбор по автомобилю'")
    public AvtoPaskerPage searchCarBrandButtonClick() {
        searchCarBrandButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Подбор по брэнду'")
    public AvtoPaskerPage searchBrandButtonClick() {
        searchBrandButton.click();
        return this;
    }

    @Step("Заполняем поле поиска по брэнду")
    public AvtoPaskerPage setInputSearchBrand(String value) {
        inputSearchBrand.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем марку автомобиля")
    public AvtoPaskerPage searchCarBrandMenuClick(String value) {
        searchCarBrandMenu.$(byText(value)).click();
        return this;
    }

    @Step("Проверяем результаты поиска по бренду {value}")
    public AvtoPaskerPage checkSearchBrandResult( String value) {
        searchBrandResult.shouldHave(text(value));
        return this;
    }
    @Step("Проверяем вывод ошибки поиска")
    public AvtoPaskerPage checkErrorSearchResult( String value) {
        errorSearchResult.shouldHave(text("Извините, у вас нет прав для использования поиска по Vin/Frame или подбору запчастей по каталогу."));
        return this;
    }

    @Step("Проверяем результаты поиска по ведёнными данными {value}")
    public AvtoPaskerPage checkSearchResult( String value) {
        searchResults.shouldHave(text(value));
        return this;
    }
}
