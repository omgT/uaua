package info.uaua;
import data.Autorization;
import data.CommonMethods;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ServiceBudjetRodu  {
	
	WebDriver driver;
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), 'Сервисы')]");
	By chooseBudjetRodu = By.partialLinkText("роды");
	By clickUslugiRoddoma = By.xpath(".//*[@id='budget-form']/div[1]/ul[12]");
	By sumItog = By.xpath(".//*[@id='total_year_budget_top']/span");
	By buttonSave = By.id("budget-save-button");
	
	
	
	public ServiceBudjetRodu buttonSave() {
		driver.findElement(buttonSave).click();
		return this;
		
	}
	
	public ServiceBudjetRodu budget() {
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.chord(Keys.CONTROL, "-")).build().perform();
		int razdel = 0;
		for (razdel = 1; razdel <= 13; razdel++) {
			driver.findElement(
					By.xpath(".//*[@id='budget-form']/div[1]/ul[" + razdel
							+ "]")).click();
		}
		driver.findElement(clickUslugiRoddoma).click();
		int priceField = 0;
		String price = "1000";
		String numOf = "2";
		
		for (priceField = 1; (priceField <=260) ; priceField++) {
			if (priceField <=89 || priceField==259 || priceField==260 ){
			WebElement priceForm = driver.findElement(By.xpath(".//*[@id='product-" + priceField
							+ "']//input[@class = 'product-price']"));
				priceForm.clear();
				priceForm.sendKeys(price);
			
			WebElement numForm = driver.findElement(By.xpath(".//*[@id='product-" + priceField
							+ "']//span[2]//input"));
				numForm.clear();
				numForm.sendKeys(numOf);
				
			WebElement chekbox = driver.findElement(By.xpath(".//*[@id='product-title-" + priceField
					+ "']"));
						if (chekbox.getAttribute("data-default").contains("0")){
				WebElement chekboxNotchecked = driver.findElement(By.xpath(".//*[@id='product-" + priceField
					+ "']/li[1]/label"));
				chekboxNotchecked.click();
						}
			}
		}
		
		return this;
	}
	

	public ServiceBudjetRodu chooseBudjetRodu() {
		driver.findElement(chooseBudjetRodu).click();
		return this;
	}
	public ServiceBudjetRodu clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
		
	}
	public ServiceBudjetRodu(WebDriver driver) {
		this.driver = driver;
	}




}
