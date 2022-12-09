package web.matchers;

import org.junit.jupiter.api.Assertions;
import web.pages.FirstLaptopDNSPage;

public class FirstLaptopDNSPageMatcher {
    FirstLaptopDNSPage page;

    public FirstLaptopDNSPageMatcher(FirstLaptopDNSPage page) {
        this.page = page;
    }

    public void firstLaptopPageTitleEquals(String firstLaptopNameLaptopsPage, String firstLaptopPageTitleName) {
        Assertions.assertTrue(firstLaptopNameLaptopsPage.contains(firstLaptopPageTitleName), "Заголовок не соответствует ожидаемому");
    }

    public void firstLaptopPageSpecificationContainsName(String firstLaptopPageSpecificationTitle, String name) {
        Assertions.assertTrue(firstLaptopPageSpecificationTitle.contains(name), "Заголовок не содержит ожидаемого знаечния");
    }

    public void firstLaptopPageSpecificationRamEquals(String firstLaptopPageRamVolume, String volume) {
        Assertions.assertEquals(firstLaptopPageRamVolume,volume,"Объем оперативной памяти не равен ожидаемому знаечнию");
    }

}
