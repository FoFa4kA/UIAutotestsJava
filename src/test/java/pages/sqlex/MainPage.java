package pages.sqlex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }


}
