package tests.httpwatch;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.httpwatch.BasicAuthPage;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertTrue;
import static util.PropertiesUtil.getProp;

@Feature(value = "Базовая аутентификация")
public class BasicAuthTest extends BaseTest {
    protected BasicAuthPage basicAuthPage = new BasicAuthPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("basic_auth_page"));
    }

    @Story(value = "Проверка получения доступа через базовую аутентификацию")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void testBasicAuth() {
        basicAuthPage.invokeBasicAuthEnterCredentialsAndAcceptLogin();
        assertTrue(basicAuthPage.elementIsVisible(basicAuthPage.getBasicAuthImage()));
    }
}
