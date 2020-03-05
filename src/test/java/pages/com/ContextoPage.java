package pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.com.config;

public class ContextoPage {
	private WebDriver driver;
	
	public ContextoPage() {
		driver = config.ObterDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userName")
	public WebElement user;
	
	@FindBy(name="password")
	public WebElement pass;	
	
	@FindBy(name="login")
	public WebElement login;	
	
	public void acessarSistema(String url) {
		driver.navigate().to(url);
	}
	
	public void login() {
		user.sendKeys("Mercury");
		pass.sendKeys("mercury");
	}
}
