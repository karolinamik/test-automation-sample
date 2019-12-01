package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.elements.Button;

public class MainPage {
WebDriver driver;
    private By accountBy = By.className("z-navicat-header_navToolItemLink-empty");
    private By goToRegistrationPageBy = By.xpath("//div[contains(text(),'Przejdź dalej')]");
    private Button accountButton;
    private Button goToRegistrationPageButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountButton(){
        this.accountButton = new Button(driver, accountBy);
        accountButton.click();
    }

    public void clickGoToRegistrationFormButton(){
        this.goToRegistrationPageButton = new Button(driver, goToRegistrationPageBy);
        goToRegistrationPageButton.click();
    }

}
