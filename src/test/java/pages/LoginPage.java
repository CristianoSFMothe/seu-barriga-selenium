package pages;

import base.BasePage;

public class LoginPage extends BasePage {
    private String urlLogin = "https://seubarriga.wcaquino.me/login";

    public void accessPageLogin() {
        visitPage(urlLogin);;
    }
}
