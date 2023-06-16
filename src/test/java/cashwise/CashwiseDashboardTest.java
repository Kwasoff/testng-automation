package cashwise;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CashwiseDashboardPage;
import pages.CashwiseHomePage;
import utilities.Config;
import utilities.Driver;

public class CashwiseDashboardTest {

    CashwiseHomePage cashwiseHomePage;
    CashwiseDashboardPage cashwiseDashboardPage;

    @BeforeMethod
    public void beforeSettings(){
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
    }

    @Test
    public void dashboardAndInfographicsTests(){
        cashwiseHomePage = new CashwiseHomePage();
        cashwiseDashboardPage = new CashwiseDashboardPage();
        cashwiseHomePage.loginIntoCashwise(Config.getValue("cashwiseLogin"), Config.getValue("cashwisePassword"));
        int expectedSize = 3;
        Assert.assertEquals(expectedSize, cashwiseDashboardPage.dashdoard.size(), "sizes are different" );
        Assert.assertEquals(cashwiseDashboardPage.dashdoard.get(0).getText(), "Sales");
        Assert.assertEquals(cashwiseDashboardPage.dashdoard.get(1).getText(), "Expenses");
        Assert.assertEquals(cashwiseDashboardPage.dashdoard.get(2).getText(), "Reports");
        Assert.assertEquals(cashwiseDashboardPage.infographics.getText(), "Infographics");


    }

}
