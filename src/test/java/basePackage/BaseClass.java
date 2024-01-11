package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	public BaseClass() {
		
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\mohan\\eclipse-workspace\\TestngPractice\\src\\test\\java\\environment_Variable\\config.properties");
		prop.load(file);
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
		}
		catch(IOException I) {
			I.printStackTrace();
		}
			
	}
	
	public void browsersetup() {
		
		String Browser=prop.getProperty("browser");
		
		if(Browser.equals("Firefox"))
		{
			System.setProperty("WebDriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{ 
			System.out.println("browser not firefox");
			}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
	}

}
