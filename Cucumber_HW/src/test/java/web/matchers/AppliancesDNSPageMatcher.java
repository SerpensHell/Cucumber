package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.AppliancesDNSPage;

public class AppliancesDNSPageMatcher {
    AppliancesDNSPage page;
    private Logger logger = LogManager.getLogger(AppliancesDNSPage.class);

    public AppliancesDNSPageMatcher(AppliancesDNSPage page) {
        this.page = page;
    }

    public void pageAppliancesTitleEquals (String expected) {
        String pageTitleAppliancesText = page.pageTitleAppliancesGetText();
        logger.info("Отображаемый текст: " + pageTitleAppliancesText);
        Assertions.assertEquals(expected, pageTitleAppliancesText, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}

