package testLayer;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.Dashboard_POM;
import pomPackage.Login_POM;

public class TestLayer_myInfo extends BaseClass{
	
	Dashboard_POM Dpom;
	Login_POM pom;
	
	
	public TestLayer_myInfo() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup_browser() throws InterruptedException {
		
		browsersetup();
		pom=new Login_POM();
		Thread.sleep(3000);
	}
	
	
	/*
	 * @BeforeMethod public void browser_setup() {
	 * 
	 * browsersetup(); Dpom=new Dashboard_POM(); pom=new Login_POM();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000)); }
	 */
	
	@Test
	public void dlogin() throws InterruptedException {
		
		
		pom.typename(prop.getProperty("username"));
		pom.typepwd(prop.getProperty("password"));
		pom.login();
		Thread.sleep(2000);
	}
	
	@Test
	public void myinfo() throws InterruptedException {
		
		Dpom=new Dashboard_POM();
		
	   Dpom.info();
	   Thread.sleep(2000);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Dpom.enterdetails();
	}
	
	@AfterMethod
	public void close() {
		
		driver.close();
	}

}
