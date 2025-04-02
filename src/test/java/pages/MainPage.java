package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.TestData;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    TestData testData = new TestData();

    private final SelenideElement
    inputSearchText = $("#search-text"),
    inputSearchVIN = $("#search-text-vin"),
    searchBrandButton = $(".menu a[href=\"/brand\"]"),
    searchCarBrandButton = $(".menu a[href=\"/search/acat\"]");

    @Step("Открываем страницу")
    public MainPage openPage() {
        open(testData.url);
        return this;
    }

    @Step("Заполняем поле поиска по тексту")
    public MainPage setInputSearchText(String value) {
        inputSearchText.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Заполняем поле поиска по VIN")
    public MainPage setInputSearchVIN(String value) {
        inputSearchVIN.scrollTo().setValue(value).pressEnter();
        return this;
    }

    @Step("Нажимаем на кнопку 'Подбор по автомобилю'")
    public MainPage searchCarBrandButtonClick() {
        searchCarBrandButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Подбор по брэнду'")
    public MainPage searchBrandButtonClick() {
        searchBrandButton.click();
        return this;
    }

}
