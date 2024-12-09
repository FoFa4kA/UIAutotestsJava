package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.DroppablePage;
import tests.base.BaseTest;

import static org.testng.Assert.assertNotEquals;
import static util.PropertiesUtil.getProp;

@Feature(value = "Перетаскивание элементов на странице")
public class DroppableTest extends BaseTest {
    protected DroppablePage droppablePage = new DroppablePage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("droppable_page"));
    }

    @Story(value = "Проверка перетаскивания одного элемента внутрь другого")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testDrugNDropElement() {
        String droppableElementTitleBeforeDrop;

        driver.switchTo().frame(droppablePage.getExample1Tab1Frame());
        droppableElementTitleBeforeDrop = droppablePage.getGetDroppableElementTitle().getText();
        droppablePage.drugElementAndDropItToTarget();
        assertNotEquals(droppablePage.getGetDroppableElementTitle().getText(), droppableElementTitleBeforeDrop);
    }
}
