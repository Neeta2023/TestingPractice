package webElement_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Webelements {
	
      WebDriver driver;
	
	
	@FindBy(id="Email") WebElement email;
	@FindBy(id="Password") WebElement paswd;
	@FindBy(xpath="//button[normalize-space()='Log in']\"") WebElement login;
	@FindBy(linkText="Logout") WebElement logout;
	
	public Webelements(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterdata(String mail1,String pwd) throws InterruptedException {
		
		email.sendKeys(mail1);
		Thread.sleep(2000);
		paswd.sendKeys(pwd);
		login.click();
	}

}
