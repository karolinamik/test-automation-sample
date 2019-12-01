package pageObjectPattern.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectPattern.pages.MainPage;
import pageObjectPattern.pages.RegistrationPage;
import java.util.concurrent.TimeUnit;

public class RegistrationTestsWithPageObjectPattern {
    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://zalando.pl");
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Test
    public void createNewAccount(){
        mainPage.clickAccountButton();
        mainPage.clickGoToRegistrationFormButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputFirstName();
        registrationPage.inputLastName();
        registrationPage.inputEmail();
        registrationPage.inputPassword();
        registrationPage.chooseGender();
        registrationPage.clickRegisterButton();
        mainPage.clickAccountButton();
        Assert.assertEquals("https://www.zalando.pl/myaccount/", driver.getCurrentUrl());
    }

    @Test
    public void login (){
        mainPage.clickAccountButton();
        mainPage.inputLoginEmail();
        mainPage.inputLoginPassword();
        mainPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlToBe("https://www.zalando.pl/myaccount/"));
        Assert.assertEquals("https://www.zalando.pl/myaccount/", driver.getCurrentUrl());
    }
}
