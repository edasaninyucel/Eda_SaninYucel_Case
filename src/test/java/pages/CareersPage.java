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
    private final By locationBlock= By.xpath("//div[contains(@class, 'col-12') and contains(@class, 'mt-3')]\n");
    private final By teamsBlock = By.xpath("//section[@id='career-find-our-calling']");
    private final By lifeAtInsiderBlock = By.xpath("//div[contains(@class, 'elementor-widget-media-carousel')]//div[contains(@class, 'elementor-widget-container')]\n");


    public void clickCompanyMenu(){
        hoverOver(companyMenu);
        click(companyMenu);
    }

    public void navigateToCareersPage(){
        closeCookieBanner();
        hoverOver(companyMenu);
        click(companyMenu);
        wait(2000);
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
