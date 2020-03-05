package pages.com;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.com.config;

public class SelectFlightPage {
	private WebDriver driver;

	public SelectFlightPage() {
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9)")
	public WebElement TabelaDepature;

	@FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(10)")
	public WebElement TabelaReturn;

	@FindBy(name = "reserveFlights")
	public WebElement Continue;

	public void ValidaTela() {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		if (wait.until(ExpectedConditions.visibilityOfAllElements(Continue)) == null) {
			Assert.fail("A tela select flight não foi carregada.");
		}

	}

	public void BuscaLinhaAerea(WebElement Tabela, String LinhaAerea) {
		int linhas = Tabela.findElements(By.tagName("tr")).size() - 3;

		boolean Achou = false;

		for (int i = 4; i <= linhas; i+=2) {
			WebElement campo = Tabela.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(1);

			if (campo.getText().equals(LinhaAerea)) {
				WebElement campo1 = Tabela.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0);
				WebElement radio = campo1.findElement(By.tagName("input"));
				radio.click();
				Achou = true;
				break;
			}
		}

		assertFalse("A Linha aérea " + LinhaAerea + " não foi encontrada", Achou == false);

	}

}
