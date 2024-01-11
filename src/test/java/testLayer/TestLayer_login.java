package testLayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.Login_POM;

public class TestLayer_login extends BaseClass{
	
	static Login_POM pom;
	
	
	public TestLayer_login() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup_browser() throws InterruptedException {
		
		browsersetup();
		pom=new Login_POM();
		Thread.sleep(3000);
	}
	
	@Test
	public void login() throws InterruptedException {
		
		pom.typename(prop.getProperty("username"));
		pom.typepwd(prop.getProperty("password"));
		pom.login();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}
	
	@Test
	public void verify() throws InterruptedException {
		
		pom.forgotpassword();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
		//Assert.assertEquals("Reset Password", title);
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.close();
	}
	
	
	

}
