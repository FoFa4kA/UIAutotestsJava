package pages.way_2_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dialog-widget-content")
    private WebElement dialogWidget;
    @FindBy(css = ".eicon-close")
    private WebElement closeWidgetButton;
    @FindBy(css = ".ast-above-header-bar[data-section='section-above-header-builder']")
    private WebElement headerWithContacts;
    @FindBy(css = "#ast-desktop-header nav")
    private WebElement navigationBar;
    @FindBy(css= ".swiper-slide-active a.elementor-slide-button")
    private WebElement registerButton;
    @FindBy(css = "section[data-id='5b4952c1']")
    private WebElement coursesList;
    @FindBy(css = "section[data-id='60087569']")
    private WebElement footer;
    @FindBy(css = "a[href='https://wa.me/+919711111558']")
    private WebElement firstPhone;
    @FindBy(css = "a[href='https://wa.me/+919711191558']")
    private WebElement secondPhone;
    @FindBy(css = "a[href='tel:+16464800603']")
    private WebElement thirdPhone;
    @FindBy(css = "a[href='skype:seleniumcoaching?chat']")
    private WebElement skype;
    @FindBy(css = "a[href='skype:seleniumcoaching?chat']")
    private WebElement email;
    @FindBy(css = "a[aria-label='Facebook']")
    private WebElement facebook;
    @FindBy(css = "a[aria-label='Linkedin']")
    private WebElement linkedin;
    @FindBy(css = "a[aria-label='Google']")
    private WebElement google;
    @FindBy(css = "a[aria-label='YouTube']")
    private WebElement youtube;
    @FindBy(css = ".elementor-element-166618a")
    private WebElement popularCoursesBlock;
    @FindBy(css = ".elementor-element-d268105")
    private WebElement popularCoursesTitle;
    @FindBy(css = ".pp-slider-arrow[aria-label='Next slide']")
    private WebElement nextSlideButton;
    @FindBy(css = ".pp-slider-arrow[aria-label='Previous slide']")
    private WebElement previousSlideButton;
    @FindBy(css = "div[aria-label='2 / 16']:not(.swiper-slide-duplicate)")
    private WebElement slideWithFirstIndex;



    public HomePage checkPageOpen() {
        waitElementToBeVisible(headerWithContacts);
        waitElementToBeVisible(navigationBar);
//        waitElementToBeVisible(registerButton);
        waitElementToBeVisible(coursesList);
        waitElementToBeVisible(footer);
        return this;
    }

    public HomePage checkHeaderWithContacts() {
        waitElementToBeVisible(firstPhone);
        waitElementToBeVisible(secondPhone);
        waitElementToBeVisible(thirdPhone);
        waitElementToBeVisible(skype);
        waitElementToBeVisible(email);
        waitElementToBeVisible(facebook);
        waitElementToBeVisible(google);
        waitElementToBeVisible(youtube);
        return this;
    }

    public HomePage popularCoursesBlockNavigation() {
        scrollToElement(popularCoursesBlock);
        waitElementToBeVisible(popularCoursesTitle);
        waitElementToBeVisible(nextSlideButton);
        waitElementToBeVisible(slideWithFirstIndex);
//        clickElement(nextSlideButton);
//        waitElementToBeVisible(previousSlideButton);
//        clickElement(previousSlideButton);
        return this;
    }
}
