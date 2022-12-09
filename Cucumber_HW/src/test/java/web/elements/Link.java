package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.*;

public class Link extends BaseElement{

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public void focusOnLink() {
        ActionHelper.moveToElement(webElement);
    }

    public String getText() {
        return webElement.getText();
    }

    public void openInNewWindow() {
        String URL = this.getURL();
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
    }

    public String getURL() {
        return webElement.getAttribute("href");
    }
}
