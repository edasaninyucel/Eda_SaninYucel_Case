package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver){
        super(driver);
    }
    private final By companyMenu = By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]");
    private final By careersMenu = By.xpath("//a[normalize-space()='Careers']");
    private final By locationBlock= By.xpath("//h3[@class='category-title-media ml-0']");
    private final By teamsBlock = By.xpath("//h3[normalize-space()='Find your calling']");
    private final By lifeAtInsiderBlock = By.xpath("//h2[normalize-space()='Life at Insider']");


    public void clickCompanyMenu(){
        hoverOver(companyMenu);
        click(companyMenu);
    }

    public void navigateToCareersPage(){
        closeCookieBanner();
        hoverOver(companyMenu);
        click(companyMenu);
        click(careersMenu);
    }

    public boolean areCareerBlocksVisible(){
        scrollTo(locationBlock);
        boolean locationVisible = isElementDisplayed(locationBlock);

        scrollTo(teamsBlock);
        boolean teamsVisible = isElementDisplayed(teamsBlock);

        scrollTo(lifeAtInsiderBlock);
        boolean lifeAtInsider = isElementDisplayed(lifeAtInsiderBlock);

        return locationVisible && teamsVisible && lifeAtInsider;
    }

}
