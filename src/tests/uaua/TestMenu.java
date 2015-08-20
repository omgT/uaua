package tests.uaua;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import info.uaua.MenuObjects;
import data.CommonMethods;
import data.PropertiesDB;
import data.Autorization;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;*/
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class TestMenu implements PropertiesDB, Autorization {
	BrowserVersion browser;
	WebDriver driver;
	MenuObjects menu;
	String folder = "Menu\\";
	

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
				System.out.println("Test menu START ");
				
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
}

	@Test(description = "ID = <MP01> ������������ ������������", alwaysRun = true)
	public void testMP01() throws IOException {
		try {
		menu = new MenuObjects(driver);
			CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]");
		menu.clickPlanirovanie();
			CommonMethods.makeScreen(driver, "Menu_Beremenost\\", "Planirovanie");
			CommonMethods.verifyStaticElements(driver);
		String actual = driver.getTitle();
		assertTrue(actual.contains("������������")); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}

	@Test(description = "ID = <MP02> ����� ����� ������������", alwaysRun = true)
	public void testMP02() throws IOException {
		try {
			menu = new MenuObjects(driver);
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]"); 
		menu.clickForum_Beremenost();
		CommonMethods.makeScreen(driver, "Menu_Beremenost\\", "Forum");
		CommonMethods.verifyStaticElements(driver);
		String actual = driver.getTitle();
	assertTrue(actual.contains("������������")); 	
	CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MP03> ������� �� ������������ �� �������", alwaysRun = true)
	public void testMP03() throws IOException {
		try {
		menu = new MenuObjects(driver);
			CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]");
		menu.clickPoNedeljam();
			CommonMethods.makeScreen(driver, "Menu_Beremenost\\", "Po nedeljam");
		CommonMethods.verifyStaticElements(driver);
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������")); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
		
	@Test(description = "ID = <MP04> ������� �� ������ ������������", alwaysRun = true)
	public void testMP04() throws IOException {	
		try {
			menu = new MenuObjects(driver);
	CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]");
		//menu.assertMenuHeight();
		menu.clickPeriodBerem();
	CommonMethods.makeScreen(driver, "Menu_Beremenost\\", "Period Beremenosti");
	CommonMethods.verifyStaticElements(driver);
		String actual = driver.getTitle();
		assertTrue(actual.contains("������")); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	 @Test(description = "ID = <MP05> ������� �� ������� ����� ������������", alwaysRun = true)
	 
	public void testMP05() throws IOException {	
		try {
			menu = new MenuObjects(driver);
	CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]");
		menu.clickService_Beremenost();
	CommonMethods.makeScreen(driver, "Menu_Beremenost\\", "Service");
	CommonMethods.verifyStaticElements(driver);
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������")); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <6to9M01> ������� �� ������� ����� ��6��9", alwaysRun = true)
	public void test6to9M01() throws IOException {	
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("$(window).load(function() throws IOException {$(document.body.lastChild).remove() });");	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver); 
		menu.clickService_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MG01> ������� �� ������� ����� ���������", alwaysRun = true)
	public void testMG01() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
		menu = new MenuObjects(driver);
		menu.clickService_Grudnichek();
	CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MS01> ������� �� ������� ����� �����", alwaysRun = true)
	public void testMS01() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver); 
		menu.clickService_Semja();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
		@Test(description = "ID = <MR01> ������� �� ������� ����� ����", alwaysRun = true)
	public void testMR01() throws IOException {	
		try {
			menu = new MenuObjects(driver);
	CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
		menu.clickService_Rodu();
	CommonMethods.makeScreen(driver, "Menu_Rodu\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������")); 
	CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MN01> ������� �� ������� ����� �������������", alwaysRun = true)
	public void testMN01() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		//menu.assertMenuHeight();
		menu.clickService_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <3to6M01> ������� �� ������� ����� ��3��6", alwaysRun = true)
	public void test3to6M01() throws IOException {	
		try {

		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickService_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M01> ������� �� ������� ����� ��9��16", alwaysRun = true)
	public void test9to16M01() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickService_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <1to3M01> ������� �� ������� ����� ��1��3", alwaysRun = true)
	public void test1to3M01() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver);
		menu.clickService_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "Service");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MR02> ������� �� ����� ����� ����", alwaysRun = true)
	public void testMR02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_Rodu();
	CommonMethods.makeScreen(driver, "Menu_Rodu\\", "Forum_Roddoma");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
			@Test(description = "ID = <MR03> ������� �� ���������� ����� ����", alwaysRun = true)
	public void testMR03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
		menu = new MenuObjects(driver);
		menu.clickPodgotovka();
	CommonMethods.makeScreen(driver, "Menu_Rodu\\", "Podgotovka");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������")); 	
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
			@Test(description = "ID = <MR04> ������� �� ������������ ������ ����� ����", alwaysRun = true)
	public void testMR04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
		menu = new MenuObjects(driver);
		menu.clickPoslerodPeriod();
	CommonMethods.makeScreen(driver, "Menu_Rodu\\", "Poslerodovoi period");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}	
			@Test(description = "ID = <MR05> ������� �� �������� ����� ����", alwaysRun = true)
	public void testMR05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
		menu = new MenuObjects(driver);
		menu.clickRojdenie();
	CommonMethods.makeScreen(driver, "Menu_Rodu\\", "Rodu");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������")); 	
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
			@Test(description = "ID = <MG0201> ������� �� ����� (��� �����������������) ����� ���������", alwaysRun = true)
			public void testMG0201() throws IOException {	
				try {
				CommonMethods.correctMailAutorisation(driver);
				driver.navigate().refresh();
				CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
				menu = new MenuObjects(driver);
				menu.clickForum_Grudnichek();
			CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Forum_Autoriz");
				String actual = driver.getTitle();
				assertTrue(actual.contains("������"));
				CommonMethods.navigateBack(driver);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
	
			@Test(description = "ID = <MG02> ������� �� ����� ����� ���������", alwaysRun = true)
			public void testMG02() throws IOException {	
				try {
				CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
				menu = new MenuObjects(driver);
				menu.clickForum_Grudnichek();
			CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Forum");
				String actual = driver.getTitle();
				assertTrue(actual.contains("������"));
				CommonMethods.verifyStaticElements(driver);
				CommonMethods.navigateBack(driver);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
	

	
	@Test(description = "ID = <MG03> ������� �� �������� ����� ���������", alwaysRun = true)
	public void testMG03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje();
	CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Zdorovje");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M02> ������� �� ����� ����� ��1��3", alwaysRun = true)
	public void test1to3M02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver); 
		menu.clickForum_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "Forum");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������")); 
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M0201> ������� �� ����� (��� �����������������) ����� ��1��3", alwaysRun = true)
	public void test1to3M0201() throws IOException {	
		try {
		CommonMethods.correctMailAutorisation(driver);
		driver.navigate().refresh();
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_1to3();
		CommonMethods.makeScreen(driver, "Menu_1to3\\", "Forum_Autoriz");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������")); 
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M03> ������� �� ���������� � �������� ����� ��1��3", alwaysRun = true)
	public void test1to3M03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver); 
		menu.clickTvorchestvo_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "���������� � ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������"));
		CommonMethods.verifyStaticElements(driver);

		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M04> ������� �� ���������� � ���������� ����� ��1��3", alwaysRun = true)
	public void test1to3M04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver);
		menu.clickPsihologija_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "���������� � ����������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���������� � ����������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M05> ������� �� �������� ����� ��1��3", alwaysRun = true)
	public void test1to3M05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <1to3M06> ������� �� '������� �������������' ����� ��1��3", alwaysRun = true)
	public void test1to3M06() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
		menu = new MenuObjects(driver);
		menu.clickOftalmologija_1to3();
	CommonMethods.makeScreen(driver, "Menu_1to3\\", "������� �������������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������� �������������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	
	@Test(description = "ID = <MG04> ������� �� ���� ������ ����� ���������", alwaysRun = true)
	public void testMG04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
		menu = new MenuObjects(driver);
		menu.clickUhod();
	CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Uhod");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	@Test(description = "ID = <MG05> ������� �� �������� ����� ���������", alwaysRun = true)
	public void testMG05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
		menu = new MenuObjects(driver);
		menu.clickRazvitie();
	CommonMethods.makeScreen(driver, "Menu_Grudnichek\\", "Razvitie");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MN0201> ������� �� ����� (��� �����������������) ����� �������������", alwaysRun = true)
	public void testMN0201() throws IOException {	
		try {
		CommonMethods.correctMailAutorisation(driver);
		driver.navigate().refresh();
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Forum_Autoriz");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������")); 
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MN02> ������� �� ����� ����� �������������", alwaysRun = true)
	public void testMN02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Forum");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������")); 
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	

	
		@Test(description = "ID = <MN03> ������� �� �������� ����� �������������", alwaysRun = true)
	public void testMN03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Zdorovje");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MN04> ������� �� ���� ������ ����� �������������", alwaysRun = true)
	public void testMN04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickUhod_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Uhod");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MN05> ������� �� �������� ����� �������������", alwaysRun = true)
	public void testMN05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickRazvitie_Novorozhdeny();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Razvitie");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MN06> ������� �� ������������� ������������� ����� �������������", alwaysRun = true)
	public void testMN06() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickIskustvVskarmlivanie();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Razvitie");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������������")); 	
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MN07> ������� �� ������� ������������� ����� �������������", alwaysRun = true)
	public void testMN07() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
		menu = new MenuObjects(driver);
		menu.clickGrudnoeVskarmlivanie();
	CommonMethods.makeScreen(driver, "Menu_novorozhdeny\\", "Razvitie");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MS0201> ������� �� ����� (��� �����������������) ����� �����", alwaysRun = true)
		public void testMS0201() throws IOException {	
			try {
			CommonMethods.correctMailAutorisation(driver);
			driver.navigate().refresh();
			CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
			menu = new MenuObjects(driver);
			menu.clickForum_Semja();
			CommonMethods.makeScreen(driver, "Menu_semja\\", "Forum_Autoriz");
			String actual = driver.getTitle();
			assertTrue(actual.contains("�����")); 
			CommonMethods.navigateBack(driver);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
		
		@Test(description = "ID = <MS02> ������� �� ����� ����� �����", alwaysRun = true)
	public void testMS02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		//menu.assertMenuHeight();
		menu.clickForum_Semja();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "Forum");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�����")); 
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	
	
		@Test(description = "ID = <MS03> ������� �� LifeStyle ����� �����", alwaysRun = true)
		public void testMS03() throws IOException {	
			try {
			CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
			menu = new MenuObjects(driver);
			menu.clickLifeStyle();
		CommonMethods.makeScreen(driver, "Menu_semja\\", "LifeStyle");
			
			WebElement title = driver.findElement(By.xpath(".//h1/span"));
			String actual = title.getText();

			assertTrue(actual.contains("LIFE STYLE"));
			CommonMethods.verifyStaticElements(driver);
			} catch(Exception e){ 
				e.printStackTrace();
				Assert.fail(); 
			}
		}
	
		@Test(description = "ID = <MS04> ������� �� �������� �������� ������ ����� �����", alwaysRun = true)
	public void testMS04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickGoroskop();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "�������� ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������� ��������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MS05> ������� �� ����� ����� �����", alwaysRun = true)
	public void testMS05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickAfisha();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "�����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MS06> ������� �� '������������ � ������' ����� �����", alwaysRun = true)
	public void testMS06() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickPuteshestvija();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "������������ � ������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
		@Test(description = "ID = <MS07> ������� �� �������� � ���� ����� �����", alwaysRun = true)
	public void testMS07() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovjUhod();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "�������� � ����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������� � ����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	@Test(description = "ID = <MS08> ������� �� �������� ���� ������ ����� �����", alwaysRun = true)
	public void testMS08() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickUspeshnajaMama();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "�������� ����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������� ����")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MS09> ������� �� '�������� ��������' ����� �����", alwaysRun = true)
	public void testMS09() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickZvezdnue_Roditeli();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "�������� ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�������� ��������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MS010> ������� �� ���� ��� ���� ����� �����", alwaysRun = true)
	public void testMS10() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver); 
		menu.clickIdei();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "���� ��� ����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���� ��� ����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MS011> ������� �� ��-��� ����� �����", alwaysRun = true)
	public void testMS11() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickTV();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "��-���");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MS012> ������� �� ��������� ����� �����", alwaysRun = true)
	public void testMS12() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
		menu = new MenuObjects(driver);
		menu.clickOtnoshenija();
	CommonMethods.makeScreen(driver, "Menu_semja\\", "���������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <3to6M02> ������� �� ����� �����  ��3��6", alwaysRun = true)
	public void test3to6M02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "Forum");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���� ���������")); 
		CommonMethods.verifyStaticElements(driver);
		//CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}
	
		
	@Test(description = "ID = <3to6M0201> ������� �� ����� (��� �����������������) �����  ��3��6", alwaysRun = true)
	public void test3to6M0201() throws IOException {	
		try {
		CommonMethods.correctMailAutorisation(driver);
		driver.navigate().refresh();
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_3to6();
		CommonMethods.makeScreen(driver, "Menu_3to6\\", "Forum_Autoriz");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���� ���������")); 
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <3to6M03> ������� �� ���������� � �������� �����  ��3��6", alwaysRun = true)
	public void test3to6M03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickTvorchestvo_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "���������� � ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <3to6M04> ������� �� ���������� � ���������� �����  ��3��6", alwaysRun = true)
	public void test3to6M04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickPsihologija_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "���������� � ����������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("���������� � ����������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <3to6M05> ������� �� �������� �����  ��3��6", alwaysRun = true)
	public void test3to6M05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}	
	
	
	@Test(description = "ID = <3to6M06> ������� �� '������� �������������' �����  ��3��6", alwaysRun = true)
	public void test3to6M06() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
		menu = new MenuObjects(driver);
		menu.clickOftalmologija_3to6();
	CommonMethods.makeScreen(driver, "Menu_3to6\\", "������� �������������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������� �������������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
		
	@Test(description = "ID = <6to9M0201> ������� �� ����� (��� �����������������) �����  ��6��9", alwaysRun = true)
	public void test6to9M0201() throws IOException {	
		try {
		CommonMethods.correctMailAutorisation(driver);
		driver.navigate().refresh();
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);;
		menu.clickForum_6to9();
		CommonMethods.makeScreen(driver, "Menu_6to9\\", "Forum_Autoriz");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������")); 
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	} 
	
	@Test(description = "ID = <6to9M02> ������� �� ����� �����  ��6��9", alwaysRun = true)
	public void test6to9M02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "Forum");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������")); 
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	}
	

	
	@Test(description = "ID = <6to9M03> ������� �� ���������� � �������� �����  ��6��9", alwaysRun = true)
	public void test6to9M03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickTvorchestvo_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "���������� � ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <6to9M04> ������� �� ����������  �����  ��6��9", alwaysRun = true)
	public void test6to9M04() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickPsihologija_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "����������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <6to9M05> ������� �� �������� �����  ��6��9", alwaysRun = true)
	public void test6to9M05() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <6to9M06> ������� �� '������� �������������' �����  ��6��9", alwaysRun = true)
	public void test6to9M06() throws IOException {	
		try {	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickOftalmologija_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "������� �������������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������� �������������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <6to9M07> ������� �� ����� �����  ��6��9", alwaysRun = true)
	public void test6to9M07() throws IOException {	
		try {	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
		menu = new MenuObjects(driver);
		menu.clickSchool_6to9();
	CommonMethods.makeScreen(driver, "Menu_6to9\\", "�����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M0201> ������� �� ����� (��� �����������������) �����  ��9��16", alwaysRun = true)
	public void test9to16M0201() throws IOException {	
		try {
		CommonMethods.correctMailAutorisation(driver);
		driver.navigate().refresh();
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_9to16();
		CommonMethods.makeScreen(driver, "Menu_9to16\\", "Forum_Autoriz");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������")); 
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M02> ������� �� ����� �����  ��9��16", alwaysRun = true)
	public void test9to16M02() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickForum_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "Forum");
		String actual = driver.getTitle();
		System.out.println(actual);
		assertTrue(actual.contains("����������")); 
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.navigateBack(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	

	
	@Test(description = "ID = <9to16M03> ������� �� ���������� � �������� �����  ��9��16", alwaysRun = true)
	public void test9to16M03() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickTvorchestvo_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "���������� � ��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����� � ����������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M04> ������� �� ����������  �����  ��9��16", alwaysRun = true)
	public void test9to16M04() throws IOException {	
		try {	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickPsihologija_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "����������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("����������")); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M05> ������� �� �������� �����  ��9��16", alwaysRun = true)
	public void test9to16M05() throws IOException {	
		try {	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickZdorovje_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "��������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("��������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M06> ������� �� '������� �������������' �����  ��9��16", alwaysRun = true)
	public void test9to16M06() throws IOException {	
		try {	
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickOftalmologija_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "������� �������������");
		String actual = driver.getTitle();
		assertTrue(actual.contains("������� �������������"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <9to16M07> ������� �� ����� �����  ��9��16", alwaysRun = true)
	public void test9to16M07() throws IOException {	
		try {
		CommonMethods.moveTo(driver, ".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
		menu = new MenuObjects(driver);
		menu.clickSchool_9to16();
	CommonMethods.makeScreen(driver, "Menu_9to16\\", "�����");
		String actual = driver.getTitle();
		assertTrue(actual.contains("�����"));
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <MM01> ������ ���� ������� ������� ����", alwaysRun = true)
	public void testMM01() throws IOException {	
		try {
	 
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-9-do-16' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "ot-9-do-16");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='semya' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "semya");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-6-do-9' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "ot-6-do-9");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-3-do-6' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "ot-3-do-6");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='ot-1-do-3' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "ot-1-do-3");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='grudnichok' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "grudnichok");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='novorozhdeny' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "novorozhdeny");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='rody' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMai\\", "rody");
	menu.clickMain(".//*[@id='main_nav_wrapper_id']//*[@hash ='beremennost' ]");
	CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "MenuMain\\", "beremennost");
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	

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
