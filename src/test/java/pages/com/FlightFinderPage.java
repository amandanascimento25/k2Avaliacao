package pages.com;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.com.config;


public class FlightFinderPage {

private WebDriver driver;
	
	public FlightFinderPage() {
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}
	
	//elementos
	@FindBy(name="tripType")
	public WebElement Tipo;
	
	@FindBy(name="passCount")
	public WebElement Passageiros;
	
	@FindBy(name="fromPort")
	public WebElement Partida;
	
	@FindBy(name="fromMonth")
	public WebElement MesDeSaida;
	
	@FindBy(name="fromDay")
	public WebElement Diasaida;
	
	@FindBy(name="toPort")
	public WebElement LocalDestino;
	
	@FindBy(name="toMonth")
	public WebElement MesDeChegada;
	
	@FindBy(name="toDay")
	public WebElement Diachegada;
	
	@FindBy(name="servClass")
	public WebElement ServClass;
	
	@FindBy(name="airline")
	public WebElement LinhaAerea;
	
	@FindBy(name="findFlights")
	public WebElement Continue;
	
	
	
	//métodos
	public void ValidaTela() {
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		if(wait.until(ExpectedConditions.visibilityOfAllElements(Tipo)) == null) {
			Assert.fail("A tela flight finder não foi carregada.");
		}
		
	}
	
	public void PreencheCampo(String Tipo, String QtdPassageiros, String Saida, String MesSaida, String DataSaida, String Destino, String MesChegada, String DataChegada, String ServiceClass, String Airline) {
		
		SelectRadioTipo("tripType", Tipo);
		SelectValue(Passageiros, QtdPassageiros);
		SelectValue(Partida, Saida);
		SelectValue(MesDeSaida, MesSaida);
		SelectValue(Diasaida, DataSaida);
		SelectValue(LocalDestino, Destino);
		SelectValue(MesDeChegada, MesChegada);
		SelectValue(Diachegada, DataChegada);
		SelectRadioService("servClass", ServiceClass);
		SelectAirline(Airline);
		
		
	}
	
	public void SelectValue(WebElement elemento, String valor) {
		Select ComboBox = new Select(elemento);
		ComboBox.selectByValue(valor);
	}
	
	public void SelectRadioTipo(String Name, String Valor) {
		
		List<WebElement> Radios = driver.findElements(By.name(Name));
		boolean Achou = false;
		
		for (WebElement Radio : Radios) {
			
			String ValorTabela = Valor.toLowerCase().replace(" ", "");
			String ValorRadio =  Radio.getAttribute("value");
			
			if(ValorRadio.contains(ValorTabela)) {
				Radio.click();
				Achou = true;
				break;
			}
		}
		
		if(!Achou) {
			Assert.fail("Não achou radio buttom " + Valor);
		}
	}
	
	public void SelectRadioService(String Name, String Valor) {
		
		List<WebElement> Radios = driver.findElements(By.name(Name));
		boolean Achou = false;
		
		for (WebElement Radio : Radios) {
			
			String ValorTabela = Valor;
			String ValorRadio =  Radio.getAttribute("value");
			
			if(ValorTabela.contains(ValorRadio)) {
				Radio.click();
				Achou = true;
				break;
			}
		}
		
		if(!Achou) {
			Assert.fail("Não achou radio buttom " + Valor);
		}
	}
	
	public void SelectAirline(String Airline) {
	
		Select ComboBox = new Select(LinhaAerea);
		
		switch (Airline) {
		case "No Preference":
			ComboBox.selectByIndex(0);
			break;
		
		case "Blue Skies Airlines":
			ComboBox.selectByIndex(1);
			break;

		case "Unified Airlines":
			ComboBox.selectByIndex(2);
			break;

		case "Pangea Airlines":
			ComboBox.selectByIndex(3);
			break;
		}
	}
}

