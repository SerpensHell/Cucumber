package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.helpers.WindowHelper;
import web.matchers.StartDNSPageMatcher;
import web.pages.StartDNSPage;

public class StartDNSPageSteps {
    private static Logger logger = LogManager.getLogger(StartDNSPageSteps.class);
    private StartDNSPage startDNSPage;

    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartDNSPage() {
        startDNSPage = new StartDNSPage(WebDriverFactory.getCurrentDriver());
        startDNSPage.openPage();
    }

    @Когда("Получен заголовок текущей страницы")
    public void getTitleStartDNSPage() {
        startDNSPage.getPageTitle();
    }

    @И("Получен текущий URL")
    public void getURLStartDNSPage() {
        startDNSPage.getCurrentUrl();
    }

    @И("Получены размеры окна браузера")
    public void getWindowSizeStartDNSPage() {
        WindowHelper.windowWidth();
        WindowHelper.windowHeight();
    }

    @И("Нажата кнопка \"Подтвердить\"")
    public void confirmCityStartDNSPage() {
        startDNSPage.cityConfirmGetButton().click();
    }

    @И("Выполнен переход по ссылке \"Бытовая техника\"")
    public void goToAppliances() {
        startDNSPage.appliancesGetLink().click();
    }

    @И("Курсор наведен на ссылку \"Бытовая техника\"")
    public void moveToApplianceLink() {
        startDNSPage.appliancesGetLink().focusOnLink();
    }

    @Тогда("Проверка: Отображаются ссылки {string}, {string}, {string}")
    public void assertSubMenuLinks(String text1, String text2, String text3) {
        StartDNSPageMatcher startDNSPageMatcher = new StartDNSPageMatcher(startDNSPage);
        startDNSPageMatcher.pageStartSubMenuLinksEquals(text1,text2,text3);
    }

    @И("Курсор наведен на ссылку \"Приготовление напитков\"")
    public void moveToPreparationDrinksLink() {
        startDNSPage.preparationDrinksGetLink().focusOnLink();
    }

    @Тогда("Проверка: Количество ссылок в подменю \"Приготовление напитков\" больше {int}")
    public void assertPreparationDrinksSubMenuLinksCount(int count) {
        StartDNSPageMatcher startDNSPageMatcher = new StartDNSPageMatcher(startDNSPage);
        startDNSPageMatcher.pageStartPreparationDrinksMoreThen(count);
    }

    @И("Выполнен переход по ссылке \"Плиты и печи\"")
    public void goToStovesAndFurnaces() {
        startDNSPage.stovesAndFurnacesGetLink().click();
    }

    @Когда("Курсор наведен на ссылку \"Пк, ноутбуки, периферия\"")
    public void moveToPCLaptopsParaphernalia() {
        startDNSPage.computersAndParaphernaliaGetLink().focusOnLink();
    }

    @И("Выполнен переход по ссылке \"Ноутбуки\"")
    public void goToLaptops() {
        startDNSPage.laptopsGetLink().click();
    }
}
