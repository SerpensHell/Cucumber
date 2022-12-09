package web.elements;


import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class RadioButton extends BaseElement {

    public RadioButton(WebElement webElement) {
        super(webElement);
    }

    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }
}
