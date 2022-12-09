package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.helpers.ScreenHelper;
import web.pages.LaptopsDNSPage;

import java.util.List;
import java.util.Map;

public class LaptopsDNSPageSteps {
    LaptopsDNSPage laptopsDNSPage;

    @Дано("Открыта страница \"Ноутбуки\"")
    public void openLaptopsDNSPage() {
        laptopsDNSPage = new LaptopsDNSPage(WebDriverFactory.getCurrentDriver());
    }

    @И("Скрыт блок страницы")
    public void hideHeader() {
        JavaScriptHelper.displayNone();
    }

    @И("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String company) {
        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.companyChooseCheckbox(company).setChecked(true);
    }

    @И("В фильтре \"Объем оперативной памяти\" выбрано значение {string}")
    public void filterByRam(String ram) {
        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.ramGetAccordeon().show();
        laptopsDNSPage.ramChooseCheckbox(ram).setChecked(true);
    }

    @И("Применены фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.applyGetButton().click();
    }

    @И("Выбрана сортировка {string}")
    public void sortBy(String type) {
        laptopsDNSPage.sortGetAccordeon().show();
        laptopsDNSPage.sortChooseRadiobutton(type).setSelected(true);
    }

    @И("Выполнен переход на страницу первого продукта в списке")
    public void goToFirstLaptop() {
        laptopsDNSPage.firstLaptopGetLink().openInNewWindow();
    }

    @И("Установлена сортировка и фильтры из таблицы")
    public void setFiltersAndSortFromTable(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRam = table.get(0).get("Объем оперативной памяти");

        laptopsDNSPage.sortGetAccordeon().show();
        laptopsDNSPage.sortChooseRadiobutton(sortBy).setSelected(true);

        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.companyChooseCheckbox(filterByCompany).setChecked(true);

        JavaScriptHelper.scrollBy(0,600);
        laptopsDNSPage.ramGetAccordeon().show();
        laptopsDNSPage.ramChooseCheckbox(filterByRam).setChecked(true);
    }
}
