package pages.way2automation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TabsPage extends BasePage {

    public TabsPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[src='frames-windows/defult1.html']")
    private WebElement windowsFrame;
    @FindBy(css = "[target='_blank']")
    private WebElement newTabLink;

    public WebElement getWindowsFrame() {
        return windowsFrame;
    }

    @Step("Клик по ссылке и переключение на открывшуюся вкладку")
    public TabsPage clickOnLinkAndSwitchToOpenedTab() {
        newTabLink.click();
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(tabsList.size() - 1));
        return this;
    }
}
