package pages.sqlex;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='subm2']")
    private WebElement loginWithoutRegButton;
    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;

    @Step("Нажатие на кнопку 'Вход без регистрации'")
    public MainPage loginWithoutRegistration() {
        waitElementToBeVisible(loginWithoutRegButton).click();
        return this;
    }

    @Step("Нажатие на кнопку выхода")
    public MainPage logout() {
        waitElementToBeVisible(logoutButton).click();
        return this;
    }

    public MainPage writeCookiesToFile() {
        File file = new File("src/test/resources/cookies.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ";" + cookie.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public MainPage readCookiesFromFile() {
        File file = new File("src/test/resources/cookies.data");
        try {
            String stringLine;
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((stringLine = bufferedReader.readLine()) != null){
                StringTokenizer token = new StringTokenizer(stringLine,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    Cookie cookie = new Cookie(name,value);
                    driver.manage().addCookie(cookie);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public MainPage deleteFileWithCookies() {
        File file = new File("src/test/resources/cookies.data");
        file.delete();
        return this;
    }
}
