package web.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.pages.ElectricStovesDnsPage;

public class ElectricStovesDNSPageMatcher {
    ElectricStovesDnsPage page;
    private Logger logger = LogManager.getLogger(ElectricStovesDNSPageMatcher.class);

    public ElectricStovesDNSPageMatcher(ElectricStovesDnsPage page) {
        this.page = page;
    }

    public void electricStovesCountMoreThen(int count){
        int electricStovesCount = page.electricStovesGetCount();
        logger.info(String.format("Количество товаров: %d", electricStovesCount));
        Assertions.assertTrue(electricStovesCount > count, "Количество товаров меньше ожидаемого");
    }
}
