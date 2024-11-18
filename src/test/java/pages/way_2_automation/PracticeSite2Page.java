package pages.way_2_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import static org.testng.AssertJUnit.assertEquals;
import static util.PropertiesUtil.getProp;

public class PracticeSite2Page extends BasePage {

    public PracticeSite2Page(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    public PracticeSite2Page checkUrlAndTitle() {
        String pageUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();;

        assertEquals(getProp("practice_site_2"), pageUrl);
        assertEquals(getProp("practice_site_2_title"), pageTitle);
        return this;
    }
}
