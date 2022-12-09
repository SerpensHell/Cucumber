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
import web.elements.Link;

public class AppliancesDNSPage extends BasePage{
    private Logger logger = LogManager.getLogger(AppliancesDNSPage.class);
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(className = "subcategory__page-title")
    @CacheLookup
    private WebElement  pageTitleAppliances;
    @FindBy(xpath = "//span[text() = 'Техника для кухни']")
    @CacheLookup
    private WebElement kitchenAppliancesLink;

    public AppliancesDNSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public String pageTitleAppliancesGetText() {
        return pageTitleAppliances.getText();
    }

    public Link kitchenAppliancesGetLink() {
        return new Link(kitchenAppliancesLink);
    }

}

