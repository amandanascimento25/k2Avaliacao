package pages.com;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.com.config;

public class FlightConfirmationPage {
	
private WebDriver driver;
	
	public FlightConfirmationPage() {
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > b > font > font > b > font:nth-child(1)")
	public WebElement Confirmacao;
	
	public void ConfirmaViagem() {
		if (Confirmacao.getText() != "") {
			assertTrue(Confirmacao.getText(), true);
		}else{
			Assert.fail("Não foi possivel gerar numero de reserva");
		}
	}
	
	public void ValidaTela() {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		if (wait.until(ExpectedConditions.visibilityOfAllElements(Confirmacao)) == null) {
			Assert.fail("A tela Flight Confirmation não foi carregada.");
		}

	}
}
