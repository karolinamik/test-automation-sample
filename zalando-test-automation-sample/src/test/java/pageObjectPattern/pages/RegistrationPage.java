package pageObjectPattern.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.elements.Button;
import pageObjectPattern.elements.TextInput;

public class RegistrationPage {
    WebDriver driver;
    private By firstNameBy = By.name("register.firstname");
    private By lastNameBy = By.name("register.lastname");
    private By emailBy = By.name("register.email");
    private By passwordBy = By.name("register.password");
    private By genderBy = By.className("ogLw9C");
    private By registerBy = By.xpath("//span[contains(text(),'Zarejestruj się')]");
    private TextInput firstNameInput;
    private TextInput lastNameInput;
    private TextInput emailInput;
    private TextInput passwordInput;
    private Button genderButton;
    private Button registerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(){
        this.firstNameInput = new TextInput(driver,firstNameBy);
        firstNameInput.fillingField(RandomStringUtils.randomAlphabetic(8));
    }

    public void inputLastName(){
        this.lastNameInput = new TextInput(driver, lastNameBy);
        lastNameInput.fillingField(RandomStringUtils.randomAlphabetic(12));
    }

    public void inputEmail(){
        this.emailInput = new TextInput(driver, emailBy);
        emailInput.fillingField(RandomStringUtils.randomAlphanumeric(15) + "@" + RandomStringUtils.randomAlphabetic(8) + ".pl");
    }

    public void inputPassword(){
        this.passwordInput = new TextInput(driver, passwordBy);
        passwordInput.fillingField(RandomStringUtils.randomAlphabetic(12));
    }
    public void chooseGender(){
        this.genderButton = new Button(driver, genderBy);
        genderButton.click();

    }

    public void clickRegisterButton(){
        this.registerButton = new Button(driver, registerBy);
        registerButton.click();
    }

}
