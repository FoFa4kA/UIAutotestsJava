package pages.sqlex;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertFalse;
import static util.JsExecutorActions.removeFocusFromElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions, JavascriptExecutor js) {
        super(driver, actions, js);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='subm2']")
    private WebElement loginWithoutRegButton;
    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;
    @FindBy(css = "[type='text'][name='login']")
    private WebElement loginInput;
    @FindBy(css = "[rel='nofollow']")
    private WebElement liveInternetLink;

    @Step("Нажатие на кнопку 'Вход без регистрации'")
    public MainPage loginWithoutRegistration() {
        waitElementToBeVisible(loginWithoutRegButton).click();
        waitElementToBeVisible(logoutButton);
        return this;
    }

    @Step("Проверка перехода на главную")
    public MainPage assertMainPageRedirect() {
        assertFalse(elementIsVisible(loginWithoutRegButton));
        return this;
    }

    @Step("Проверка неактивности поля логина после снятия с него фокуса")
    public MainPage checkLoginInputInactive() {
        removeFocusFromElement(js, loginInput);
        assertNotEquals(loginInput, driver.switchTo().activeElement());
        return this;
    }
}
