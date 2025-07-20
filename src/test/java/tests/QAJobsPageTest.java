package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAJobsPage;

public class QAJobsPageTest extends BaseTest {

    @Test
    public void testQaJobsListAfterFiltering(){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.goToQaJobsPage();
        System.out.println("Qa page loaded successfully...");

        qaJobsPage.clickSeeAllQaJobsButton();
        System.out.println("Clicking the see all button..");

        qaJobsPage.selectLocationFilter();
        qaJobsPage.selectDepartmentFilter();
        System.out.println("Selecting the filters..");

        qaJobsPage.isJobListVisible();

        Assert.assertTrue(qaJobsPage.isJobListVisible(), "QA job list is not visible after filtering.");
        System.out.println("Job List is full..");

    }
    @Test
    public void testAllJobsAreFilteredCorrectly(){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.goToQaJobsPage();
        System.out.println("Qa page loaded successfully...");

        qaJobsPage.clickSeeAllQaJobsButton();
        System.out.println("Clicking the see all button..");

        qaJobsPage.selectLocationFilter();
        qaJobsPage.selectDepartmentFilter();
        System.out.println("Selecting the filters..");

        boolean allFilteredCorrectly = qaJobsPage.areAllJobsFilteredCorrectly();

        Assert.assertTrue(allFilteredCorrectly,"Some jobs do not match the filter: QA / Istanbul / Department" );
        System.out.println("Filtered is working correctly!");

    }
    @Test
    public void testLeverApplicationForm(){
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.goToQaJobsPage();
        System.out.println("Qa page loaded successfully...");

        qaJobsPage.clickSeeAllQaJobsButton();
        System.out.println("Clicking the see all button..");

        qaJobsPage.selectLocationFilter();
        qaJobsPage.selectDepartmentFilter();
        System.out.println("Selecting the filters..");

        qaJobsPage.clickViewRoleControl();

        String currentURL= qaJobsPage.getCurrentPageUrl();
        Assert.assertTrue(currentURL.contains("lever.co"), "View Role button does not redirect to Lever application page.");
        System.out.println("Page redirect succesfull!");


    }

}
