package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement
            contentsOfCart = $ ("#block-system-main"),
            removeFromCartButton = $ ("#edit-edit-delete-0");

    @Step("Проверяем добавление товара в корзину {value}")
    public CartPage checkAddToCartResult(String value) {
        contentsOfCart.shouldHave(text(value));
        return this;
    }

    @Step("Клик по кнопке 'Удалить'")
    public CartPage removeFromCartButtonClick () {
        removeFromCartButton.click();
        return this;
    }

    @Step("Проверяем отсутствие товара в корзине")
    public CartPage checkRemoveFromCartResult() {
        contentsOfCart.shouldHave(text("Корзина пуста."));
        return this;
    }
}


