package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

@Feature(value = "Домашняя страница")
public class HomePageMainElementsTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("home_page"));
        homePage.closeModal();
    }

    @Story(value = "Хэдер, навигационное меню, кнопка регистрации, список курсов")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkPageOpen() {
        homePage.checkPageOpenAndMainElements();
    }

    @Story(value = "Контакты в хэдере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void checkHeader() {
        homePage.checkHeaderWithContacts();
    }

    @Story(value = "Навигация в блоке популярных курсов")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void checkPopularCourses() {
        homePage.checkPopularCoursesBlockNavigation();
    }

    @Story(value = "Контакты в футере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void checkFooter() {
        homePage.checkFooterWithContacts();
    }

    @Story(value = "Навигационное меню после скрола страницы вниз")
    @Severity(value = SeverityLevel.MINOR)
    @Test(priority = 2)
    public void checkNavigationMenuAfterScroll() {
        homePage.checkNavBarAfterScroll();
    }

    @Story(value = "Переход на другую страницу через навигационное меню")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void checkGoToPageViaNavMenu() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }

    @Story(value = "Повторный переход на страницу через навигационное меню")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void repeatGoToPageViaNavMenu() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }
}
