package base;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.BrowserFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseSteps extends BrowserFactory { ;
    public static Scenario scenario;
    public static boolean closeBrowser = true;

    public static void OpenBrowser() {
        if (getBrowser() != null);
    }

    public static void CloseBrowser() {
        if (getBrowser()== null) return;
        killDriver();
        // browser = null;
    }

    public static void screenshot() {
        try {
            String dataHora = (new SimpleDateFormat("yyyy-MM-dd_-_HH-mm-ss-SSS")).format(new Date());
            byte[] screenshot = ((TakesScreenshot) getBrowser()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", dataHora + "_screenshot.png");
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}