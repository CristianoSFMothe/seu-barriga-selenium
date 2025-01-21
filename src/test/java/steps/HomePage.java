package steps;

import base.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class HomePage extends BaseSteps {

    @Dado("que acesso o site Seu Barriga")
    public void que_acesso_o_site_seu_barriga() {
        System.out.println("Passei 1");
    }
    @Quando("visualizo o texto {string} na página")
    public void visualizo_o_texto_na_página(String string) {
        System.out.println("Passei 2");
    }
    @Então("confirmo que estou na página inicial do site")
    public void confirmo_que_estou_na_página_inicial_do_site() {
        System.out.println("Passei 3");
    }

}
