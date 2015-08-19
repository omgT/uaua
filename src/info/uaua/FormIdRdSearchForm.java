package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormIdRdSearchForm {
	WebDriver driver;
	By clickOnNaitiObject = By.xpath("//input[@class='btn_some']");
	By clickOnOblast = By.xpath(".//*[@id='rg_id']");
	By clickOnOblastFirstElement = By.xpath(".//*[@id='rg_id']/option[1]");
	By clickOnCity = By.xpath(".//*[@id='c_id']");
	By clickOnCityFirstElement = By.xpath(".//*[@id='c_id']/option[1]");
	By clickOnInvisible = By.id("show_search_form");

	By clickObjectRight = By
			.xpath(".//*[@id='rd_search_form']//a[@class ='next browse right']");
	By clickObjectLeft = By
			.xpath(".//*[@id='rd_search_form']//a[@class ='prev browse left']");

	
	public FormIdRdSearchForm findColumnsOfTable() {
	driver.findElement(By.id("rd_name"));
	driver.findElement(By.id("rd_city"));
	driver.findElement(By.id("rd_address"));
	driver.findElement(By.id("rd_rating"));
	driver.findElement(By.xpath("//th[@class='last']"));
	return this;
	}
	
	public FormIdRdSearchForm(WebDriver driver) {
		this.driver = driver;
	}

	public FormIdRdSearchForm clickObjectRight() {
		driver.findElement(clickObjectRight).click();
		return this;
	}

	public FormIdRdSearchForm clickObjectLeft() {
		driver.findElement(clickObjectLeft).click();
		return this;
	}

	public FormIdRdSearchForm clickOnInvisible() {
		driver.findElement(clickOnInvisible).click();
		return this;
	}

	public FormIdRdSearchForm clickOnNaitiObject() {
		driver.findElement(clickOnNaitiObject).click();
		return this;
	}

	public FormIdRdSearchForm clickOnOblast() {
		driver.findElement(clickOnOblast).click();
		return this;
	}

	public FormIdRdSearchForm clickOnOblastFirstElement() {
		driver.findElement(clickOnOblastFirstElement).click();
		return this;
	}

	public FormIdRdSearchForm clickOnCity() {
		driver.findElement(clickOnCity).click();
		return this;
	}

	public FormIdRdSearchForm clickOnCityFirstElement() {
		driver.findElement(clickOnCityFirstElement).click();
		return this;
	}
}