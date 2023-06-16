package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudymateGroupPage {

    public StudymateGroupPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Create group')]")
    public WebElement createGroupBtn;

    @FindBy(name = "name")
    public WebElement groupNameInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement groupDescriptionInput;

    @FindBy(xpath = "//form[@id='group-form']/div[2]/div[1]/div[2]/div/div/div/button")
    public WebElement dateBtn;

    @FindBy(xpath = "//*[.='13']")
    public WebElement dateTodayBtn;

    @FindBy(xpath = "//form[@id='group-form']/div[3]/button[2]")
    public WebElement createBtn;




}
