package steps.com;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.com.FlightConfirmationPage;

public class FlightConfirmationStep {
	
	FlightConfirmationPage confirmation = new FlightConfirmationPage();
	
	@Quando("^estou na tela Flight Confirmation$")
	public void estou_na_tela_Flight_Confirmation() throws Throwable {
	    confirmation.ValidaTela();
	}

	@Entao("^valido numero de confirmacao de reserva$")
	public void valido_numero_de_confirmacao_de_reserva() throws Throwable {
	    confirmation.ConfirmaViagem();
	}
}
