package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.*;
import utils.TestData;

@Owner("alatalin")
@Tag("quicktests")
public class AvtoPaskerQuickTests extends TestBase{

    private final MainPage mainPage = new MainPage();
    private final SearchPage searchPage = new SearchPage();
    private final SearchVinPage searchVinPage = new SearchVinPage();
    private final BrandSearchPage brandSearchPage = new BrandSearchPage();
    private final CarBrandSearchPage carBrandSearchPage = new CarBrandSearchPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Поиск по артикулу")
    @Tags({
           @Tag("Positive")
    })
    public void successfulArticleSearchTest() {
        mainPage.openPage()
                .setInputSearchText(testData.article);
        searchPage.checkSearchResult(testData.article);
    }

    @Test
    @DisplayName("Поиск по тексту")
    @Tags({
            @Tag("Positive")
    })
    public void successfulTextSearchTest() {
        mainPage.openPage()
                .setInputSearchText(testData.searchText);
        searchPage.checkSearchResult(testData.searchText);
    }

    @Test
    @DisplayName("Поиск по VIN незарегистрированным/неавторизованным пользователем")
    @Tags({
            @Tag("Negative")
    })
    public void unsuccessfulVINSearchTest() {
        mainPage.openPage()
                .setInputSearchVIN(testData.vin);
        searchVinPage.checkErrorSearchResult(testData.vin);
    }

    @Test
    @DisplayName("Поиск по бренду в каталоге")
    @Tags({
            @Tag("Positive")
    })
    public void successfulBrandSearchTest() {
        mainPage.openPage()
                .searchBrandButtonClick();
        brandSearchPage.setInputSearchBrand(testData.brand)
                       .checkSearchBrandResult(testData.brand);
    }

    @Test
    @DisplayName("Поиск по автомобилю незарегистрированным/неавторизованным пользователем в каталоге")
    @Tags({
            @Tag("Negative")
    })
    public void unsuccessfulCarBrandSearchTest() {
        mainPage.openPage()
                .searchCarBrandButtonClick();
        carBrandSearchPage.searchCarBrandMenuClick(testData.carBrand);
        searchVinPage.checkErrorSearchResult(testData.carBrand);
    }
}
