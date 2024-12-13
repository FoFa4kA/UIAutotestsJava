package pages.httpwatch;

import io.qameta.allure.Step;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class BasicAuthPage extends BasePage {

    public BasicAuthPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#displayImage")
    private WebElement displayImageButton;
    @FindBy(css = "#downloadImg")
    private WebElement basicAuthImage;

    public WebElement getBasicAuthImage() {
        return basicAuthImage;
    }

    @Step("Вызов окна аутентификации, ввод данных для входа и подтверждение входа")
    public BasicAuthPage invokeBasicAuthEnterCredentialsAndAcceptLogin() {
        HasAuthentication authentication = (HasAuthentication) driver;
        authentication.register(() -> new UsernameAndPassword("httpwatch", "httpwatch"));
        displayImageButton.click();
        return this;
    }
}
