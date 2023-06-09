package tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.AmazonHomePage;
import pages.EtsyHomePage;
import pages.GoogleHomePage;
import utilities.Config;
import utilities.Driver;

public class GoogleAmazonEtsyInitials {

    GoogleHomePage googleHomePage = new GoogleHomePage();
    AmazonHomePage amazonHomePage = new AmazonHomePage();
    EtsyHomePage etsyHomePage = new EtsyHomePage();
    Faker faker = new Faker();

    @Test
    public void googleTest(){
        Driver.getDriver().get(Config.getValue("googleURL"));
        String word = faker.lorem().word();
        googleHomePage.searchBox.sendKeys(word + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(word));
        Driver.quit();

    }

    @Test
    public void amazonTest(){
        Driver.getDriver().get(Config.getValue("amazonURL"));
        String data = "shaved sheep toy";
        amazonHomePage.searchBox.sendKeys(data + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(data));

    }

    @Test
    public void etsyTest(){
        Driver.getDriver().get(Config.getValue("etsyURL"));
        String data = faker.pokemon().name();
        etsyHomePage.searchBar.sendKeys(data + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(data));

    }

    @After
    public void afterSettings(){
        Driver.quit();
    }


}
