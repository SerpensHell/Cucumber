package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import web.drivers.WebDriverFactory;
import web.pages.StovesAndFurnacesPage;

public class StovesAndFurnacesPageSteps {
    private StovesAndFurnacesPage stovesAndFurnacesPage;

    @Дано("Открыта страница \"Плиты и печи\"")
    public void openAppliancesDNSPage() {
        stovesAndFurnacesPage = new StovesAndFurnacesPage(WebDriverFactory.getCurrentDriver());
    }

    @И("Выполнен переход по ссылке \"Плиты электрические\"")
    public void goToElectricStoves() {
        stovesAndFurnacesPage.electricStovesGetLink().click();
    }
}
