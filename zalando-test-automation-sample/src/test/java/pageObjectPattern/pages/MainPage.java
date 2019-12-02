package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.elements.Button;
import pageObjectPattern.elements.TextInput;

public class MainPage {
    private WebDriver driver;
    private By accountBy = By.className("z-navicat-header_navToolItemLink-empty");
    private By goToRegistrationPageBy = By.xpath("//div[contains(text(),'Przejdź dalej')]");
    private By loginEmailBy = By.name("login.email");
    private By loginPasswordBy = By.name("login.password");
    private By loginButtonBy = By.xpath("//div[contains(text(),'Zaloguj się')]");
    private Button accountButton;
    private Button goToRegistrationPageButton;
    private TextInput loginEmailInput;
    private TextInput loginPasswordInput;
    private Button loginButton;


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

    public void inputLoginEmail(){
        this.loginEmailInput = new TextInput(driver, loginEmailBy);
        loginEmailInput.fillingField("test-email-1000@test.pl");
    }

    public void inputLoginPassword(){
        this.loginPasswordInput = new TextInput(driver, loginPasswordBy);
        loginPasswordInput.fillingField("supertajnehaslo123");
    }

    public void clickLoginButton(){
        this.loginButton = new Button(driver, loginButtonBy);
        loginButton.click();
    }

}
