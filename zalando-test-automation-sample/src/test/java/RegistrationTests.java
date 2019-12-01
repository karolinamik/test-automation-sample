import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {


    @Test
    public void registerNewAccount() {

        // setup
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();

        // test
        driver.get("https://zalando.pl");
        driver.findElementByClassName("z-navicat-header_navToolItemLink-empty").click();
        driver.findElementByXPath("//div[contains(text(),'Przejdź dalej')]").click();

        String firstName = RandomStringUtils.randomAlphabetic(8);
        String lastName = RandomStringUtils.randomAlphabetic(12);
        String email = RandomStringUtils.randomAlphanumeric(15) + "@" + RandomStringUtils.randomAlphabetic(8) + ".pl";
        String password = RandomStringUtils.randomAlphabetic(10);

        driver.findElementByName("register.firstname").sendKeys(firstName);
        driver.findElementByName("register.lastname").sendKeys(lastName);
        driver.findElementByName("register.email").sendKeys(email);
        driver.findElementByName("register.password").sendKeys(password);
        driver.findElementByClassName("ogLw9C").click();
        driver.findElementByXPath("//span[contains(text(),'Zarejestruj się')]").click();
        driver.findElementByClassName("z-navicat-header_navToolItemLink-empty").click();
        Assert.assertEquals("https://www.zalando.pl/myaccount/", driver.getCurrentUrl());

        // teardown
        driver.quit();
    }

    @Test
    public void loginTest(){
        // setup
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();

        // test
        driver.get("https://zalando.pl");
        driver.findElementByClassName("z-navicat-header_navToolItemLink-empty").click();
        driver.findElementByName("login.email").sendKeys("test-email-1000@test.pl");
        driver.findElementByName("login.password").sendKeys("supertajnehaslo123");
        driver.findElementByXPath("//div[contains(text(),'Zaloguj się')]").click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlToBe("https://www.zalando.pl/myaccount/"));
        Assert.assertEquals("https://www.zalando.pl/myaccount/", driver.getCurrentUrl());

        // teardown
        driver.quit();
    }
}
