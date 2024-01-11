package datadriven;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webElement_methods.Webelements;

public class DatadrivenTestng {
	
	public WebDriver driver;
	
	 Webelements web=new Webelements(driver);
	
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("WebDriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();		
	}
	
	@BeforeMethod
	public void launchurl() throws InterruptedException {
		driver.get("https://admin-demo.nopcommerce.com/login");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	@DataProvider(name="details")
	public Object[][] getdata(){
		
		return new Object[][] {{"admin@yourstore.com","admin","valid"},
			                   {"admin@yourstore.com","admin1","invalid"},
			                   {"mohanty@gmail.com","admin1","invalid"},
			                   {"neeta","neeta","invalid"}};
		}
	
	
	@Test(dataProvider="details")
	public void login(String mail1,String pwd,String data) throws InterruptedException {
		
		/*
		 * email.sendKeys(mail); driver.findElement(By.id("Password")).sendKeys(pwd);
		 * driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		 */
		
		web.enterdata(mail1, pwd);
		
		String exptitle="Dashboard / nopCommerce administration";
		String actual=driver.getTitle();
		
		if(data.equals("valid")) {
			
			if(exptitle.equals(actual)) {
				driver.findElement(By.cssSelector("#navbarText > ul > li:nth-child(3) > a")).click();
				Thread.sleep(2000);
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		else if (data.equals("invalid")) {
			
			if (exptitle.equals(actual)) {
				
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}		
		
	}
	
	@AfterClass
	public void close() {
		
		driver.close();
	}

}
