package util;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsExecutorActions {

    @Step("Снятие фокуса с элемента - {element}")
    public static WebElement removeFocusFromElement(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].blur()", element);
        return element;
    }
}
