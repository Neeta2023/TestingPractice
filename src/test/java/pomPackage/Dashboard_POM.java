package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class Dashboard_POM extends BaseClass{
	
	
	@FindBy(xpath="//span[normalize-space()='My Info']") WebElement myInfo;
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement fname;
	@FindBy(xpath="//input[@placeholder='Middle Name']") WebElement mname;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement lname;
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-"
			+ "vertical-padding']//div[1]//div[2]//div[1]//div[1]//div[2]//input[1]")WebElement nname;
	
	
	public Dashboard_POM() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void info() {
		myInfo.click();
	}
	
	public void enterdetails() {
		fname.sendKeys("arun");
		mname.sendKeys("kumar");
		lname.sendKeys("patil");
		nname.sendKeys("coco");
		
		
		
	}

}
