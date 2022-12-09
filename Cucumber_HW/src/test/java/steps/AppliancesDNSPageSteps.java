package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.helpers.ScreenHelper;
import web.matchers.AppliancesDNSPageMatcher;
import web.pages.AppliancesDNSPage;


public class AppliancesDNSPageSteps {
    private static Logger logger = LogManager.getLogger(StartDNSPageSteps.class);
    private AppliancesDNSPage appliancesDNSPage;

    @Дано("Открыта страница \"Бытовая техника\"")
    public void openAppliancesDNSPage() {
        appliancesDNSPage = new AppliancesDNSPage(WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Проверка: Заголовок страницы \"Бытовая техника\" соответствует {string}")
    public void assertPageTitle(String titleAppliances) {
        AppliancesDNSPageMatcher appliancesDNSPageMatcher = new AppliancesDNSPageMatcher(appliancesDNSPage);
        appliancesDNSPageMatcher.pageAppliancesTitleEquals(titleAppliances);
    }

    @И("Выполнен переход по ссылке \"Техника для кухни\"")
    public void goToKitchenAppliance() {
        appliancesDNSPage.kitchenAppliancesGetLink().click();
    }
}
