package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.drivers.Selenium4Listener;

import java.util.List;

public class KitchenAppliancesDNSPage extends BasePage{
    private Logger logger = LogManager.getLogger(AppliancesDNSPage.class);
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(className = "subcategory__page-title")
    @CacheLookup
    WebElement pageTitleKitchenAppliances;
    @FindBy(xpath = "//a[@class = 'button-ui button-ui_white configurator-links-block__links-link']")
    @CacheLookup
    WebElement assembleYourKitchenLink;
    @FindBy(className = "subcategory__title")
    @CacheLookup
    List<WebElement> categories;

    public KitchenAppliancesDNSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public String pageTitleKitchenAppliancesGetText() {
        return pageTitleKitchenAppliances.getText();
    }

    public String assembleYourKitchenLinkGetText() {
        return assembleYourKitchenLink.getText();
    }

    public void allCategoriesNameOutput() {
        for (WebElement category : categories) {
            String categoryName = category.getText();
            logger.info(categoryName);
        }
    }

    public int getNumberOfCategories() {
        return categories.size();
    }
}