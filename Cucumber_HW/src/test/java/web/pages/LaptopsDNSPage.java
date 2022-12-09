package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import web.drivers.Selenium4Listener;
import web.elements.*;

import java.util.List;

public class LaptopsDNSPage extends BasePage {
    Selenium4Listener listener = new Selenium4Listener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

    @FindBy(xpath = "//span[text() = 'Объем оперативной памяти (ГБ)']")
    @CacheLookup
    WebElement ramAccordeon;
    @FindBy(xpath = "//span[text() = 'Производитель']//parent::a/following-sibling::div/descendant::label[@class = 'ui-checkbox ui-checkbox_list']")
    @CacheLookup
    List<WebElement> companyCheckbox;
    @FindBy(xpath = "//span[text() = 'Объем оперативной памяти (ГБ)']//parent::a/following-sibling::div/descendant::label[@class = 'ui-checkbox ui-checkbox_list']")
    @CacheLookup
    List<WebElement> ramCheckbox;
    @FindBy(xpath = "//button[text() = 'Применить']")
    @CacheLookup
    WebElement applyButton;
    @FindBy(xpath = "//a[@class = 'ui-link ui-link_blue'][1]")
    @CacheLookup
    WebElement sortAccordeon;
    @FindBy(xpath = "//div[@class = 'top-filter__radio-list ui-radio top-filter__popover'][1]//span")
    @CacheLookup
    List<WebElement> sortRadiobutton;
    @FindBy(xpath = "//a[@class = 'catalog-product__name ui-link ui-link_black'][1]")
    @CacheLookup
    WebElement firstLaptopLink;

    public LaptopsDNSPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(eventFiringWebDriver, this);
    }

    public CheckBox companyChooseCheckbox(String company) {
        for (WebElement webElement : companyCheckbox) {
            if(webElement.getText().contains(company)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Accordeon ramGetAccordeon() {
        return new Accordeon(ramAccordeon);
    }

    public CheckBox ramChooseCheckbox(String ram) {
        for (WebElement webElement : ramCheckbox) {
            if(webElement.getText().contains(ram)) {
                return new CheckBox(webElement);
            }
        }
        return null;
    }

    public Button applyGetButton() {
        return new Button(applyButton);
    }

    public Accordeon sortGetAccordeon() {
        return new Accordeon(sortAccordeon);
    }

    public RadioButton sortChooseRadiobutton(String type) {
        for (WebElement webElement : sortRadiobutton) {
            if(webElement.getText().contains(type)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }

    public Link firstLaptopGetLink() {
        return new Link(firstLaptopLink);
    }
}
