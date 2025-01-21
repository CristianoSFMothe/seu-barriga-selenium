package steps;

import base.BaseSteps;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {
    LoginPage page = new LoginPage();

    @Given("the use is on the login page")
    public void theUseIsOnTheLoginPage() {
        page.accessPageLogin();
    }
}
