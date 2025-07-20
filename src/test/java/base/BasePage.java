package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver ;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForElementVisible(locator).click();
    }

    protected boolean isElementDisplayed(By locator){
        try{
            boolean visible = waitForElement(locator).isDisplayed();
            System.out.println("Element displayed: " + locator.toString());
            return visible;
        }catch (Exception e){
            System.out.println("Element not displayed: " + locator.toString());
            return false;
        }
    }
    protected WebElement waitForElementVisible (By locator){
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            String errorMsg = "Element " + locator + " cannot be located timeout ";
            System.out.println(errorMsg);
            throw new RuntimeException(errorMsg, e);
        }
    }
    protected void hoverOver(By locator){
        WebElement element = waitForElementVisible(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void hoverOver(WebElement element){
        Actions actions= new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void wait(int miliseconds){
        try{
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    protected void closeCookieBanner(){
        try{
            WebElement cookieDeclineButton = driver.findElement(By.xpath("//*[@id=\"wt-cli-reject-btn\"]"));
            if(cookieDeclineButton.isDisplayed()){
                cookieDeclineButton.click();
                wait(1000);
            }
        }catch (NoSuchElementException e){
            System.out.println("Cookie banner already closed or not found");
        }

    }

    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();

        }
    }

}
