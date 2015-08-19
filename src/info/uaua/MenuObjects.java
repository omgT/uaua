package info.uaua;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.CommonMethods;

public class MenuObjects {
	WebDriver driver;
	By closePopap =  By.xpath(".//div[contains(@class, 'close')]");
	//Beremenost
	By clickPlanirovanie =  By.xpath(".//*[@id='beremennost']//a[.='������������']");
	By clickForum_Beremenost =  By.xpath(".//*[@id='beremennost']//a[.='�����']");
	By clickPoNedeljam =  By.xpath(".//*[@id='beremennost']//a[.='������������ �� �������']");
	By clickPeriodBerem =  By.xpath(".//*[@id='beremennost']//a[.='������ ������������']");
	By clickService_Beremenost =  By.xpath(".//*[@id='beremennost']//a[.='�������']");
	
	//Rodu
	By clickPodgotovka =  By.xpath(".//*[@id='rody']//a[.='����������']");
	By clickForum_Rodu =  By.xpath(".//*[@id='rody']//a[.='�����']");
	By clickPoslerodPeriod =  By.xpath(".//*[@id='rody']//a[.='������������ ������']");
	By clickRojdenie=  By.xpath(".//*[@id='rody']//a[.='��������']");
	By clickService_Rodu =  By.xpath(".//*[@id='rody']//a[.='�������']");
	
	//Grudnichek
	By clickRazvitie =  By.xpath(".//*[@id='grudnichok']//a[.='��������']");
	By clickForum_Grudnichek =  By.xpath(".//*[@id='grudnichok']//a[.='�����']");
	By clickZdorovje =  By.xpath(".//*[@id='grudnichok']//a[.='��������']");
	By clickUhod=  By.xpath(".//*[@id='grudnichok']//a[.='����']");
	By clickService_Grudnichek =  By.xpath(".//*[@id='grudnichok']//a[.='�������']");
	
	//Novorozhdeny
	By clickRazvitie_Novorozhdeny =  By.xpath(".//*[@id='novorozhdeny']//a[.='��������']");
	By clickForum_Novorozhdeny =  By.xpath(".//*[@id='novorozhdeny']//a[.='�����']");
	By clickZdorovje_Novorozhdeny =  By.xpath(".//*[@id='novorozhdeny']//a[.='��������']");
	By clickUhod_Novorozhdeny=  By.xpath(".//*[@id='novorozhdeny']//a[.='����']");
	By clickService_Novorozhdeny =  By.xpath(".//*[@id='novorozhdeny']//a[.='�������']");
	By clickGrudnoeVskarmlivanie =  By.xpath(".//*[@id='novorozhdeny']//a[.='������� �������������']");
	By clickIskustvVskarmlivanie =  By.xpath(".//*[@id='novorozhdeny']//a[.='������������� �������������']");
	
	//Semja
	By clickOtnoshenija =  By.xpath(".//*[@id='semya']//a[.='���������']");
	By clickForum_Semja =  By.xpath(".//*[@id='semya']//a[.='�����']");
	By clickLifeStyle =  By.xpath(".//*[@id='semya']//a[.='Life Style']");
	By clickGoroskop=  By.xpath(".//*[@id='semya']//a[.='�������� ��������']");
	By clickService_Semja =  By.xpath(".//*[@id='semya']//a[.='�������']");
	By clickAfisha =  By.xpath(".//*[@id='semya']//a[.='�����']");
	By clickPuteshestvija =  By.xpath(".//*[@id='semya']//a[.='������������ � ������']");
	By clickZdorovjUhod=  By.xpath(".//*[@id='semya']//a[.='�������� � ����']");
	By clickUspeshnajaMama =  By.xpath(".//*[@id='semya']//a[.='�������� ����']");
	By clickZvezdnue_Roditeli=  By.xpath(".//*[@id='semya']//a[.='�������� ��������']");
	By clickIdei =  By.xpath(".//*[@id='semya']//a[.='���� ��� ����']");
	By clickTV =  By.xpath(".//*[@id='semya']//a[.='��-���']");
	//from 1 to 3
	By clickTvorchestvo_1to3 =  By.xpath(".//*[@id='ot-1-do-3']//a[.='���������� � ��������']");
	By clickForum_1to3 =  By.xpath(".//*[@id='ot-1-do-3']//a[.='�����']");
	By clickZdorovje_1to3=  By.xpath(".//*[@id='ot-1-do-3']//a[.='��������']");
	By clickPsihologija_1to3=  By.xpath(".//*[@id='ot-1-do-3']//a[.='���������� � ����������']");
	By clickService_1to3 =  By.xpath(".//*[@id='ot-1-do-3']//a[.='�������']");
	By clickOftalmologija_1to3 =  By.xpath(".//*[@id='ot-1-do-3']//a[.='������� �������������']");
	
	//from 3 to 6
	By clickTvorchestvo_3to6 =  By.xpath(".//*[@id='ot-3-do-6']//a[.='���������� � ��������']");
	By clickForum_3to6 =  By.xpath(".//*[@id='ot-3-do-6']//a[.='�����']");
	By clickZdorovje_3to6=  By.xpath(".//*[@id='ot-3-do-6']//a[.='��������']");
	By clickPsihologija_3to6=  By.xpath(".//*[@id='ot-3-do-6']//a[.='���������� � ����������']");
	By clickService_3to6 =  By.xpath(".//*[@id='ot-3-do-6']//a[.='�������']");
	By clickOftalmologija_3to6 =  By.xpath(".//*[@id='ot-3-do-6']//a[.='������� �������������']");
	
	//from 6 to 9
	By clickTvorchestvo_6to9 =  By.xpath(".//*[@id='ot-6-do-9']//a[.='���������� � ��������']");
	By clickForum_6to9 =  By.xpath(".//*[@id='ot-6-do-9']//a[.='�����']");
	By clickZdorovje_6to9=  By.xpath(".//*[@id='ot-6-do-9']//a[.='��������']");
	By clickPsihologija_6to9=  By.xpath(".//*[@id='ot-6-do-9']//a[.='����������']");
	By clickService_6to9 =  By.xpath(".//*[@id='ot-6-do-9']//a[.='�������']");
	By clickSchool_6to9 =  By.xpath(".//*[@id='ot-6-do-9']//a[.='�����']");
	By clickOftalmologija_6to9 =  By.xpath(".//*[@id='ot-6-do-9']//a[.='������� �������������']");
	//from 9 to 16
			By clickTvorchestvo_9to16 =  By.xpath(".//*[@id='ot-9-do-16']//a[.='����� � ����������']");
			By clickForum_9to16 =  By.xpath(".//*[@id='ot-9-do-16']//a[.='�����']");
			By clickZdorovje_9to16=  By.xpath(".//*[@id='ot-9-do-16']//a[.='��������']");
			By clickPsihologija_9to16=  By.xpath(".//*[@id='ot-9-do-16']//a[.='����������']");
			By clickService_9to16 =  By.xpath(".//*[@id='ot-9-do-16']//a[.='�������']");
			By clickSchool_9to16 =  By.xpath(".//*[@id='ot-9-do-16']//a[.='�����']");
			By clickOftalmologija_9to16 =  By.xpath(".//*[@id='ot-9-do-16']//a[.='������� �������������']");
			
			public  MenuObjects clickMain(String menuChapter) {
			
			driver.findElement(By.xpath(menuChapter)).click();
			CommonMethods.verifyStaticElements(driver);
			return this;
			}
			
			public  MenuObjects assertMenuHeight() {
			WebElement message = driver.findElement(By.xpath(".//*[@id='main_nav_wrapper_id']/div"));
			assertEquals("height: 130px;", message.getAttribute("style"));
			return this;
			}
			
			//from  9 to 16
			public  MenuObjects clickSchool_9to16() {
				driver.findElement(clickSchool_9to16).click();
			return this;
			}
			public  MenuObjects clickTvorchestvo_9to16() {
				driver.findElement(clickTvorchestvo_9to16).click();
			return this;
			}		
			public  MenuObjects clickForum_9to16() {
				driver.findElement(clickForum_9to16).click();
			return this;
			}
			
			public  MenuObjects clickZdorovje_9to16() {
				driver.findElement(clickZdorovje_9to16).click();
			return this;
			}
			
			public  MenuObjects clickPsihologija_9to16() {
				driver.findElement(clickPsihologija_9to16).click();
			return this;
			}
			
			public  MenuObjects clickService_9to16() {
				driver.findElement(clickService_9to16).click();
			return this;
			}
			public  MenuObjects clickOftalmologija_9to16() {
				driver.findElement(clickOftalmologija_9to16).click();
			return this;
			}
	//from 6 to 9
	public  MenuObjects clickSchool_6to9() {
		driver.findElement(clickSchool_6to9).click();
	return this;
	}
	public  MenuObjects clickTvorchestvo_6to9() {
		driver.findElement(clickTvorchestvo_6to9).click();
	return this;
	}		
	public  MenuObjects clickForum_6to9() {
		driver.findElement(clickForum_6to9).click();
	return this;
	}
	
	public  MenuObjects clickZdorovje_6to9() {
		driver.findElement(clickZdorovje_6to9).click();
	return this;
	}
	
	public  MenuObjects clickPsihologija_6to9() {
		driver.findElement(clickPsihologija_6to9).click();
	return this;
	}
	
	public  MenuObjects clickService_6to9() {
		driver.findElement(clickService_6to9).click();
	return this;
	}
	public  MenuObjects clickOftalmologija_6to9() {
		driver.findElement(clickOftalmologija_6to9).click();
	return this;
	}
	//from 3 to 6
	public  MenuObjects clickTvorchestvo_3to6() {
		driver.findElement(clickTvorchestvo_3to6).click();
	return this;
	}		
	public  MenuObjects clickForum_3to6() {
		driver.findElement(clickForum_3to6).click();
	return this;
	}
	
	public  MenuObjects clickZdorovje_3to6() {
		driver.findElement(clickZdorovje_3to6).click();
	return this;
	}
	
	public  MenuObjects clickPsihologija_3to6() {
		driver.findElement(clickPsihologija_3to6).click();
	return this;
	}
	
	public  MenuObjects clickService_3to6() {
		driver.findElement(clickService_3to6).click();
	return this;
	}
	public  MenuObjects clickOftalmologija_3to6() {
		driver.findElement(clickOftalmologija_3to6).click();
	return this;
	}
	//from 1 to 3
	public  MenuObjects clickTvorchestvo_1to3() {
		driver.findElement(clickTvorchestvo_1to3).click();
	return this;
	}		
	public  MenuObjects clickForum_1to3() {
		driver.findElement(clickForum_1to3).click();
	return this;
	}
	
	public  MenuObjects clickZdorovje_1to3() {
		driver.findElement(clickZdorovje_1to3).click();
	return this;
	}
	
	public  MenuObjects clickPsihologija_1to3() {
		driver.findElement(clickPsihologija_1to3).click();
	return this;
	}
	
	public  MenuObjects clickService_1to3() {
		driver.findElement(clickService_1to3).click();
	return this;
	}
	public  MenuObjects clickOftalmologija_1to3() {
		driver.findElement(clickOftalmologija_1to3).click();
	return this;
	}		
	//Semja
	public  MenuObjects clickZdorovjUhod() {
		driver.findElement(clickZdorovjUhod).click();
	return this;
	}		
	public  MenuObjects clickUspeshnajaMama() {
		driver.findElement(clickUspeshnajaMama).click();
	return this;
	}
	
	public  MenuObjects clickZvezdnue_Roditeli() {
		driver.findElement(clickZvezdnue_Roditeli).click();
	return this;
	}
	
	public  MenuObjects clickIdei() {
		driver.findElement(clickIdei).click();
	return this;
	}
	
	public  MenuObjects clickTV() {
		driver.findElement(clickTV).click();
	return this;
	}
	public  MenuObjects clickOtnoshenija() {
		driver.findElement(clickOtnoshenija).click();
	return this;
	}		
	public  MenuObjects clickForum_Semja() {
		driver.findElement(clickForum_Semja).click();
	return this;
	}
	
	public  MenuObjects clickLifeStyle() {
		driver.findElement(clickLifeStyle).click();
	return this;
	}
	
	public  MenuObjects clickGoroskop() {
		driver.findElement(clickGoroskop).click();
	return this;
	}
	
	public  MenuObjects clickService_Semja() {
		driver.findElement(clickService_Semja).click();
	return this;
	}
	public  MenuObjects clickAfisha() {
		driver.findElement(clickAfisha).click();
	return this;
	}
	
	public  MenuObjects clickPuteshestvija() {
		driver.findElement(clickPuteshestvija).click();
	return this;
	}
	//Novorozhdeny
	public  MenuObjects clickRazvitie_Novorozhdeny() {
		driver.findElement(clickRazvitie_Novorozhdeny).click();
	return this;
	}		
	public  MenuObjects clickForum_Novorozhdeny() {
		driver.findElement(clickForum_Novorozhdeny).click();
	return this;
	}
	
	public  MenuObjects clickZdorovje_Novorozhdeny() {
		driver.findElement(clickZdorovje_Novorozhdeny).click();
	return this;
	}
	
	public  MenuObjects clickUhod_Novorozhdeny() {
		driver.findElement(clickUhod_Novorozhdeny).click();
	return this;
	}
	
	public  MenuObjects clickService_Novorozhdeny() {
		driver.findElement(clickService_Novorozhdeny).click();
	return this;
	}
	public  MenuObjects clickGrudnoeVskarmlivanie() {
		driver.findElement(clickGrudnoeVskarmlivanie).click();
	return this;
	}
	
	public  MenuObjects clickIskustvVskarmlivanie() {
		driver.findElement(clickIskustvVskarmlivanie).click();
	return this;
	}
	//Grudnichek
	public  MenuObjects clickRazvitie() {
		driver.findElement(clickRazvitie).click();
	return this;
	}		
	public  MenuObjects clickForum_Grudnichek() {
		driver.findElement(clickForum_Grudnichek).click();
	return this;
	}
	
	public  MenuObjects clickZdorovje() {
		driver.findElement(clickZdorovje).click();
	return this;
	}
	
	public  MenuObjects clickUhod() {
		driver.findElement(clickUhod).click();
	return this;
	}
	
	public  MenuObjects clickService_Grudnichek() {
		driver.findElement(clickService_Grudnichek).click();
	return this;
	}
	//Rodu
	public  MenuObjects clickPodgotovka() {
		driver.findElement(clickPodgotovka).click();
	return this;
	}		
	public  MenuObjects clickForum_Rodu() {
		driver.findElement(clickForum_Rodu).click();
	return this;
	}
	
	public  MenuObjects clickRojdenie() {
		driver.findElement(clickRojdenie).click();
	return this;
	}
	
	public  MenuObjects clickPoslerodPeriod() {
		driver.findElement(clickPoslerodPeriod).click();
	return this;
	}
	
	public  MenuObjects clickService_Rodu() {
		driver.findElement(clickService_Rodu).click();
	return this;
	}
	
	//Beremenost		
	public  MenuObjects clickPlanirovanie() {
		driver.findElement(clickPlanirovanie).click();
	return this;
	}
	
	public  MenuObjects clickForum_Beremenost() {
		driver.findElement(clickForum_Beremenost).click();
	return this;
	}
	
	public  MenuObjects clickPoNedeljam() {
		driver.findElement(clickPoNedeljam).click();
	return this;
	}
	
	public  MenuObjects clickPeriodBerem() {
		driver.findElement(clickPeriodBerem).click();
	return this;
	}
	
	public  MenuObjects clickService_Beremenost() {
		driver.findElement(clickService_Beremenost).click();
	return this;
	}
	
	
	
	public  MenuObjects closePopap() {
		driver.findElement(closePopap).click();
	return this;
	}

	public MenuObjects(WebDriver driver) {
		this.driver = driver;
	}
}
