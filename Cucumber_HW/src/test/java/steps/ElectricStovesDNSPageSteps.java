package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import web.drivers.WebDriverFactory;
import web.matchers.ElectricStovesDNSPageMatcher;
import web.pages.ElectricStovesDnsPage;

public class ElectricStovesDNSPageSteps {
    private ElectricStovesDnsPage electricStovesDnsPage;

    @Дано("Открыта страница \"Плиты электрческие\"")
    public void openAppliancesDNSPage() {
        electricStovesDnsPage = new ElectricStovesDnsPage(WebDriverFactory.getCurrentDriver());
    }

    @Тогда("Проверка: Количество товаров в тексте \"Плиты электрические [количество] товаров\" больше {int}")
    public void assertProductCount(int count) {
        ElectricStovesDNSPageMatcher electricStovesDNSPageMatcher = new ElectricStovesDNSPageMatcher(electricStovesDnsPage);
        electricStovesDNSPageMatcher.electricStovesCountMoreThen(count);
    }
}
