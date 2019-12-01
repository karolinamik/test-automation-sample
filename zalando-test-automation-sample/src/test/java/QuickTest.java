import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class QuickTest {

    @Test
    public void projectIsConfiguredProperly() {

        // setup
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();

        // test
        driver.get("https://zalando.pl");
        Assert.assertEquals("Buty i odzież online w ZALANDO. Moda z darmową dostawą i zwrotem", driver.getTitle());

        // teardown
        driver.quit();
    }
}
