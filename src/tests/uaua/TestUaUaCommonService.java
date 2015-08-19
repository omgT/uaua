package tests.uaua;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import info.uaua.FormIdRdSearchForm;
import info.uaua.ServiceCentrDetskogoRazvitija;
import info.uaua.ServiceDanceSchools;
import info.uaua.ServiceDetskiePolikliniki;
import info.uaua.ServiceDetskieSadu;
import info.uaua.ServiceDomaTvorchestva;
import info.uaua.ServiceKyrsuDljaBeremenuh;
import info.uaua.ServiceMusicSchools;
import info.uaua.ServiceOtduhZdorovje;
import info.uaua.ServiceRoddoma;
import info.uaua.ServiceSchools;
import info.uaua.ServiceSportSekcii;
import info.uaua.ServiceUslugi;
import info.uaua.ServiceZhenskieKonsultasii;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;*/
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import data.CommonMethods;
import data.PropertiesDB;
public class TestUaUaCommonService implements PropertiesDB {
	ServiceDetskiePolikliniki service;
	FormIdRdSearchForm form;
	BrowserVersion browser;
	WebDriver driver;
	ServiceDetskieSadu serviceDS;
	ServiceDomaTvorchestva servicesDS;
	ServiceDomaTvorchestva serviceDT;
	ServiceZhenskieKonsultasii serviceZhK;
	ServiceKyrsuDljaBeremenuh serviceKdB;
	ServiceMusicSchools serviceMS;
	ServiceOtduhZdorovje serviceOZ;
	ServiceSportSekcii serviceSS;
	ServiceUslugi serviceU;
	ServiceCentrDetskogoRazvitija  serviceCDR;
	ServiceSchools serviceSch;
	ServiceDanceSchools serviceDSch;
	ServiceRoddoma serviceRod;
	
	String folder = "CommonServices\\";
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
				System.out.println("TestDetskoePitanie BeforeSuite 1 ");
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		//driver.manage().window().setPosition(new Point(-3000, 0));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		//System.out.println("TestDetskoePitanie BeforeMethod 2");
}
//����� ������ �� ������� � ������ id='rd_search_form'
	
	@Test(description = "ID = <RSD01> '������� ����������' �������� ������ '�������'  �� ���������� ������������� � ���-�� ���������", alwaysRun = true)
	public void testRSD01() {
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		service = new ServiceDetskiePolikliniki(driver);
		Select make = new Select(driver.findElement(By.xpath(".//*[@id='rg_id']"))); 
		assertFalse(make.isMultiple()); 			
		assertEquals(11, make.getOptions().size()); 
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
		System.out.println("CommonServices Test 3");
	}
	
	@Test(description = "ID = <RSD02> '������� ����������' �������� ������ '�����'  �� ���������� ������������� � ���-�� ���������", alwaysRun = true)
	public void testRSD02() {
		try {
			driver.get("http://baby-hospitals.uaua.info/");
			Select region = new Select(driver.findElement(By.id("rg_id")));
			region.selectByVisibleText("����� �������");
			Select city = new Select(driver.findElement(By.id("c_id")));		
			assertEquals(613, city.getOptions().size()); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
		System.out.println("CommonServices Test 4");
	}	
	
	@Test(description = "ID = <RSD03> '������� ����������' ����� �� ����������  ������� ������� � ����� > �����", alwaysRun = true  )
	public void testRSD03() {
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		form = new FormIdRdSearchForm(driver);
		Select region = new Select(driver.findElement(By.xpath(".//*[@id='rg_id']")));
		region.selectByVisibleText("�����������");
		Select city = new Select(driver.findElement(By.xpath(".//*[@id='c_id']")));
		city.selectByVisibleText("�������");
		form.clickOnNaitiObject();
		WebElement cityFinded  = driver.findElement(By.xpath(".//*[@id='ul_search_result']/tbody/tr[2]/td[2]")); //TODO
		String cityInTable = cityFinded.getText();
		Assert.assertTrue(cityInTable.contains("�������"));
		form.findColumnsOfTable();
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <RSD04> '������� ����������' �������� �� ������", alwaysRun = true)
	public void testRSD04() throws IOException {
		
		driver.get("http://baby-hospitals.uaua.info/");
		form = new FormIdRdSearchForm(driver);
			form.clickOnInvisible();
			CommonMethods.makeScreen(driver, "CommonServices\\", "Invisible form");
			form.clickOnInvisible();
			CommonMethods.makeScreen(driver, "CommonServices\\", "Visible form");	
		
	}
	
	@Test(description = "+ID = <RSD05> '������� ����������' ��������� ������������ ������� ��������� ������-����� ", alwaysRun = true)
	public void testRSD05 () {	
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		form = new FormIdRdSearchForm(driver);
		form = form.clickObjectRight().clickObjectRight();
		CommonMethods.makeScreen(driver, "CommonServices\\", "3rd_page_with_objects");
		CommonMethods.verifyStaticElements(driver);
		form = form.clickObjectLeft().clickObjectLeft();
		CommonMethods.makeScreen(driver, "CommonServices\\", "1st_page_with_objects");
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
		
// ������� ����������� ������ (����� �������)
	@Test(description = "+ID = <TF01> ������� � �����-������ �������� ", alwaysRun = true)
	public void testTF01 () throws IOException {	
		try {
		driver.get("http://kidscenter.uaua.info/");
		driver.findElement(By.xpath("//a[@class='list_next']")).click();
		CommonMethods.makeScreen(driver, "CommonServices\\", "Last_page_of_table");
		CommonMethods.verifyStaticElements(driver);
		driver.findElement(By.xpath("//a[@class='list_prev']")).click();
		CommonMethods.makeScreen(driver, "CommonServices\\", "First_page_of_table");
	} catch(Exception e){ 
		Assert.fail(); 
	}
		
}
		
//������� ����������� � ��������
	@Test(description = "ID = <SDB06> ������� ����� ������� �� '�������' > '������� �����������/��������", alwaysRun = true)
	public void testSDB06 () {
		try{
		driver.get("http://www.uaua.info/");
		service = new ServiceDetskiePolikliniki(driver);
		service.clickOnServices().clickOnDetskieBolnitsuPolikliniki_Services();
		WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
		String messageText = message.getText();
		assertEquals("������� �����������/��������", messageText);
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <SDB07> ������� ����� ����� �� '������� �����������/��������", alwaysRun = true)
	public void testSDB07 () {
		try{	
		driver.get("http://www.uaua.info/");
		service = new ServiceDetskiePolikliniki(driver);
		service = service.clickOnDetskieBolnitsuPolikliniki_Footer();
		WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
		String messageText = message.getText();
		assertEquals("������� �����������/��������", messageText);	
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <SDB01> ������� �� ������ ��/� ����� �����, ���������� �� �������", alwaysRun = true)
	public void testSDB01() {
		driver.get("http://www.uaua.info/");
		service = new ServiceDetskiePolikliniki(driver);
		service.moveToServices().clickOnDetskieBolnitsuPolikliniki_Header(); 
		CommonMethods.verifyStaticElements(driver);
		WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
		String messageText = message.getText();
		assertEquals("������� �����������/��������", messageText);
	}
	
	@Test(description = "ID = <SDB02> �������� ������������ �������� ������� +����� ", alwaysRun = true)
	public void testSDB02() {
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		CommonMethods.makeScreen(driver, "CommonServices\\", "Detckie_bolnitsu_polikliniki");
		service = new ServiceDetskiePolikliniki(driver);
		WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
		String messageText = message.getText();
		assertEquals("������� �����������/��������", messageText);
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <SDB08> ������� �� ������ ��/� ����� '�������' � ������ ��������", alwaysRun = true)
	public void testTF08 () {	
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		form = new FormIdRdSearchForm(driver);
		form = form.clickObjectRight();
		
		service = new ServiceDetskiePolikliniki(driver);
		service = service.clickOnDetskieBolnitsuPolikliniki_Objects();
		
		WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
		CommonMethods.verifyStaticElements(driver);
		String messageText = message.getText();
		assertEquals("������� �����������/��������", messageText);
		} catch(Exception e){ 
			Assert.fail(); 
		}
}
	
	@Test(description = "ID = <SDB09> ������� ������ ����� � �������", alwaysRun = true)
	public void testTF09 () {
		try {
		driver.get("http://baby-hospitals.uaua.info/");
		driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
		driver.findElement(By.xpath("//div[@class='txt_catalog']"));
		driver.findElement(By.xpath(".//*[@id='catalog']"));
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}

//������� ����
	
			@Test(description = "ID = <DS01> ������� ����� ������� �� '�������' > '������� ����", alwaysRun = true)
			public void testDS01 () {
				try {
				driver.get("http://www.uaua.info/");
				serviceDS = new ServiceDetskieSadu(driver);
				serviceDS.clickOnServices().clickOnDetskieSadu_Service();
		
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				CommonMethods.verifyStaticElements(driver);
				String messageText = message.getText();
				assertEquals("������� ����", messageText);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
			@Test(description = "ID = <DS02> ������� ����� ����� �� '������� ����", alwaysRun = true)
			public void testDS02 () {
				try {
				driver.get("http://www.uaua.info/");
				serviceDS = new ServiceDetskieSadu(driver);
				serviceDS = serviceDS.clickOnDetskieSadu_Footer();
				
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				CommonMethods.verifyStaticElements(driver);
				String messageText = message.getText();
				assertEquals("������� ����", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DS03> ������� �� ������ �/� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testDS03() {
				try {
				driver.get("http://www.uaua.info/");
				serviceDS = new ServiceDetskieSadu(driver);
				serviceDS = serviceDS.moveToServices().clickOnDetskieSadu_header();
				
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				CommonMethods.verifyStaticElements(driver);
				String messageText = message.getText();
				assertEquals("������� ����", messageText);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
			@Test(description = "ID = <DS04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testDS04() throws IOException {
			try {
				driver.get("http://detsad.uaua.info/");
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ����", messageText);
				CommonMethods.makeScreen(driver, "CommonServices\\", "Detckie_sadu");
			} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
			@Test(description = "ID = <DS05> ������� �� ������ �/c ����� '�������' � ������ ��������", alwaysRun = true)
			public void testDS05 () {	
			try {
				driver.get("http://antenatal-consult.uaua.info/");	
				serviceDS = new ServiceDetskieSadu(driver);
				serviceDS.clickOnDetskieSadu_Objects();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <DS06> ������� ������ ����� � �������", alwaysRun = true)
			public void testDS06 () {
			try {
				driver.get("http://detsad.uaua.info/");
				driver.findElement(By.id("rd_search_form"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.id("catalog"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
//���� ����������
			
			@Test(description = "ID = <DT01> ������� ����� ������� �� '�������' > '���� ����������", alwaysRun = true)
			public void testDT01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceDT = new ServiceDomaTvorchestva(driver);
				serviceDT.clickOnServices().clickOnDomaTvorchestva_Service();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DS02> ������� ����� ����� �� '���� ����������", alwaysRun = true)
			public void testDT02 () {
				try {
				driver.get("http://www.uaua.info/");
				serviceDT = new ServiceDomaTvorchestva(driver);
				serviceDT.clickOnDomaTvorchestva_Footer();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���� ����������", messageText);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
			@Test(description = "ID = <DS03> ������� �� ������ �/� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testDT03() {
				try {
				driver.get("http://www.uaua.info/");
				serviceDT = new ServiceDomaTvorchestva(driver);
				serviceDT = serviceDT.moveToServices().clickOnDomaTvorchestva_header();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���� ����������", messageText);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
				@Test(description = "ID = <DS04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testDT04() {
				try {
					driver.get("http://house-art.uaua.info/");	
				CommonMethods.makeScreen(driver, "CommonServices\\", "Doma_tvorchestva");
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���� ����������", messageText);
				} catch(Exception e){ 
					Assert.fail(); 
				}
			}
			
			@Test(description = "ID = <DS05> ������� �� ������ ���� ���������� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testDT05 () {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form = form.clickObjectRight();
					
				serviceDT = new ServiceDomaTvorchestva(driver);
				serviceDT = serviceDT.clickOnDomaTvorchestva_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <DS06> ������� ������ ����� � �������", alwaysRun = true)
			public void testDT06 () {
				try {
				driver.get("http://house-art.uaua.info/");
				driver.findElement(By.id("rd_search_form"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.id("catalog"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}	
			
//������ ������� ������������
			
			@Test(description = "ID = <ZhK01> ������� ����� ������� �� '�������' > '������� ������������", alwaysRun = true)
			public void testZhK01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceZhK = new 	ServiceZhenskieKonsultasii(driver);
				serviceZhK.clickOnServices().clickOnZhenskieKonsultasii_Service();
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ������������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <ZhK02> ������� ����� ����� �� '������� ������������", alwaysRun = true)
			public void testZhK02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceZhK = new ServiceZhenskieKonsultasii(driver);
				serviceZhK = serviceZhK.clickOnZhenskieKonsultasii_Footer();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ������������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <ZhK03> ������� �� ������ ������� ������������ ����� �����, ���������� �� �������", alwaysRun = true)
			public void testZhK03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceZhK = new ServiceZhenskieKonsultasii(driver);
				serviceZhK.moveToServices().clickOnZhenskieKonsultasii_header();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ������������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <ZhK04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testZhK04() {
			try {
				driver.get("http://antenatal-consult.uaua.info/");	
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Zhenskie_komsultacii");
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ������������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <ZhK05> ������� �� ������ ������� ������������ ����� '�������' � ������ ��������", alwaysRun = true)
			public void testZhK05 () {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				serviceZhK = new ServiceZhenskieKonsultasii(driver);
				serviceZhK = serviceZhK.clickOnZhenskieKonsultasii_Objects();
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������� ������������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <ZhK06> ������� ������ ����� � �������", alwaysRun = true)
			public void testZhK06 () {	
			try{
				driver.get("http://antenatal-consult.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
	
//����� ��� ����������	
			
			@Test(description = "ID = <KdB01> ������� ����� ������� �� '�������' > '����� ��� ����������", alwaysRun = true)
			public void testKdB01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceKdB = new ServiceKyrsuDljaBeremenuh(driver);
				serviceKdB.clickOnServices().clickOnKyrsuDljaBeremenuh_Service();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ��� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <KdB02> ������� ����� ����� �� '����� ��� ����������", alwaysRun = true)
			public void testKdB02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceKdB = new ServiceKyrsuDljaBeremenuh(driver);
				serviceKdB = serviceKdB.clickOnKyrsuDljaBeremenuh_Footer();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ��� ����������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <KdB03> ������� �� ������ ����� ��� ���������� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testKdB03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceKdB = new ServiceKyrsuDljaBeremenuh(driver);
				serviceKdB.moveToServices().clickOnKyrsuDljaBeremenuh_header();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ��� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <KdB04> �������� ������������ �������� ������� '����� ��� ����������'  +����� ", alwaysRun = true)
			public void testKdB04() {
			try {
				driver.get("http://antenatal-classes.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Kurs_dlja_Beremenuh");	 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ��� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <KdB05> ������� �� ������ ����� ��� ���������� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testKdB05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				serviceKdB = new ServiceKyrsuDljaBeremenuh(driver);
				serviceKdB = serviceKdB.clickOnKyrsuDljaBeremenuh_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ��� ����������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <KdB06> ������� ������ ����� � �������", alwaysRun = true)
			public void testKdB06 () {	
			try {
				driver.get("http://antenatal-classes.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
//������ ����������� �����
			@Test(description = "ID = <MS01> ������� ����� ������� �� '�������' > '����������� �����", alwaysRun = true)
			public void testMS01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceMS = new ServiceMusicSchools(driver);
				serviceMS.clickOnServices().clickOnMusicSchools_Service();
				
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����������� �����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <MS02> ������� ����� ����� �� '����������� �����", alwaysRun = true)
			public void testMS02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceMS = new ServiceMusicSchools(driver);
				serviceMS = serviceMS.clickOnMusicSchools_Footer();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����������� �����", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <MS03> ������� �� ������ ����������� ����� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testMS03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceMS = new ServiceMusicSchools(driver);
				serviceMS = serviceMS.moveToServices().clickOnMusicSchools_header();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����������� �����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <MS04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testMS04() {
			try {
				driver.get("http://musicschool.uaua.info/");
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����������� �����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <MS05> ������� �� ������ ����������� ����� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testMS05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form = form.clickObjectRight();
				serviceMS = new ServiceMusicSchools(driver);
				serviceMS = serviceMS.clickOnMusicSchools_Objects();
				
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����������� �����", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <MS06> ������� ������ ����� � �������", alwaysRun = true)
			public void testMS06 () {
			try {
				driver.get("http://musicschool.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
//������ ����� � ��������
			@Test(description = "ID = <OZ01> ������� ����� ������� �� '�������' > '����� � ��������", alwaysRun = true)
			public void testOZ01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceOZ = new ServiceOtduhZdorovje(driver);
				serviceOZ = serviceOZ.clickOnServices().clickOnOtduhZdorovje_Service();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� � ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <OZ02> ������� ����� ����� �� '����� � ��������", alwaysRun = true)
			public void testOZ02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceOZ = new ServiceOtduhZdorovje(driver);
				serviceOZ = serviceOZ.clickOnOtduhZdorovje_Footer(); 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� � ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <OZ03> ������� �� ������ ����� � �������� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testOZ03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceOZ = new ServiceOtduhZdorovje(driver);
				serviceOZ = serviceOZ.moveToServices().clickOnOtduhZdorovje_header();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� � ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <OZ04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testOZ04() {
			try {
				driver.get("http://camps.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Otduh_Zdorovje");
				 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� � ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <OZ05> ������� �� ������ ����� � �������� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testOZ05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form = form.clickObjectRight();
				
				serviceOZ = new ServiceOtduhZdorovje(driver);
				serviceOZ = serviceOZ.clickOnOtduhZdorovje_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� � ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <OZ06> ������� ������ ����� � �������", alwaysRun = true)
			public void testOZ06 () {
			try {
				driver.get("http://camps.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}	
//���������� ������
			
			@Test(description = "ID = <SS01> ������� ����� ������� �� '�������' > '���������� ������", alwaysRun = true)
			public void testSS01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceSS = new ServiceSportSekcii(driver);
				serviceSS = serviceSS.clickOnServices().clickOnSportSekcii_Service();
				
				CommonMethods.verifyStaticElements(driver);  
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���������� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <SS02> ������� ����� ����� �� '���������� ������", alwaysRun = true)
			public void testSS02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceSS = new ServiceSportSekcii(driver);
				serviceSS = serviceSS.clickOnSportSekcii_Footer();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���������� ������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <SS03> ������� �� ������ ���������� ������ ����� �����, ���������� �� �������", alwaysRun = true)
			public void testSS03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceSS = new ServiceSportSekcii(driver);
				serviceSS.moveToServices().clickOnSportSekcii_header();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���������� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <SS04> �������� ������������ �������� �������  +����� ", alwaysRun = true)
			public void testSS04() {
			try {
				driver.get("http://sports.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Sport_Sekcii");
				 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���������� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <SS05> ������� �� ������ ���������� ������ ����� '�������' � ������ ��������", alwaysRun = true)
			public void testSS05() {
			try {
				
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form = form.clickObjectRight();
				
				serviceSS = new ServiceSportSekcii(driver);
				serviceSS = serviceSS.clickOnSportSekcii_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("���������� ������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <SS06> ������� ������ ����� � �������", alwaysRun = true)
			public void testSS06 () {	
			try {
				driver.get("http://sports.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
//������
			@Test(description = "ID = <U01> ������� ����� ������� �� '�������' > '������", alwaysRun = true)
			public void testU01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceU = new ServiceUslugi(driver);
				serviceU.clickOnServices().clickOnUslugi_Service();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <U02> ������� ����� ����� �� '������", alwaysRun = true)
			public void testU02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceU = new ServiceUslugi(driver);
				serviceU = serviceU.clickOnUslugi_Footer();
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <U03> ������� �� ������ ������ ����� �����, ���������� �� �������", alwaysRun = true)
			public void testU03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceU = new ServiceUslugi(driver);
				serviceU.moveToServices().clickOnUslugi_header();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <U04> �������� ������������ �������� ������� ������  +����� ", alwaysRun = true)
			public void testU04() {
			try {
				driver.get("http://services.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Uslugi");
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <U05> ������� �� ������ ������ ����� '�������' � ������ ��������", alwaysRun = true)
			public void testU05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form.clickObjectRight().clickObjectRight();
				
				serviceU = new ServiceUslugi(driver);
				serviceU = serviceU.clickOnUslugi_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <U06> ������� ������ ����� � �������", alwaysRun = true)
			public void testU06 () {
			try {
				driver.get("http://services.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}	
			
//������ �������� ��������
			
			@Test(description = "ID = <CDR01> ������� ����� ������� �� '�������' > '������ �������� ��������", alwaysRun = true)
			public void testCDR01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceCDR = new ServiceCentrDetskogoRazvitija(driver);
				serviceCDR = serviceCDR.clickOnServices().clickOnCentrDetskogoRazvitija_Service();
				
				CommonMethods.verifyStaticElements(driver);  
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������ �������� ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <CDR02> ������� ����� ����� �� '������ �������� ��������", alwaysRun = true)
			public void testCDR02 () {
			try {
				
				driver.get("http://www.uaua.info/");
				serviceCDR = new ServiceCentrDetskogoRazvitija(driver);
				serviceCDR = serviceCDR.clickOnCentrDetskogoRazvitija_Footer();
				CommonMethods.verifyStaticElements(driver);  
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������ �������� ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <CDR03> ������� �� ������ ������ �������� �������� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testCDR03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceCDR = new ServiceCentrDetskogoRazvitija(driver);
				serviceCDR.moveToServices().clickOnCentrDetskogoRazvitija_header();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������ �������� ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}

			@Test(description = "ID = <CDR04> �������� ������������ �������� ������� ������ �������� ��������  +����� ", alwaysRun = true)
			public void testCDR04() {
			try {
				driver.get("http://kidscenter.uaua.info//");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Centr_Detskogo_Razvitija");
				 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������ �������� ��������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <CDR05> ������� �� ������ ������ �������� �������� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testCDR05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				serviceCDR = new ServiceCentrDetskogoRazvitija(driver);
				serviceCDR = serviceCDR.clickOnCentrDetskogoRazvitija_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("������ �������� ��������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <CDR06> ������� ������ ����� � �������", alwaysRun = true)
			public void testCDR06 () {	
			try {
				driver.get("http://kidscenter.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
//�����	
			@Test(description = "ID = <Sch01> ������� ����� ������� �� '�������' > '�����", alwaysRun = true)
			public void testSch01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceSch = new ServiceSchools(driver);
				serviceSch.clickOnServices().clickOnSchools_Service();
				
				CommonMethods.verifyStaticElements(driver);  
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Sch02> ������� ����� ����� �� '�����", alwaysRun = true)
			public void testSch02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceSch = new ServiceSchools(driver);
				serviceSch = serviceSch.clickOnSchools_Footer();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�����", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Sch03> ������� �� ������ ����� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testSch03() {
			try {	
				driver.navigate().to("http://www.uaua.info/");
				serviceSch = new ServiceSchools(driver);
				
				serviceSch = serviceSch.moveToServices().clickOnSchools_Service();
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));
				String messageText = message.getText();
				assertEquals("�����", messageText);
			} catch(Exception e){ 
				e.printStackTrace();
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Sch04> �������� ������������ �������� ������� �����  +����� ", alwaysRun = true)
			public void testSch04() {
			try {
				driver.get("http://school.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Schools");
					
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�����", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Sch05> ������� �� ������ ����� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testSch05() {	
			try {	
				driver.get("http://baby-hospitals.uaua.info/");
				serviceSch = new ServiceSchools(driver);
				serviceSch = serviceSch.clickOnSchools_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�����", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <Sch06> ������� ������ ����� � �������", alwaysRun = true)
			public void testSch06 () {
			try {
				driver.get("http://school.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}

			
//�����	������
			
			@Test(description = "ID = <DSch01> ������� ����� ������� �� '�������' > '����� ������ ", alwaysRun = true)
			public void testDSch01 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceDSch = new ServiceDanceSchools(driver);
				serviceDSch.clickOnServices().clickOnDanceSchools_Service();
				
				CommonMethods.verifyStaticElements(driver);  
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DSch02> ������� ����� ����� �� '����� ������ ", alwaysRun = true)
			public void testDSch02 () {
			try {
				driver.get("http://www.uaua.info/");
				serviceDSch = new ServiceDanceSchools(driver);
				serviceDSch = serviceDSch.clickOnDanceSchools_Footer();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DSch03> ������� �� ������ ����� ������ ����� �����, ���������� �� �������", alwaysRun = true)
			public void testDSch03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceDSch = new ServiceDanceSchools(driver);
				serviceDSch = serviceDSch.moveToServices().clickOnDanceSchools_header();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DSch04> �������� ������������ �������� ������� ����� ������  +����� ", alwaysRun = true)
			public void testDSch04() {
			try {
				driver.get("http://dance.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "DanceSchools");
				
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <DSch05> ������� �� ������ ����� ������ ����� '�������' � ������ ��������", alwaysRun = true)
			public void testDSch05() {	
			try {
				
				driver.get("http://baby-hospitals.uaua.info/");
				form = new FormIdRdSearchForm(driver);
				form = form.clickObjectRight();
				
				serviceDSch = new ServiceDanceSchools(driver);
				serviceDSch = serviceDSch.clickOnDanceSchools_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("����� ������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <DSch06> ������� ������ ����� � �������", alwaysRun = true)
			public void testDSch06 () {	
			try {
				driver.get("http://dance.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
//�������
			
			@Test(description = "ID = <Rod01> ������� ����� ������� �� '�������' > '������� ", alwaysRun = true)
			public void testRod01 () {
			try{ 
				driver.get("http://www.uaua.info/");
				serviceRod = new ServiceRoddoma(driver);
				serviceRod.clickOnServices().clickOnRoddoma_Service();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Rod02> ������� ����� ����� �� '������� ", alwaysRun = true)
			public void testRod02 () {
			try{ 
				driver.get("http://www.uaua.info/");
				serviceRod = new ServiceRoddoma(driver).clickOnRoddoma_Footer();
				 
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Rod03> ������� �� ������ ������� ����� �����, ���������� �� �������", alwaysRun = true)
			public void testRod03() {
			try {
				driver.get("http://www.uaua.info/");
				serviceRod = new ServiceRoddoma(driver);
				serviceRod = serviceRod.moveToServices().clickOnRoddoma_header();
				 
				CommonMethods.verifyStaticElements(driver);
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}

			@Test(description = "ID = <Rod04> �������� ������������ �������� ������� �������  +����� ", alwaysRun = true)
			public void testRod04() {
			try {
				driver.get("http://roddom.uaua.info/");
				CommonMethods.makeScreen(driver, "Menu_1to3\\", "Roddoma");
				 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�������", messageText);
			} catch(Exception e){ 
				Assert.fail(); 
			}
			}
			
			@Test(description = "ID = <Rod05> ������� �� ������ ������� ����� '�������' � ������ ��������", alwaysRun = true)
			public void testRod05() {	
			try {
				driver.get("http://baby-hospitals.uaua.info/");
				
				serviceRod = new ServiceRoddoma(driver);
				serviceRod = serviceRod.clickOnRoddoma_Objects();
				
				CommonMethods.verifyStaticElements(driver); 
				WebElement message = driver.findElement(By.cssSelector(".catalog_box_header>h1"));  
				String messageText = message.getText();
				assertEquals("�������", messageText);	
			} catch(Exception e){ 
				Assert.fail(); 
			}
		}
			
			@Test(description = "ID = <Rod06> ������� ������ ����� � �������", alwaysRun = true)
			public void testRod06 () {
			try {
				driver.get("http://roddom.uaua.info/");
				driver.findElement(By.xpath(".//*[@id='rd_search_form']"));
				driver.findElement(By.xpath("//div[@class='txt_catalog']"));
				driver.findElement(By.xpath(".//*[@id='catalog']"));
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
