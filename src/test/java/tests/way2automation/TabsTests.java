package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.TabsPage;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static util.PropertiesUtil.getProp;

@Feature(value = "Действия с вкладками")
public class TabsTests extends BaseTest {
    protected TabsPage tabsPage = new TabsPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("tabs_page"));
    }

    @Story(value = "Открытие и переключение вкладок")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void openAndSwitchTabsTest() {
        driver.switchTo().frame(tabsPage.getWindowsFrame());
        tabsPage.clickOnLinkAndSwitchToOpenedTab()
                .clickOnLinkAndSwitchToOpenedTab();
        assertEquals(3, driver.getWindowHandles().size());
    }
}
