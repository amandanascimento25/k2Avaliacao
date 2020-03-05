package steps.com;

import cucumber.api.java.pt.Quando;
import pages.com.SelectFlightPage;

public class SelectFlightStep {
	
	SelectFlightPage flight = new SelectFlightPage();
	
	@Quando("^que estou na tela Select Flight$")
	public void que_estou_na_tela_Select_Flight() throws Throwable {
	    flight.ValidaTela();
	}

	@Quando("^seleciono o voo de ida \"([^\"]*)\"$")
	public void seleciono_o_voo_de_ida(String voo) throws Throwable {
		flight.BuscaLinhaAerea(flight.TabelaDepature, voo);
	}

	@Quando("^seleciono o voo de volta \"([^\"]*)\"$")
	public void seleciono_o_voo_de_volta(String voo) throws Throwable {
		flight.BuscaLinhaAerea(flight.TabelaReturn, voo);
	}
	
	@Quando("^clico em continue select flight$")
	public void clico_em_continue() throws Throwable {
	    flight.Continue.click();
	}

}
