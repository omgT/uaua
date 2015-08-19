package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceDetskieSadu {

	WebDriver driver;
	
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnDetskieSadu_Service = By.xpath(".//ul[@class = 'list-3']//a[@href='http://detsad.uaua.info/']");
	By clickOnDetskieSadu_Footer = By.xpath("html/body/footer//a[text()='Детские сады']");
	By clickOnDetskieSadu_header = By.xpath(".//*[@class = 'sub']//a[@href='http://detsad.uaua.info/']");
	By clickOnDetskieSadu_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Детские сады']");
	
	
	public ServiceDetskieSadu(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceDetskieSadu clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	public ServiceDetskieSadu clickOnDetskieSadu_Service() {
		driver.findElement(clickOnDetskieSadu_Service).click();
		return this;
	}
	public ServiceDetskieSadu clickOnDetskieSadu_Objects() {
		driver.findElement(clickOnDetskieSadu_Objects).click();
		return this;
	}
	public ServiceDetskieSadu clickOnDetskieSadu_Footer() {
		driver.findElement(clickOnDetskieSadu_Footer).click();
		return this;
	}
	
	
	public ServiceDetskieSadu clickOnDetskieSadu_header() {
		driver.findElement(clickOnDetskieSadu_header).click();
		return this;
	}
	public ServiceDetskieSadu moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	
}
