package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.bidi.module.Input;
import utils.TestData;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    TestData testData = new TestData();

    private final SelenideElement
    inputSearchText = $("#search-text"),
    inputSearchVIN = $("#search-text-vin"),
    searchBrandButton = $(".menu a[href=\"/brand\"]"),
    searchCarBrandButton = $(".menu a[href=\"/search/acat\"]"),
    inputCarNumber = $("#edit-car-number"),
    inputCarRegionCode = $("#edit-region-code");

    @Step("Открываем страницу")
    public MainPage openPage() {
        open(testData.URL);
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

    @Step("Заполняем поле поиска по гос. номеру")
    public MainPage setInputCarNumber(String value) {
        inputCarNumber.scrollTo().setValue(value);
        return this;
    }
    @Step("Заполняем поле поиска по коду региона")
    public MainPage setInputCarRegionCode(String value) {
        inputCarRegionCode.scrollTo().setValue(value).pressEnter();
        return this;
    }

}
