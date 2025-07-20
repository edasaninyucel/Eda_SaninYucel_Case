package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class CareersPageTest extends BaseTest {

    @Test
    public void testCareerBlocksVisible(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        System.out.println("Navigate to Home Page...");

        CareersPage careersPage = new CareersPage(driver);
        careersPage.navigateToCareersPage();
        System.out.println("Navigate to Career Page...");

        Assert.assertTrue(careersPage.areCareerBlocksVisible(), "Career page blocks (Locations, Teams, Life at Insider) are not all visible.");
        System.out.println("All blocks are visible!");

    }
}
