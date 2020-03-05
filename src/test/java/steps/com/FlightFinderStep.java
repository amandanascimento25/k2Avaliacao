package steps.com;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import pages.com.FlightFinderPage;

public class FlightFinderStep {
	
	FlightFinderPage finder = new FlightFinderPage();
	
	@Dado("^que estou na tela flight finder$")
	public void que_estou_na_tela_flight_finder() throws Throwable {
	   finder.ValidaTela();
	}
	
	@Quando("^preencho os campos \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preencho_os_campos_e(String Tipo, String QtdPassageiros, String Saida, String MesSaida, String DataSaida, String Destino, String MesChegada, String DataChegada, String ServiceClass, String Airline) throws Throwable {
		finder.PreencheCampo(Tipo, QtdPassageiros, Saida, MesSaida, DataSaida, Destino, MesChegada, DataChegada, ServiceClass, Airline);
	}

	@Quando("^clico em continue flight finder$")
	public void clico_em_continue() throws Throwable {
	    finder.Continue.click();
	}
}
