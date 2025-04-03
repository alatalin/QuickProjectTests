package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement
            searchResults = $("#search-result"),
            addToCartButton = $ (".available"),
            cartButton = $ (".menu a[href=\"/cart\"]"),
            numberOfProductsInCart = $(".quantity");


    @Step("Проверяем результаты поиска по ведёнными данными {value}")
    public SearchPage checkSearchResult(String value) {
        searchResults.shouldHave(text(value));
        return this;
    }

    @Step("Клик по кнопке 'Добавить в корзину'")
    public SearchPage addToCartButtonClick () {
        addToCartButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Корзина'")
    public SearchPage cartButtonClick () {
        numberOfProductsInCart.shouldHave(exactText("1"));
        cartButton.click();
        return this;
    }
}

