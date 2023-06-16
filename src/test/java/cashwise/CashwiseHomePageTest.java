package cashwise;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashwiseHomePage;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class CashwiseHomePageTest {


    Faker faker = new Faker();

    @BeforeMethod()
    public void beforeSettings(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }

    @Test()
    public void contactUsTest(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();
        cashwiseHomePage.ContactUSYourNameInput.sendKeys(faker.name().fullName());
        cashwiseHomePage.ContactUSPhoneInput.sendKeys(faker.phoneNumber().phoneNumber());
        cashwiseHomePage.ContactUSEmailInput.sendKeys(faker.internet().emailAddress());
        cashwiseHomePage.ContactUSSendBtn.click();
        Assert.assertTrue(cashwiseHomePage.successfulContactUsPopUpText.isDisplayed());


    }

    @Test()
    public void languageDropdownTest(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();
        cashwiseHomePage.languageDropdownBtn.click();
        ApplicationFlow.pause(3000);
        Assert.assertTrue(cashwiseHomePage.languageOptions.size() == 2, "there are not two language options");
    }

    @Test
    public void login(){
        CashwiseHomePage cashwiseHomePage = new CashwiseHomePage();
        cashwiseHomePage.loginIntoCashwise(Config.getValue("cashwiseLogin"), Config.getValue("cashwisePassword"));
        String expectedURL = "https://cashwise.us/dashboard/infographics";
        ApplicationFlow.pause(3000);
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl(), "URLs are not equal");
    }

    @Test
    public void sideMenu(){

    }



    @AfterMethod()
    public void afterSettings(){
        Driver.quit();

    }

}
