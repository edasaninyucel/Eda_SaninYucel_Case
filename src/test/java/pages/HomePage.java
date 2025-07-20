package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private final By logo= By.xpath("//img[@alt='insider_logo']");

    public boolean isHomePageLoaded(){

        return isElementDisplayed(logo);
    }

    public void goToHomePage(){
        driver.get("https://useinsider.com/");
        closeCookieBanner();
    }

}
