package tests.uaua;

import info.uaua.DetskoePitanieObjects;

import java.util.concurrent.TimeUnit;

import data.CommonMethods;
import data.PropertiesDB;
import data.Autorization;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.opera.OperaDriver;*/
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class TestDetskoePitanie extends CommonMethods implements PropertiesDB, Autorization {
	BrowserVersion browser;
	WebDriver driver;
	DetskoePitanieObjects servicePitanie;
	String folder = "������� �������\\";
	
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
			System.out.println("Test DP START ");
			
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
}

	@Test
	public void testDetP013() throws IOException {
		
	}
	
	@Test(description = "ID = <DetP011> �������� �������� �� ������� ������� � uaua + �����", alwaysRun = true)
	public void testDetP011() throws IOException {
		try {
			servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().verifyObjectsOnDetskoePitaniePage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "������� �������� �������� �������");
			
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	}
	
	
	  	@Test(description = "ID = <DetP012> �������� �������� �� ������� ������� ����� ���������� � uau�", alwaysRun = true)
	public void testDetP012() throws IOException {
		try {
			servicePitanie = new  DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Specrasdel().verifyObjectsOnDetskoePitaniePage();
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	}
	  	
		@Test(description = "ID = <DetP021> �������� �������� �� ������� ����� '�������', ��������� �� ��������� ", alwaysRun = true)
		public void testDetP021() throws IOException {
			try {
				servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnReceptu().findTextRecept();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "�������");
				} catch(Exception e){ 
					e.printStackTrace();
				Assert.fail(); 
				}
			}
		
		@Test(description = "ID = <DetP022> �������� �������� �� ������� ����� '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
		public void testDetP022() throws IOException {
			try {
				servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnReceptu_Vse().findTextRecept().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "�������_���������_��������");
			servicePitanie.clickFirstPage();
			CommonMethods.makeScreen(driver, folder, "�������_������_��������");
			} catch(Exception e){ 
				Assert.fail(); 
			}	
		}
	  
	   @Test(description = "ID = <DetP081> �������� �������� �� ������� ���������� ����� '������� ����������', ��������� �� ���������", alwaysRun = true)
	public void testDetP081() throws IOException {
		try {
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieShkolnikov().findTextRecept();
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}
	   
	   @Test(description = "ID = <DetP082> �������� �������� �� ������� ���������� ����� '�������', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP082() throws IOException{
		   try {
			   servicePitanie = new DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieShkolnikov_Vse().findTextRecept().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "������� ����������_���������_��������");
			servicePitanie.clickFirstPage();
			CommonMethods.makeScreen(driver, folder, "������� ����������_������_��������");
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}
	
	@Test(description = "ID = <DetP03> �������� �������� �� ������� ����� '�������', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP03() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPricorm().
				findTextPricorm();
		
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <DetP031> �������� �������� �� ������� ����� '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP032() throws IOException {
		try {
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnPricorm_Vse().findTextPricorm().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "�������_���������_��������");
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "�������_������_��������");
		
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <DetP041> �������� �������� �� ������� ������� ����� '�������..', ��������� �� ��������� + �����", alwaysRun = true)
public void testDetP041() throws IOException {
try {
	servicePitanie = new DetskoePitanieObjects(driver);
	servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieMalushei();
	CommonMethods.verifyStaticElements(driver);
} catch(Exception e){ 
		Assert.fail(); 
	}
}
	
	@Test(description = "ID = <DetP042> �������� �������� �� ������� ������� ����� '�������..', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP042() throws IOException {
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieMalushei_Vse().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "�������_�������_���������_��������");
			servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "�������_�������_������_��������");
		} catch(IOException e){
			Assert.fail(); 
		}	
	}	
	
	@Test(description = "ID = <DetP051> �������� �������� �� ������� ������������ ����� '�������...',  ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP051() throws IOException {
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieDoshkolnikov();
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <DetP052> �������� �������� �� ������� ������������ �����  '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP052() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieDoshkolnikov_Vse().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "�������_������������_���������_��������");		
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "�������_������������_������_��������");
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
	
	@Test(description = "ID = <DetP061> �������� �������� �� ������������ �������� ������� ����� '������������...' '��� ������', ������� �� ��������� + �����", alwaysRun = true)
	public void testDetP061() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia();
		CommonMethods.verifyStaticElements(driver);;
	} catch(Exception e){ 
		Assert.fail(); 
	}		
}
	
		@Test(description = "ID = <DetP062> �������� �������� �� ������������ �������� ������� ����� '������������...', '����' �   ��������� �� ��������� + �����", alwaysRun = true)
	
	public void testDetP062() throws IOException{
		try {	
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia_Vse().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "������������_���������_��������"); 
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "������������_������_��������"); 
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
		
	@Test(description = "ID = <DetP071> �������� �������� �� ������� ���������� ����� '������� ����������...', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP071() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieBeremenuh();
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}		
}
	
	@Test(description = "ID = <DetP072> �������� �������� �� ������� ���������� ����� '������� ����������...', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP072() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
	servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieBeremenuh_Vse().clickLastPage();
	CommonMethods.verifyStaticElements(driver);
	CommonMethods.makeScreen(driver, folder, "������� ����������_���������_��������");
	servicePitanie.clickFirstPage();
	CommonMethods.makeScreen(driver, folder, "������� ����������_������_��������");
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	} 
	
	@Test(description = "ID = <DetP09> �������� �������� �� ��� ����, ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP09() throws IOException{
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "��� ����_���������_��������");
			servicePitanie.clickFirstPage();
		CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "��� ����_������_��������"); 		
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <DetP10> ������� ����� ������������, �������� ��������", alwaysRun = true)
	public void testDetP10() throws IOException{
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().findBlockKonsultacii().findLinkKonsultacii();
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
	
	/*		// ���� �� ������� @Test(description = "ID = <DetP08> �������� �������� �� ���� ����� '����', '����' �  '��� ������', ��������� �� ��������� + �����", alwaysRun = true)
	public void testDetP08() {
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnBlog().clickLastPage().waitForImg();
		servicePitanie.verifyElementsInThems();		
		CommonMethods.makeScreen(driver, folder, "����_���������_��������");
		servicePitanie.clickFirstPage().waitForImg();
		servicePitanie.verifyElementsInThems();	
		CommonMethods.makeScreen(driver, folder, "����_������_��������");	
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}*/
	
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult, Method method) // ������ ����� ���� ����� ������ � ����� � ����� errors
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
