package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    @Test
    public void testHomePageLoadsSuccessfully(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        System.out.println("Navigate to Home Page...");

        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page did not load successfully!" );
        Assert.assertTrue(driver.getCurrentUrl().contains("useinsider.com"));
        System.out.println("Home page loaded successfully!");

    }

}
