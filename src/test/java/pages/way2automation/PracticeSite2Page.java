package pages.way2automation;

import io.qameta.allure.Step;
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

    @Step("Проверка валидности ссылки и заголовка страницы")
    public PracticeSite2Page checkUrlAndTitle() {
        assertEquals(getProp("practice_site_2"), driver.getCurrentUrl());
        assertEquals(getProp("practice_site_2_title"), driver.getTitle());
        return this;
    }
}
