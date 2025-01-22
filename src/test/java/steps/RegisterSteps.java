package steps;

import base.BaseSteps;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;

import java.util.Locale;

public class RegisterSteps extends BaseSteps {
    Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    RegisterPage page = new RegisterPage();
    HomePage homePage = new HomePage();

    @Dado("que eu acesso o site do Seu Barriga")
    public void que_eu_acesso_o_site_do_seu_barriga() {
        homePage.accessHomePage();
        screenshot();
    }

    @E("clico no menu {string}")
    public void clico_no_menu(String string) {
        page.clickMenuNewUser();
        screenshot();
    }

    @E("preencho os campos obrigatórios")
    public void preencho_os_campos_obrigatórios() {
         page.setName(name);
         page.setEmail(email);
         page.setPassword(password);
         screenshot();
    }

    @Quando("clico no botão {string}")
    public void clico_no_botão(String string) {
         page.clickBtnRegister();
         screenshot();
    }

    @Então("vejo a mensagem {string}")
    public void vejo_a_mensagem(String msg) {
        Assert.assertEquals(msg, page.msgSuccess());
        screenshot();
    }

    @Então("sou redirecionado para a página de login")
    public void sou_redirecionado_para_a_página_de_login() {
        Assert.assertTrue(page.urlRedirect("https://seubarriga.wcaquino.me/cadastrarUsuario"));
        screenshot();
    }

}
