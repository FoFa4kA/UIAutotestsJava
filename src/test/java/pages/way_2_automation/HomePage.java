package pages.way_2_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import static org.testng.AssertJUnit.assertEquals;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dialog-widget-content")
    private WebElement dialogWidget;
    @FindBy(css = ".dialog-close-button")
    private WebElement closeWidgetButton;
    @FindBy(css = ".ast-above-header-bar[data-section='section-above-header-builder']")
    private WebElement headerWithContacts;
    @FindBy(css = "#ast-desktop-header nav")
    private WebElement navigationBar;
    @FindBy(css = ".ast-sticky-active nav")
    private WebElement navBarAfterScroll;
    @FindBy(css= ".swiper-slide-active a.elementor-slide-button")
    private WebElement registerButton;
    @FindBy(css = "section[data-id='5b4952c1']")
    private WebElement coursesList;
    @FindBy(css = "section[data-id='60087569']")
    private WebElement footer;
    @FindBy(css = "a[href='https://wa.me/+919711111558']")
    private WebElement firstPhoneInHeader;
    @FindBy(css = "a[href='https://wa.me/+919711191558']")
    private WebElement secondPhoneInHeader;
    @FindBy(css = "a[href='tel:+16464800603']")
    private WebElement thirdPhoneInHeader;
    @FindBy(css = "a[href='skype:seleniumcoaching?chat']")
    private WebElement skypeInHeader;
    @FindBy(xpath = "(//span[text()='trainer@way2automation.com'])[1]")
    private WebElement emailInHeader;
    @FindBy(css = "a[aria-label='Facebook']")
    private WebElement facebookInHeader;
    @FindBy(css = "a[aria-label='Linkedin']")
    private WebElement linkedinInHeader;
    @FindBy(css = "a[aria-label='Google']")
    private WebElement googleInHeader;
    @FindBy(css = "a[aria-label='YouTube']")
    private WebElement youtubeInHeader;
    @FindBy(css = ".elementor-element-166618a")
    private WebElement popularCoursesBlock;
    @FindBy(css = ".elementor-element-d268105")
    private WebElement popularCoursesTitle;
    @FindBy(css = ".pp-slider-arrow[aria-label='Next slide']")
    private WebElement nextSlideButton;
    @FindBy(css = ".pp-slider-arrow[aria-label='Previous slide']")
    private WebElement previousSlideButton;
    @FindBy(css = "div[data-id='50827c4'] .swiper-slide-prev")
    private WebElement previousSlide;
    @FindBy(css = "div[data-id='50827c4'] .swiper-slide-active")
    private WebElement activeSlide;
    @FindBy(css = "div[data-id='50827c4'] .swiper-slide-next")
    private WebElement nextSlide;
    @FindBy(xpath = "//span[text()='Way2Automation']")
    private WebElement addressInFooter;
    @FindBy(xpath = "//span[text()='+91 97111-11-558']")
    private WebElement firstPhoneInFooter;
    @FindBy(xpath = "//span[text()='+91 97111-91-558']")
    private WebElement secondPhoneInFooter;
    @FindBy(xpath = "(//span[text()='trainer@way2automation.com'])[2]")
    private WebElement firstEmailInFooter;
    @FindBy(css = "a[href='mailto:seleniumcoaching@gmail.com']")
    private WebElement secondEmailInFooter;
    @FindBy(css = "#menu-item-27617")
    private WebElement resourcesInNavBar;
    @FindBy(css = "#menu-item-27619")
    private WebElement site2InResources;

    public HomePage closeModal() {
        moveToElement(headerWithContacts);
        waitElementToBeVisible(dialogWidget, 10);
        waitElementToBeVisible(closeWidgetButton, 10).click();
        return this;
    }

    public HomePage checkPageOpenAndMainElements() {
        waitElementToBeVisible(headerWithContacts);
        waitElementToBeVisible(navigationBar);
        waitElementToBeVisible(registerButton);
        waitElementToBeVisible(coursesList);
        waitElementToBeVisible(footer);
        return this;
    }

    public HomePage checkHeaderWithContacts() {
        waitElementToBeVisible(firstPhoneInHeader);
        waitElementToBeVisible(secondPhoneInHeader);
        waitElementToBeVisible(thirdPhoneInHeader);
        waitElementToBeVisible(skypeInHeader);
        waitElementToBeVisible(emailInHeader);
        waitElementToBeVisible(facebookInHeader);
        waitElementToBeVisible(googleInHeader);
        waitElementToBeVisible(youtubeInHeader);
        return this;
    }

    public HomePage checkPopularCoursesBlockNavigation() {
        String firstActiveSlideIndex;
        String previousSlideIndex;

        scrollToElement(popularCoursesBlock);
        waitElementToBeVisible(popularCoursesTitle);
        waitElementToBeVisible(activeSlide);
        firstActiveSlideIndex = activeSlide.getAttribute("data-swiper-slide-index");
        previousSlideIndex = previousSlide.getAttribute("data-swiper-slide-index");
        waitElementToBeVisible(previousSlideButton).click();
        assertEquals(previousSlideIndex, activeSlide.getAttribute("data-swiper-slide-index"));
        moveToElementAndClickWithPause(nextSlideButton, 1);
        assertEquals(firstActiveSlideIndex, activeSlide.getAttribute("data-swiper-slide-index"));
        return this;
    }

    public HomePage checkFooterWithContacts() {
        scrollToElement(footer);
        waitElementToBeVisible(footer);
        waitElementToBeVisible(addressInFooter);
        waitElementToBeVisible(firstPhoneInFooter);
        waitElementToBeVisible(secondPhoneInFooter);
        waitElementToBeVisible(firstEmailInFooter);
        waitElementToBeVisible(secondEmailInFooter);
        return this;
    }

    public HomePage checkNavBarAfterScroll() {
        scrollToElement(popularCoursesBlock);
        waitElementToBeVisible(navBarAfterScroll);
        return this;
    }

    public PracticeSite2Page goToPageViaNavBar() {
        moveToElement(resourcesInNavBar);
        waitElementToBeVisible(site2InResources).click();
        return new PracticeSite2Page(driver, actions);
    }
}
