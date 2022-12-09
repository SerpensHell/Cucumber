package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class CheckBox extends BaseElement {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked(boolean value) {
        if (value != isChecked()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    public boolean isChecked() {
        return webElement.isSelected();
    }
}

