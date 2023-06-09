package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Config;
import utilities.Driver;

public class Google {

    @Test
    public void firstTest(){
        Driver.getDriver().get(Config.getValue("url"));
        Faker faker = new Faker();
        String word = faker.lorem().word();
        Driver.getDriver().findElement(By.name("q")).sendKeys(word + Keys.ENTER);
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue("Title failed", title.contains(word));



    }

}
