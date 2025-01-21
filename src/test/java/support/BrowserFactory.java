package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserFactory {

    private static WebDriver driver;
    protected WebDriverWait wait;

    public enum Browser {
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS
    }

    public static WebDriver getBrowser() {
        if (driver == null)  return getBrowser(Browser.CHROME);
        return driver;
    }

    public static WebDriver getBrowser(Browser nav) {
        ChromeOptions chromeOptions;
        FirefoxOptions firefoxOptions;

        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        switch (nav) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                chromeOptions = createChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            case CHROME_HEADLESS:
                WebDriverManager.chromedriver().setup();
                chromeOptions = createChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions = createFirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            case FIREFOX_HEADLESS:
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions = createFirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + nav);
        }
        return driver;
    }

    private static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=pt-BR");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-crash-reporter");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--log-level=3");
        options.addArguments("--output=/dev/null");
        options.addArguments("--window-size=1920,1080");
        return options;
    }

    private static FirefoxOptions createFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("extensions.enabled", false);
        return options;
    }

    public static void killDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
