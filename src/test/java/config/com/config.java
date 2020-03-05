package config.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class config {
	
	public static WebDriver driver;
	
	public static WebDriver ObterDriver() {
		return driver;
	}
	
	@Before
	public void ConfiguracaoInicial() {
		
		System.out.println("inicio do teste");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void FecharJanela() {
		driver.quit();
		System.out.println("Fim de teste");	
		
	}
}
