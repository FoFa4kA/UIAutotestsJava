package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.AlertsPage;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static util.PropertiesUtil.getProp;

@Feature(value = "Действия с алертами")
public class AlertsTest extends BaseTest {
    protected AlertsPage alertsPage = new AlertsPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("alerts_page"));
    }

    @Story(value = "Вызов алерта с вводом текста и подтверждением")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testAlertWithInput() {
        alertsPage.invokePromptAlert()
                .inputAndAcceptPromptAlert("Vladimir");
        assertEquals("Hello Vladimir! How are you today?", alertsPage.getGreetingText().getText());
    }
}
