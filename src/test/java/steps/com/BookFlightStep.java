package steps.com;

import cucumber.api.java.pt.Quando;
import pages.com.BookFlightPage;

public class BookFlightStep {
	
	BookFlightPage BookFlight = new BookFlightPage();
	
	@Quando("^que estou na tela Book a Flight$")
	public void que_estou_na_tela_Book_a_Flight() throws Throwable {
	    BookFlight.ValidaTela();
	}

	@Quando("^valido Ida \"([^\"]*)\" e Volta \"([^\"]*)\"$")
	public void valido_Ida_e_Volta(String ida, String volta) throws Throwable {
	    BookFlight.ValidaViagemIda(ida);;
	    BookFlight.ValidaViagemVolta(volta);;
	}

	@Quando("^preencho os campos Nome \"([^\"]*)\", Sobrenome \"([^\"]*)\" e Numero \"([^\"]*)\"$")
	public void preencho_os_campos_Nome_Sobrenome_e_Numero(String nome, String sobrenome, String cartao) throws Throwable {
	    BookFlight.PreencheCampo(nome, sobrenome, cartao);
	}

	@Quando("^clico em Secure Purchase$")
	public void clico_em_Secure_Purchase() throws Throwable {
	    BookFlight.Continue.click();
	}
}
