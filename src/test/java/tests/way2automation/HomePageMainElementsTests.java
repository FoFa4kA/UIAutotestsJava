package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.HomePage;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

@Feature(value = "Домашняя страница")
public class HomePageMainElementsTests extends BaseTest {
    protected HomePage homePage = new HomePage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("home_page"));
        homePage.closeModal();
    }

    @Story(value = "Хэдер, навигационное меню, кнопка регистрации, список курсов")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkPageOpenTest() {
        homePage.checkPageOpenAndMainElements();
    }

    @Story(value = "Контакты в хэдере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void checkHeaderTest() {
        homePage.checkHeaderWithContacts();
    }

    @Story(value = "Навигация в блоке популярных курсов")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void checkPopularCoursesTest() {
        homePage.checkPopularCoursesBlockNavigation();
    }

    @Story(value = "Контакты в футере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void checkFooterTest() {
        homePage.checkFooterWithContacts();
    }

    @Story(value = "Навигационное меню после скрола страницы вниз")
    @Severity(value = SeverityLevel.MINOR)
    @Test(priority = 2)
    public void checkNavigationMenuAfterScrollTest() {
        homePage.checkNavBarAfterScroll();
    }

    @Story(value = "Переход на другую страницу через навигационное меню")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void checkGoToPageViaNavMenuTest() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }

    @Story(value = "Повторный переход на страницу через навигационное меню")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void repeatGoToPageViaNavMenuTest() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }
}
