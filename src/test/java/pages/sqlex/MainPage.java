package pages.sqlex;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import static org.testng.AssertJUnit.assertFalse;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='subm2']")
    private WebElement loginWithoutRegButton;
    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;

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
}
