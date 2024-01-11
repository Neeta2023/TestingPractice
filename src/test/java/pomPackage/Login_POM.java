package pomPackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class Login_POM extends BaseClass {
	
	
	
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement name;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement login;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']") WebElement frgtpwd;
	
	public Login_POM() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void typename(String uname) {
		name.sendKeys(uname);
	}
	
	public void typepwd(String password1) {
		password.sendKeys(password1);
	}
	
	public void login() {
		login.click();
	}
	
	public void forgotpassword() {
		frgtpwd.click();
	}
	

}
