package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_setting_values.notifications", 2);

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--start-maximized");
                    options.addArguments("--remote-allow-origins=*");

                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                    firefoxOptions.addPreference("dom.push.enabled", false);
                    firefoxOptions.addPreference("dom.disable_open_during_load", true);
                    driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().window().maximize();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
