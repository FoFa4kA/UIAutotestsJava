package util;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertNotEquals;

public class JsExecutorActions {

    @Step("Снятие фокуса с элемента - {element}")
    public static WebElement removeFocusFromElement(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].blur()", element);
        return element;
    }

    @Step("Проверка наличия скролла на странице")
    public static void checkPageScroll (JavascriptExecutor js) {
        assertNotEquals(js.executeScript("return document.body.offsetHeight"),
                js.executeScript("return window.innerHeight"));
    }
}
