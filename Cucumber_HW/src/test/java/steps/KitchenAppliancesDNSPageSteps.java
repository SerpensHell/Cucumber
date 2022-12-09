package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.matchers.KitchenAppliancesDNSPageMatcher;
import web.pages.KitchenAppliancesDNSPage;

public class KitchenAppliancesDNSPageSteps {
    private static Logger logger = LogManager.getLogger(StartDNSPageSteps.class);
    private KitchenAppliancesDNSPage kitchenAppliancesDNSPage;

    @Дано("Открыта страница \"Техника для кухни\"")
    public void openKitchenAppliancesDNSPage() {
        kitchenAppliancesDNSPage = new KitchenAppliancesDNSPage(WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Проверка: Заголовок страницы \"Техника для кухни\" соответсвует {string}")
    public void assertKitchenPageTitle(String titleKitchen) {
        KitchenAppliancesDNSPageMatcher kitchenAppliancesDNSPageMatcher = new KitchenAppliancesDNSPageMatcher(kitchenAppliancesDNSPage);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesTitleEquals(titleKitchen);
    }

    @Тогда("Проверка: Отображается ссылка {string}")
    public void assertLinkCreateYourKitchen(String linkCreateYorKitchen) {
        KitchenAppliancesDNSPageMatcher kitchenAppliancesDNSPageMatcher = new KitchenAppliancesDNSPageMatcher(kitchenAppliancesDNSPage);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesYourKitchenEquals(linkCreateYorKitchen);
    }

    @И("Выведены названия всех категорий")
    public void showAllCategoriesNames() {
        kitchenAppliancesDNSPage.allCategoriesNameOutput();
    }

    @Тогда("Проверка: Количество категорий больше {int}")
    public void assertCategoriesCount(int categoriesNumber) {
        KitchenAppliancesDNSPageMatcher kitchenAppliancesDNSPageMatcher = new KitchenAppliancesDNSPageMatcher(kitchenAppliancesDNSPage);
        kitchenAppliancesDNSPageMatcher.pageKitchenAppliancesCategoriesMoreThen(categoriesNumber);
    }
}
