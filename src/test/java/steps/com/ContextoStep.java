package steps.com;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.com.ContextoPage;

public class ContextoStep {
	
	ContextoPage contexto = new ContextoPage();
	
	@Dado("^que acesso o link \"([^\"]*)\"$")
	public void que_acesso_o_link(String url) throws Throwable {
	   contexto.acessarSistema(url);
	}

	@Quando("^digito o valor de usuario e senha$")
	public void digito_o_valor_de_usuario_e_senha() throws Throwable {
		contexto.login();
	}

	@Entao("^clico em Sign-in$")
	public void clico_em_Sign_in() throws Throwable {
		contexto.login.click();
	}

}
