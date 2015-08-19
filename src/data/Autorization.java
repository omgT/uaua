package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface Autorization {
	WebDriver driver = null;
	By clickOnAutorization = By.xpath(".//*[@id='open_login_popup']");
	By emailField = By
			.xpath(".//*[@id='ua-welcom-window']//*[@class = 'uaww-email']");
	By passlField = By
			.xpath(".//*[@id='ua-welcom-window']//*[@class = 'uaww-pass']");
	By clickOnVhodUaua = By.xpath(".//*[@id='rrr1']");

	String correctLogin = "testforumuaua@ukr.net";

	String correctPass = "123456";

	String correctPassProd = "testforumuaua";

}