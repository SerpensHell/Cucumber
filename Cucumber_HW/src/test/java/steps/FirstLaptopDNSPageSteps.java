package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.matchers.FirstLaptopDNSPageMatcher;
import web.pages.FirstLaptopDNSPage;

public class FirstLaptopDNSPageSteps {
    FirstLaptopDNSPage firstLaptopDNSPage;

    @Дано("Открыта страница \"Продукт.Ноутбук\"")
    public void openFirstLaptopDNSPage() {
        firstLaptopDNSPage = new FirstLaptopDNSPage(WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Проверка: Загаловок страницы соответствует {string}")
    public void assertFirstLaptopPageTitle(String title) {
        String firstLaptopPageTitleName = firstLaptopDNSPage.firstLaptopGetPageTitle();
        FirstLaptopDNSPageMatcher firstLaptopDNSPageMatcher = new FirstLaptopDNSPageMatcher(firstLaptopDNSPage);
        firstLaptopDNSPageMatcher.firstLaptopPageTitleEquals(title,firstLaptopPageTitleName);
    }

    @Тогда("Проверка: Загловок блока Характеристики содержит {string}")
    public void assertFirstLaptopPageSpecificationTitle(String company) {
        JavaScriptHelper.scrollBy(0,300);
        String firstLaptopPageSpecificationTitleName = firstLaptopDNSPage.firstLaptopPageGetSpecificationTitle();
        FirstLaptopDNSPageMatcher firstLaptopDNSPageMatcher = new FirstLaptopDNSPageMatcher(firstLaptopDNSPage);
        firstLaptopDNSPageMatcher.firstLaptopPageSpecificationContainsName(firstLaptopPageSpecificationTitleName, company);
    }

    @Тогда("Проверка: Объем оперативной памяти в блоке Характеристики равно {string}")
    public void assertFirstLaptopPageSpecificationRam(String ram) {
        JavaScriptHelper.scrollBy(0,400);
        firstLaptopDNSPage.showAllSpecificationGetButton().click();
        JavaScriptHelper.scrollBy(0,1500);
        String firstLaptopPageRamVolume = firstLaptopDNSPage.firstLaptopPageGetRamSpecification();
        FirstLaptopDNSPageMatcher firstLaptopDNSPageMatcher = new FirstLaptopDNSPageMatcher(firstLaptopDNSPage);
        firstLaptopDNSPageMatcher.firstLaptopPageSpecificationRamEquals(firstLaptopPageRamVolume,ram);
    }
}
