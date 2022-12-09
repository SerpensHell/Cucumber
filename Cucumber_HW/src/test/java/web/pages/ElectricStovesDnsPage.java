package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.drivers.Selenium4Listener;

public class ElectricStovesDnsPage extends BasePage{
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(className = "products-count")
    @CacheLookup
    WebElement electricStovesCountText;

    public ElectricStovesDnsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public int electricStovesGetCount() {
        String electricStovesCountString = electricStovesCountText.getText();
        return Integer.parseInt(electricStovesCountString.substring(0, electricStovesCountString.indexOf(" ")));
    }
}

