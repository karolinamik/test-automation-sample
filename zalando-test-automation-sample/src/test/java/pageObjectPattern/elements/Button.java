package pageObjectPattern.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
    private int timeout = 10;
    private WebElement element;
    private WebDriver driver;

    public Button(WebDriver driver, By by) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable((by)));
    }

    public Button click() {
        this.element.click();
        return this;
    }
}
