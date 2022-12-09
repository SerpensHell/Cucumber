package web.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptHelper {
    protected static JavascriptExecutor javascriptExecutor;

    public static void init(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        javascriptExecutor.executeScript(script);
    }

    public static void scrollTo(int x, int y) {
        String script = "window.scrollTo(0,0);";
        javascriptExecutor.executeScript(script);
    }

    public static void displayNone() {
        String script = "document.querySelector('header').style.display='none';";
        javascriptExecutor.executeScript(script);
    }
}

