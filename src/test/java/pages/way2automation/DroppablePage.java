package pages.way2automation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[src='droppable/default.html']")
    WebElement example1Tab1Frame;
    @FindBy(css = "#draggable")
    WebElement draggableElement;
    @FindBy(css = "#droppable")
    WebElement droppableElement;
    @FindBy(css = "#droppable p")
    WebElement droppableElementTitle;

    public WebElement getExample1Tab1Frame() {
        return example1Tab1Frame;
    }

    public WebElement getGetDroppableElementTitle() {
        return droppableElementTitle;
    }

    @Step("Перетаскивание одного элемента в другой элемент")
    public DroppablePage drugElementAndDropItToTarget() {
        waitElementToBeVisible(draggableElement);
        drugNDropElement(draggableElement, droppableElement);
        return this;
    }
}