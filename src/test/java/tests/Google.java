package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.GoogleHomePage;
import utilities.Config;
import utilities.Driver;

public class Google {

    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test
    public void firstTest(){
        Driver.getDriver().get(Config.getValue("url"));
        Faker faker = new Faker();
        String word = faker.lorem().word();
        googleHomePage.searchBox.sendKeys(word + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(word));
        Driver.quit();


    }

}
