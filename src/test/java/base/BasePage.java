package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.BrowserFactory;

import java.time.Duration;

public class BasePage extends BrowserFactory {
    public void visitPage(String url) {
        getBrowser().get(url);
    }

    public void click(By locator) {
        getBrowser().findElement(locator).click();
    }

    public void pressEnter() {
        new Actions(getBrowser()).sendKeys(Keys.ENTER).perform();
    }

    public void fill(By locator, String texto) {
        getBrowser().findElement(locator).clear();
        getBrowser().findElement(locator).sendKeys(texto);
    }

    public void waitElementVisible(By element, int seconds) {
        WebDriver driver = getBrowser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getValueByText(By locator) {
        return getBrowser().findElement(locator).getText();
    }

    public String getCurrentUrl() {
        return getBrowser().getCurrentUrl();
    }
}
