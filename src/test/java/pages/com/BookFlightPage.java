package pages.com;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.com.config;

public class BookFlightPage {
	private WebDriver driver;
	
	public BookFlightPage() {
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td.data_left")
	public WebElement ValidaIda;
	
	@FindBy(css="body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td.data_left")
	public WebElement ValidaVolta;
	
	@FindBy(name="passFirst0")
	public WebElement Nome;
	
	@FindBy(name="passLast0")
	public WebElement Sobrenome;
	
	@FindBy(name="creditnumber")
	public WebElement Cartao;
	
	@FindBy(name="buyFlights")
	public WebElement Continue;
	
	public void PreencheCampo(String cNome, String cSobrenome, String cCartao) {
		Nome.sendKeys(cNome);
		Sobrenome.sendKeys(cSobrenome);
		Cartao.sendKeys(cCartao);
	}
	
	public void ValidaTela() {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		if (wait.until(ExpectedConditions.visibilityOfAllElements(Continue)) == null) {
			Assert.fail("A tela book a flight não foi carregada.");
		}

	}
	
	public void ValidaViagemIda(String Airlines) {
		if(!Airlines.equals(ValidaIda.getText())) {
			Assert.fail("Linha aérea diferente do esperado.\n esperado: " + Airlines);
		}
	}
	
	public void ValidaViagemVolta(String Airlines) {
		if(!Airlines.equals(ValidaVolta.getText())) {
			Assert.fail("Linha aérea diferente do esperado.\n esperado: " + Airlines);
		}
	}
}

