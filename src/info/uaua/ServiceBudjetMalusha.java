package info.uaua;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ServiceBudjetMalusha {
	WebDriver driver;
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), 'Сервисы')]");
	By chooseBudjetMalusha = By.partialLinkText("малыша");
	By clickUslugiRoddoma = By.xpath(".//*[@id='budget-form']/div[1]/ul[12]");
	By sumItog = By.xpath(".//*[@id='total_year_budget_top']/span");
	By buttonSave = By.id("budget-save-button");
	
	
	
	public ServiceBudjetMalusha buttonSave() {
		driver.findElement(buttonSave).click();
		return this;
		
	}
	
	public ServiceBudjetMalusha budget() {
		
		int razdel = 0;
		for (razdel = 1; razdel <= 10; razdel++) {
			driver.findElement(
					By.xpath(".//*[@id='budget-form']/div[1]/ul[" + razdel
							+ "]")).click();
		}
		driver.findElement(By.xpath(".//*[@id='budget-form']/div[1]/ul[2]")).click();
		String price = "1000";
		String numOf = "2";
		String month = "2";
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//ul[starts-with(@id, 'p')]"));
		
		for (WebElement perElement : allProducts) {
			String idString = perElement.getAttribute("id").substring(8);
			
			WebElement priceForm = driver.findElement(By.xpath(".//*[@id='product-" + idString
							+ "']//input[@class = 'product-price']"));
				priceForm.clear();
				priceForm.sendKeys(price);
			
			WebElement numForm = driver.findElement(By.xpath(".//*[@id='product-" + idString
							+ "']//*[@name = 'products[" + idString
						+ "][quantity]']"));
				numForm.clear();
				numForm.sendKeys(numOf);
				
				WebElement monthForm = driver.findElement(By.xpath(".//*[@id='product-" + idString
						+ "']//*[@name = 'products[" + idString
						+ "][months]']"));
				monthForm.clear();
				monthForm.sendKeys(month);
				
			WebElement chekbox = driver.findElement(By.xpath(".//*[@id='product-title-" + idString
					+ "']"));
						if (chekbox.getAttribute("data-default").contains("0")){
				WebElement chekboxNotchecked = driver.findElement(By.xpath(".//*[@id='product-" + idString
					+ "']/li[1]/label"));
				chekboxNotchecked.click();
						
			}
		}
		
		return this;
	}
	
	
	

	public ServiceBudjetMalusha chooseBudjetMalusha() {
		driver.findElement(chooseBudjetMalusha).click();
		return this;
	}
	public ServiceBudjetMalusha clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
		
	}
	public ServiceBudjetMalusha(WebDriver driver) {
		this.driver = driver;
	}
}
