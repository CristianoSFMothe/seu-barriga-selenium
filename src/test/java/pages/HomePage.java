package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private String url = "https://seubarriga.wcaquino.me/login";
    private By msgWelcome = By.className("navbar-brand");

    public boolean validateCurrentPage(String url) {
        String currentUrl = getCurrentUrl();
        return currentUrl.equals(url);
    }

    public void accessHomePage() {
        visitPage(url);
    }

    public String msgWelcome(){
        waitElementVisible(msgWelcome, 10);
        return getValueByText(msgWelcome);
    }
}
