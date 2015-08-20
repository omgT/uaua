package tests.uaua;
import data.CommonMethods;
import data.PropertiesDB;
import data.Autorization;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import info.uaua.ServiceBudjetMalusha;
import info.uaua.ServiceBudjetRodu;
import info.uaua.ServiceKalendarBeremenosti;
import info.uaua.ServiceKalendarProvivok;
import info.uaua.ServiceOpredeleniePola;
import info.uaua.ServicePribavkaDoGoda;
import info.uaua.ServiceRaschetDatuRodov;
import info.uaua.ServiceRazvitiePoMesjacam;
import info.uaua.ServiceTablitsaPricorma;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;*/
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestServicesRasschetnue implements PropertiesDB, Autorization {
	BrowserVersion browser;
	WebDriver driver;
	
	ServiceKalendarBeremenosti kalendarBerem;
	ServiceRaschetDatuRodov raschetRodov;
	ServiceOpredeleniePola polRebenka;
	ServiceTablitsaPricorma pricorm;
	ServiceRazvitiePoMesjacam poMesjacam;
	ServicePribavkaDoGoda doGoda;
	ServiceKalendarProvivok privivki;
	ServiceBudjetRodu rodu;
	ServiceBudjetMalusha malush;
	String folder = "Rasschetnue_Service";
	
	
	//@Parameters("browser") //��� ���������������� ������������, �������� chrome.xml
			@BeforeClass
			public void setUp() {
			/*public void setUp(String browser) {

					if (browser.equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver();
					} else if (browser.equalsIgnoreCase("chrome")) {
						System.setProperty("webdriver.chrome.driver",
								"D:\\chromedriver.exe");
						driver = new ChromeDriver();
					} else if (browser.equalsIgnoreCase("ie")) {
						File file = new File("D:\\IEDriverServer.exe");
						System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
						DesiredCapabilities capabilities = DesiredCapabilities
								.internetExplorer();
						driver = new InternetExplorerDriver(capabilities);
					} else if (browser.equalsIgnoreCase("opera")) {
						System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
						driver = new OperaDriver();
					} else if (browser.equalsIgnoreCase("safari")) {
						driver = new SafariDriver();
					}*/
				
				
				driver = new FirefoxDriver();
				driver.get(adress);
				System.out.println("Test services START ");
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
}
	
	
	@Test(description = "ID = <AKB01> ������� ���������� ���� ������������", alwaysRun = true)
	public void testAKB01() throws IOException{
		try {
		kalendarBerem = new ServiceKalendarBeremenosti(driver);
		kalendarBerem.perehodCheresService().chooseDay().clickRasschitat().makeScreen("������������ ���� ������������");
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <AKB02> ������ ����  � ��������� ������������", alwaysRun = true)
	public void testAKB02() throws IOException {
			try {
		kalendarBerem = new ServiceKalendarBeremenosti(driver);
		kalendarBerem = kalendarBerem.perehodCheresFooter().chooseIncorrectDay().clickRasschitat();
		CommonMethods.makeScreen(driver, "Services", "������ �������� ������������");
		CommonMethods.verifyStaticElements(driver);
		WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='left_col']/div[2]/span"));
		String actualErrorText = errorMessage.getText();
		String expectedErrorText = "������:";
		assertEquals(expectedErrorText, actualErrorText);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <RDR01> ������ ���� ����� ", alwaysRun = true)
		public void testRDR01() throws IOException{
			try {
			raschetRodov = new ServiceRaschetDatuRodov(driver);
			raschetRodov = raschetRodov.chooseDate().clickOpredelitDaty();
				CommonMethods.makeScreen(driver, "Services", "���� �����");
				CommonMethods.verifyStaticElements(driver);
			raschetRodov.clickPereschitat().clickOpredelitDaty();
				CommonMethods.makeScreen(driver, "Services", "������.������������� ����");
				CommonMethods.verifyStaticElements(driver);
			WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='left_col']//*[@class = 'errorsBox']/div"));
			String actualErrorText = errorMessage.getText();
			assertTrue(actualErrorText.contains("������ ���� ���������"));
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
			//TODO ��������� ����
		}
		
	
		@Test(description = "ID = <SOP01> ���������� ��� ������� ", alwaysRun = true)
		public void testSOP01() throws IOException {
			try {
			polRebenka = new ServiceOpredeleniePola(driver);

				CommonMethods.correctMailAutorisation(driver);
				CommonMethods.verifyStaticElements(driver);

			polRebenka = polRebenka.chooseDates();
				CommonMethods.makeScreen(driver, "Services", "���� ����");
				CommonMethods.verifyStaticElements(driver);

			polRebenka.clickOpredelit();
				CommonMethods.makeScreen(driver, "Services", "��� �������");
				CommonMethods.verifyStaticElements(driver);
			polRebenka.saveResult();
			
			WebElement saveMessage = driver.findElement(By.xpath(".//*[@id='left_col']/div[1]/div"));
			String actualSaveText = saveMessage.getText();
			assertTrue(actualSaveText.contains("������ ���������"));
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
		
		//TODO ��������� ����
	}
	
	@Test(description = "ID = <STP01> ������ � ������ �������� ", alwaysRun = true)
	public void testSTP01() throws IOException {
		try {
		pricorm = new ServiceTablitsaPricorma(driver);
		pricorm = pricorm.clickOnVse().clickTablitsaPricorma();
			CommonMethods.makeScreen(driver, "Services", "BO�");
			CommonMethods.verifyStaticElements(driver);
		pricorm.clickMOZ();
			CommonMethods.makeScreen(driver, "Services", "MO�");
			CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
		
	} 
	
	@Test(description = "ID = <RPM01> �������� �� �������. ��������� ��� ������ � ������ ������ ", alwaysRun = true)
	public void testRPMP01()throws IOException {
		try {
		poMesjacam = new ServiceRazvitiePoMesjacam(driver);
		poMesjacam = poMesjacam.clickOnVse().choosePoMesjacam().chooseMonth();
		CommonMethods.makeScreen(driver, "Services", "�������� �� �������");
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <PDG01> �������� ���� ������� �� ��� ", alwaysRun = true)
	public void testPDG01() throws IOException{
		try {
		doGoda = new ServicePribavkaDoGoda(driver);
		doGoda = doGoda.clickOnVse().choosePribavkaVesa().chooseBoy();
			CommonMethods.makeScreen(driver, "Services", "�������� ����_�������");
			CommonMethods.verifyStaticElements(driver);
		doGoda.chooseGirl();
			CommonMethods.makeScreen(driver, "Services", "�������� ����_�������");
			CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <KP01> ��������� �������� ", alwaysRun = true)
	public void testKP01() throws IOException{
		try {
		privivki = new ServiceKalendarProvivok(driver);
		privivki = privivki.clickOnVse().chooseKalendarPrivivok();
		CommonMethods.makeScreen(driver, "Services", "��������� ��������");
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <BBR01> ������ �� ������������ � ���� ", alwaysRun = true)
	public void testBBR01() throws IOException {
		try {
		rodu = new ServiceBudjetRodu(driver);
		rodu = rodu.clickOnVse().chooseBudjetRodu().budget();
			CommonMethods.makeScreen(driver, "Services", "������ �� ������������ � ����");
			CommonMethods.verifyStaticElements(driver);
		WebElement sumItogForm = driver.findElement(By.xpath(".//*[@id='total_year_budget_top']/span"));
		String sumItog = sumItogForm.getText();
		assertEquals(sumItog, "182,000.00");
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	/*@Test(description = "ID = <BBR02> �������� ��������� � ���� ������� �� ������������ � ���� ", alwaysRun = true)
	public void testBBR02() throws Exception {
		CommonMethods.correctMailAutorisation(driver);
		driver.get(adress+"pregnancy-and-childbirth-budget/");
		rodu = new ServiceBudjetRodu(driver);
		rodu = rodu.buttonSave();
		  
		  	String summDB = "43450.00";
		String query = "SELECT sum(bp_price*bp_quantity) FROM budget_user_values  "
				+ "INNER JOIN budget_products ON buv_product_id = bp_id WHERE buv_user_id = 172610;";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(bdAdress, username, pass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
				assertEquals(rs.getString(1), summDB); 	
		}	
		con.close();		
} 	*/
	
	@Test(description = "ID = <BM01> ������ �� ������ ", alwaysRun = true)
	public void testBM01()  throws IOException {
		try {
		malush = new ServiceBudjetMalusha(driver);
		malush = malush.clickOnVse().chooseBudjetMalusha().budget();
			CommonMethods.makeScreen(driver, "Services", "������ �� ������");
			CommonMethods.verifyStaticElements(driver);
		WebElement sumItogForm = driver.findElement(By.id("total_year_budget_top"));
		String sumItog = sumItogForm.getText();
		assertEquals(sumItog.toString(), "668,000.00 ���.");
	} catch(Exception e){ 
		e.printStackTrace();
		Assert.fail(); 
	}
	}
	
	/*@Test(description = "ID = <BM02> �������� ��������� � ���� ������� �� ������ ", alwaysRun = true)
	public void testBM02() throws Exception {
			CommonMethods.correctMailAutorisation(driver);
		driver.get(adress+"baby-budget/");
		malush = new ServiceBudjetMalusha(driver);
		malush = malush.buttonSave();
		  	String summDB = "43874.49";
		//TODO 
		  	String query = "SELECT sum(bp_price*bp_quantity) FROM budget_user_values  "
				+ "INNER JOIN budget_products ON buv_product_id = bp_id WHERE buv_user_id = 172610;";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(bdAdress, username, pass);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
				assertEquals(rs.getString(1), summDB); 	
		}	
		con.close();		
}*/

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult, Method method)
			throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String methodName = method.getName();
		String browser = (String)js.executeScript("return navigator.userAgent;");
		String errorName = null;
		if (browser.contains("Firefox_")) {
			errorName = "Firefox_";
		} else if (browser.contains("Chrome/43") && !browser.contains("OPR/")) {
			errorName = "Chrome_";
		} else if (browser.contains("rv:11")) {
			errorName = "IE_";
		} else if (browser.contains("OPR/")) {
			errorName = "Opera_";
		} else if (browser.contains("Safari/534")) {
			errorName = "Safari_";
		}
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenDir + "Errors\\"+ folder +errorName+methodName + ".jpg"));
		}
	
	@AfterClass
	  public void tearDown() {
		  driver.quit(); 
		  }
}

