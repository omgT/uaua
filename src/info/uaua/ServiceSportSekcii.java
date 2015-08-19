package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceSportSekcii {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnSportSekcii_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://sports.uaua.info/']");
	By clickOnSportSekcii_Footer = By.xpath("html/body/footer//a[text()='Спортивные секции']");
	By clickOnSportSekcii_header = By.xpath(".//*[@class = 'sub']//a[text()='Спортивные секции']");
	By clickOnSportSekcii_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Спортивные секции']");
			
	
	public ServiceSportSekcii(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceSportSekcii clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceSportSekcii clickOnSportSekcii_Service() {
		driver.findElement(clickOnSportSekcii_Service).click();
		return this;
	}
	public ServiceSportSekcii clickOnSportSekcii_Footer() {
		driver.findElement(clickOnSportSekcii_Footer).click();
		return this;
	}
	
	public ServiceSportSekcii clickOnSportSekcii_header() {
		driver.findElement(clickOnSportSekcii_header).click();
		return this;
	}
	
	public ServiceSportSekcii clickOnSportSekcii_Objects() {
		driver.findElement(clickOnSportSekcii_Objects).click();
		return this;
	}
	public ServiceSportSekcii moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
