package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class QAJobsPage extends BasePage {

    public QAJobsPage(WebDriver driver){
        super(driver);
    }

    private final By seeAllQAJobsButton = By.xpath(".//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");
    private final By filterByLocation = By.xpath("//span[@id='select2-filter-by-location-container']");
    private final By locationIstanbul = By.xpath("//li[@class='select2-results__option' and contains(text(), 'Istanbul')]");
    private final By filterByDepartment = By.xpath("//span[@id='select2-filter-by-department-container']");
    private final By qualityAssurance = By.xpath("//li[@class='select2-results__option' and contains(text(), 'Quality Assurance')]\n");
    private final By jobList = By.xpath("//*[@id=\"jobs-list\"]");
    private final By jobCards = By.cssSelector("div.position-list-item-wrapper");
    private final By viewRole=By.xpath("//a[contains(@class,'btn-navy') and text()='View Role']\n");
    private final By locationOption = By.xpath("//select[@id='filter-by-location']/option[contains(@class, 'job-location')]");

    public boolean areAllJobsFilteredCorrectly(){

        scrollTo(jobCards);
        List<WebElement> jobs = driver.findElements(jobCards);

        for (WebElement job: jobs){
            String position = job.findElement(By.cssSelector("p.position-title")).getText();
            String department = job.findElement(By.cssSelector("span.position-department")).getText();
            String location = job.findElement(By.cssSelector("div.position-location")).getText();

            if (!position.contains("Quality Assurance") ||
                    !department.contains("Quality Assurance") ||
                    !location.contains("Istanbul, Turkiye"))
            {
                System.out.println("Eşleşmiyor -> " + position + " | " + department + " | " + location);
                return false;
            }
            System.out.println("Eşleşiyor -> " + position + " | " + department + " | " + location);
        }
        return true;
    }
    public void clickSeeAllQaJobsButton(){
        waitForElementVisible(seeAllQAJobsButton);
        click(seeAllQAJobsButton);
    }

    public boolean isJobListVisible(){
        scrollTo(jobList);
        return driver.findElements(jobList).size() > 0 ;
    }
    public void goToQaJobsPage(){
        driver.get("https://useinsider.com/careers/quality-assurance/");
        wait(1000);
        closeCookieBanner();
    }

    public void clickViewRoleControl()
    {
        scrollTo(jobCards);
        wait(3000);
        List<WebElement> viewButtons = driver.findElements(viewRole);
        if(!viewButtons.isEmpty()){
            WebElement firstButton = viewButtons.get(0);
            hoverOver(firstButton);
            wait(2000);
            firstButton.click();

            ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        }else {
            throw new RuntimeException("No View Role buttons found!");
        }

    }
    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }
    public void selectLocationFilter(){
        waitForElementVisible(locationOption);
        click(filterByLocation);
        waitForElementVisible(locationIstanbul);
        //scrollTo(locationIstanbul);
        wait(1000);
        click(locationIstanbul);
        wait(2000);
    }
    public void selectDepartmentFilter(){
        waitForElementVisible(filterByDepartment);
        click(filterByDepartment);
        wait(2000);
        scrollTo(qualityAssurance);
        waitForElementVisible(qualityAssurance);
        click(qualityAssurance);
        wait(1000);

    }



}
