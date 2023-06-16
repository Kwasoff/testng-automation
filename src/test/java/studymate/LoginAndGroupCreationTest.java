package studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StudymateGroupPage;
import pages.StudymateLoginPage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class LoginAndGroupCreationTest {

    StudymateLoginPage studymateLoginPage;
    StudymateGroupPage studymateGroupPage;
    Faker faker = new Faker();

    @BeforeMethod
    void beforeSettings(){
        Driver.getDriver().get(Config.getValue("studymateURL"));
    }

    @AfterMethod()
    void afterSettings(){
        Driver.quit();
    }

    @Test
    void login(){

        studymateLoginPage = new StudymateLoginPage();
        studymateLoginPage.emailInput.sendKeys(Config.getValue("studymateEmailData"));
        studymateLoginPage.passwordInput.sendKeys(Config.getValue("studymatePasswordData"));
        studymateLoginPage.logInBtn.click();
        ApplicationFlow.pause(3000);
        String expectedURL = "https://codewise.studymate.us/admin/analytics";
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl(), "URLs are not the same");
    }

    @Test
    void groupCreationTest(){
        studymateLoginPage = new StudymateLoginPage();
        studymateGroupPage = new StudymateGroupPage();
        studymateLoginPage.emailInput.sendKeys(Config.getValue("studymateEmailData"));
        studymateLoginPage.passwordInput.sendKeys(Config.getValue("studymatePasswordData"));
        studymateLoginPage.logInBtn.click();
        studymateLoginPage.groupLinkBtn.click();
        studymateGroupPage.createGroupBtn.click();
        String currentTimeNumb = "" + System.currentTimeMillis();
        String groupName = "Metal" + currentTimeNumb;
        studymateGroupPage.groupNameInput.sendKeys(groupName);
        studymateGroupPage.dateBtn.click();
        studymateGroupPage.dateTodayBtn.click();
        studymateGroupPage.groupDescriptionInput.sendKeys("punk goes pop");
        studymateGroupPage.createBtn.click();
        String xpath = "//div[.='" + groupName + "']";
        WebElement createdGroup = Driver.getDriver().findElement(By.xpath(xpath));
        Assert.assertTrue(createdGroup.isDisplayed());

    }





}
