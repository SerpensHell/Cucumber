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
import web.elements.Button;
import web.elements.Link;
import web.helpers.WaitHelper;

import java.util.ArrayList;
import java.util.List;

public class StartDNSPage extends BasePage{
    private Logger logger = LogManager.getLogger(StartDNSPage.class);
    private final String URL = "https://www.dns-shop.ru/";

    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(xpath = "(//span[text()=\"Всё верно\"])[1]")
    @CacheLookup
    private WebElement cityConfirmButton;
    @FindBy(linkText = "Бытовая техника")
    @CacheLookup
    private WebElement appliancesLink;
    @FindBy(xpath = "//a[@class ='ui-link menu-desktop__first-level']")
    @CacheLookup
    private List<WebElement> appliancesSubMenuLinks;
    @FindBy(xpath = "(//a[text()=\"Приготовление напитков\"])")
    @CacheLookup
    private WebElement preparationDrinksLink;
    @FindBy(xpath = "//a[text()=\"Приготовление напитков\"]/child::span[@class='menu-desktop__popup']")
    @CacheLookup
    private WebElement preparationDrinksSubMenuLink;
    @FindBy(xpath = "(//a[text() = \"Плиты и печи\"])")
    @CacheLookup
    private WebElement stovesAndFurnacesLink;
    @FindBy(linkText = "ПК, ноутбуки, периферия")
    @CacheLookup
    private WebElement computersAndParaphernaliaLink;
    @FindBy(xpath = "//a[text() = 'Ноутбуки']")
    @CacheLookup
    private WebElement laptopsLink;


    public StartDNSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public Button cityConfirmGetButton() {
        return new Button(cityConfirmButton);
    }

    public Link appliancesGetLink() {
        return new Link(appliancesLink);
    }

    public List<Link> appliancesSubMenuGetAllLinks() {
        WaitHelper.visibilityOfAllElements(appliancesSubMenuLinks);
        List<Link> subMenuLinks = new ArrayList<>();
        for(WebElement element : appliancesSubMenuLinks) {
            subMenuLinks.add(new Link(element));
        }
        return subMenuLinks;
    }

    public Link preparationDrinksGetLink() {
        WaitHelper.visibilityOf(preparationDrinksLink);
        return new Link(preparationDrinksLink);
    }

    public int countSubMenuPreparationDrinksLinks() {
        return Integer.parseInt(preparationDrinksSubMenuLink.getAttribute("childElementCount"));
    }

    public Link stovesAndFurnacesGetLink() {
        return new Link(stovesAndFurnacesLink);
    }

    public Link computersAndParaphernaliaGetLink() {
        // WaitHelper.visibilityOf(computersAndParaphernaliaLink);
        return new Link(computersAndParaphernaliaLink);
    }

    public Link laptopsGetLink() {
        // WaitHelper.visibilityOf(laptopsLink);
        return new Link(laptopsLink);
    }
}
