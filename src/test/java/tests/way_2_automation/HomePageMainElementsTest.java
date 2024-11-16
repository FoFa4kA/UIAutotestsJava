package tests.way_2_automation;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

public class HomePageMainElementsTest extends BaseTest {

    @Test
    public void checkMainElements() {
        basePage.open(getProp("home_page"));
        homePage
                .checkPageOpen()
                .checkHeaderWithContacts()
                .popularCoursesBlockNavigation();
    }
}
