package tests.way2automation;

import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

public class HomePageMainElementsTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("home_page"));
        homePage.closeModal();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Основные элементы страницы")
    @Story(value = "Хэдер, навигационное меню, кнопка регистрации, список курсов")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkPageOpen() {
        homePage.checkPageOpenAndMainElements();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Основные элементы страницы")
    @Story(value = "Контакты в хэдере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void checkHeader() {
        homePage.checkHeaderWithContacts();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Основные элементы страницы")
    @Story(value = "Навигация в блоке популярных курсов")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void checkPopularCourses() {
        homePage.checkPopularCoursesBlockNavigation();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Основные элементы страницы")
    @Story(value = "Контакты в футере")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void checkFooter() {
        homePage.checkFooterWithContacts();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Основные элементы страницы")
    @Story(value = "Навигационное меню после скрола страницы вниз")
    @Severity(value = SeverityLevel.MINOR)
    @Test(priority = 2)
    public void checkNavigationMenuAfterScroll() {
        homePage.checkNavBarAfterScroll();
    }

    @Epic(value = "Домашняя страница")
    @Feature(value = "Переходы на другие страницы")
    @Story(value = "Переход на другую страницу через навигационное меню")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void checkGoToPageViaNavMenu() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }
}
