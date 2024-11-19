package tests.way2automation;

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

    @Test
    public void checkPageOpen() {
        homePage.checkPageOpenAndMainElements();
    }

    @Test(priority = 1)
    public void checkHeader() {
        homePage.checkHeaderWithContacts();
    }

    @Test(priority = 1)
    public void checkPopularCourses() {
        homePage.checkPopularCoursesBlockNavigation();
    }

    @Test(priority = 1)
    public void checkFooter() {
        homePage.checkFooterWithContacts();
    }

    @Test(priority = 1)
    public void checkNavigationMenuAfterScroll() {
        homePage.checkNavBarAfterScroll();
    }

    @Test(priority = 2)
    public void checkGoToPageViaNavMenu() {
        homePage.goToPageViaNavBar()
                .checkUrlAndTitle();
    }
}
