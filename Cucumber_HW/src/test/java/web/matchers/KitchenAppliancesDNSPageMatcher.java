package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.KitchenAppliancesDNSPage;

public class KitchenAppliancesDNSPageMatcher {
    KitchenAppliancesDNSPage page;
    private Logger logger = LogManager.getLogger(KitchenAppliancesDNSPage.class);

    public KitchenAppliancesDNSPageMatcher(KitchenAppliancesDNSPage page) {
        this.page = page;
    }

    public void pageKitchenAppliancesTitleEquals(String expected) {
        String pageKitchenAppliancesText = page.pageTitleKitchenAppliancesGetText();
        logger.info("Отображаемый текст: " + pageKitchenAppliancesText);
        Assertions.assertEquals(expected, pageKitchenAppliancesText, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }

    public void pageKitchenAppliancesYourKitchenEquals(String expected) {
        String assembleYourKitchenText = page.assembleYourKitchenLinkGetText();
        logger.info("Отображаемый текст: " + assembleYourKitchenText);
        Assertions.assertEquals(expected, assembleYourKitchenText, "Ошибка! Название ссылки не соответствует ожидаемому!");
    }

    public void pageKitchenAppliancesCategoriesMoreThen (int count){
        int numberOfCategories = page.getNumberOfCategories();
        logger.info("Количество категорий: " + numberOfCategories);
        Assertions.assertTrue(numberOfCategories > count, "Количество категорий меньше необходимого");
    }

}