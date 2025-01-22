package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private String url = "https://seubarriga.wcaquino.me/login";
    private By msgWelcome = By.className("navbar-brand");
    private By menuRegister = By.cssSelector("[href='/cadastro']");
    private By inputName = By.id("nome");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("senha");
    private By btnRegister = By.className("btn-primary");
    private By msgSuccess = By.className("alert-success");
    private String urlRedirect = "https://seubarriga.wcaquino.me/cadastrarUsuario";

    public void clickMenuNewUser() {
        visitPage(url);
        click(menuRegister);
    }

    public void setName(String name) {
        fill(inputName, name);
    }

    public void setEmail(String email) {
        fill(inputEmail, email);
    }

    public void setPassword(String password) {
        fill(inputPassword, password);
    }

    public void clickBtnRegister() {
        click(btnRegister);
    }

    public String msgSuccess() {
        waitElementVisible(msgSuccess, 10);
        return getValueByText(msgSuccess);
    }

    public boolean urlRedirect(String url) {
        String  urlRedirect = getCurrentUrl();
        return urlRedirect.equals(url);
    }
}
