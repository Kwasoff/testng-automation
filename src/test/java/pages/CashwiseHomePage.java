package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class CashwiseHomePage {

    public CashwiseHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement signInEmailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement signInPasswordInput;

    @FindBy(xpath = "(//form)[2]/button")
    public WebElement formSignInButton;

    @FindBy(xpath = "//button[.='Sign up']")
    public WebElement signUpBtn;

    @FindBy(name = "name")
    public WebElement ContactUSYourNameInput;

    @FindBy(name = "phone")
    public WebElement ContactUSPhoneInput;

    @FindBy(name = "email")
    public WebElement ContactUSEmailInput;

    @FindBy(xpath = "//form/button")
    public WebElement ContactUSSendBtn;

    @FindBy(xpath = "//div[@type='MINI']")
    public WebElement successfulContactUsPopUpText;

    @FindBy(xpath = "//div[@class='App']/div[1]/div[1]/div[2]/div")
    public WebElement languageDropdownBtn;

    @FindBy(xpath = "//ul/li")
    public List<WebElement> languageOptions;

    public void loginIntoCashwise(String email, String password){
        signInBtn.click();
        signInEmailInput.sendKeys(email);
        signInPasswordInput.sendKeys(password);
        formSignInButton.click();
    }



}
