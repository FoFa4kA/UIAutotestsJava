package tests.base;

import io.qameta.allure.Epic;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import pages.base.BasePage;
import pages.sqlex.MainPage;
import pages.way2automation.HomePage;
import pages.way2automation.LoginPage;
import util.TestListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import static common.CommonActions.createDriver;
import static util.PropertiesUtil.getProp;

@Epic(value = "UI Тесты")
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);
    protected LoginPage loginPage = new LoginPage(driver, actions);
    protected MainPage mainPage = new MainPage(driver, actions);

    public WebDriver getDriver() {
        return driver;
    }

//    public void writeCookiesToFile() {
//        File file = new File("src/test/resources/cookies.data");
//        try {
//            file.delete();
//            file.createNewFile();
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for(Cookie cookie : driver.manage().getCookies()) {
//                bufferedWriter.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";"
//                        + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure()));
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void readCookiesFromFile() {
//        File file = new File("src/test/resources/cookies.data");
//        try {
//            String stringLine;
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while((stringLine = bufferedReader.readLine()) != null){
//                StringTokenizer token = new StringTokenizer(stringLine,";");
//                while(token.hasMoreTokens()){
//                    String name = token.nextToken();
//                    String value = token.nextToken();
//                    String domain = token.nextToken();
//                    String path = token.nextToken();
//                    Date expiry = null;
//
//                    String val;
//                    if(!(val=token.nextToken()).equals("null")) {
//                        expiry = new Date(val);
//                    }
//                    Boolean isSecure = Boolean.valueOf(token.nextToken());
//                    Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
//                    driver.manage().addCookie(cookie);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @AfterClass
    public void close() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
