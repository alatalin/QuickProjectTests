package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CarBrandSearchPage {

    private final SelenideElement
            searchCarBrandMenu = $("#acat");

    @Step("Выбираем марку автомобиля")
    public CarBrandSearchPage searchCarBrandMenuClick(String value) {
        searchCarBrandMenu.$(byText(value)).click();
        return this;
    }
}
