package steps;

import base.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps extends BaseSteps {

    HomePage page = new HomePage();

    @Dado("que acesso o site Seu Barriga")
    public void que_acesso_o_site_seu_barriga() {
        page.accessHomePage();
        screenshot();
    }

    @Quando("visualizo o texto {string}")
    public void visualizo_o_texto(String msg) {
        Assert.assertEquals(msg, page.msgWelcome());
        screenshot();
    }

    @Então("confirmo que estou na página inicial do site")
    public void confirmo_que_estou_na_página_inicial_do_site() {
        Assert.assertTrue(page.validateCurrentPage("https://seubarriga.wcaquino.me/login"));
        screenshot();
    }

}
