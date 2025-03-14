package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.AvtoPaskerPage;
import utils.TestData;

@Tag("quicktests")
public class AvtoPaskerQuickTests extends TestBase{

    private final AvtoPaskerPage avtoPaskerPagePage = new AvtoPaskerPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Поиск по артикулу")
    @Tags({
           @Tag("Positive")
    })
    @Owner("alatalin")
    public void successfulArticleSearchTest() {
        avtoPaskerPagePage.openPage()
                .setInputSearchText(testData.article)
                .checkSearchResult(testData.article);
    }

    @Test
    @DisplayName("Поиск по тексту")
    @Tags({
            @Tag("Positive")
    })
    @Owner("alatalin")
    public void successfulTextSearchTest() {
        avtoPaskerPagePage.openPage()
                .setInputSearchText(testData.searchText)
                .checkSearchResult(testData.searchText);
    }

    @Test
    @DisplayName("Поиск по VIN незарегистрированным/авторизованным пользователем")
    @Tags({
            @Tag("Negative")
    })
    @Owner("alatalin")
    public void unsuccessfulVINSearchTest() {
        avtoPaskerPagePage.openPage()
                .setInputSearchVIN(testData.vin)
                .checkErrorSearchResult(testData.vin);
    }

    @Test
    @DisplayName("Поиск по бренду в каталоге")
    @Tags({
            @Tag("Positive")
    })
    @Owner("alatalin")
    public void successfulBrandSearchTest() {
        avtoPaskerPagePage.openPage()
                .searchBrandButtonClick()
                .setInputSearchBrand(testData.brand)
                .checkSearchBrandResult(testData.brand);
    }

    @Test
    @DisplayName("Поиск по автомобилю незарегистрированным/авторизованным пользователем в каталоге")
    @Tags({
            @Tag("Negative")
    })
    @Owner("alatalin")
    public void unsuccessfulCarBrandSearchTest() {
        avtoPaskerPagePage.openPage()
                .searchCarBrandButtonClick()
                .searchCarBrandMenuClick(testData.carBrand)
                .checkErrorSearchResult(testData.carBrand);
    }
}
