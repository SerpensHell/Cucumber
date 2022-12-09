package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Accordeon extends BaseElement {

    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    public void show() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
