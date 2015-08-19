package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceOtduhZdorovje {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnOtduhZdorovje_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://camps.uaua.info/']");
	By clickOnOtduhZdorovje_Footer = By.xpath("html/body/footer//a[text()='־עהûץ ט חהמנמגüו']");
	By clickOnOtduhZdorovje_header = By.xpath(".//*[@class = 'sub']//a[text()='־עהûץ ט חהמנמגüו']");
	By clickOnOtduhZdorovje_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='־עהûץ ט חהמנמגüו']");
			
	
	public ServiceOtduhZdorovje(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceOtduhZdorovje clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceOtduhZdorovje clickOnOtduhZdorovje_Service() {
		driver.findElement(clickOnOtduhZdorovje_Service).click();
		return this;
	}
	public ServiceOtduhZdorovje clickOnOtduhZdorovje_Footer() {
		driver.findElement(clickOnOtduhZdorovje_Footer).click();
		return this;
	}
	
	public ServiceOtduhZdorovje clickOnOtduhZdorovje_header() {
		driver.findElement(clickOnOtduhZdorovje_header).click();
		return this;
	}
	
	public ServiceOtduhZdorovje clickOnOtduhZdorovje_Objects() {
		driver.findElement(clickOnOtduhZdorovje_Objects).click();
		return this;
	}
	public ServiceOtduhZdorovje moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
