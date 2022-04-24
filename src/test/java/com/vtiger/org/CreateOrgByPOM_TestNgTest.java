package com.vtiger.org;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericUtility.BaseClass;
import com.vtiger.GenericUtility.ExcelUtility;
import com.vtiger.GenericUtility.JavaUtility;
import com.vtiger.GenericUtility.PropertyUtility;
import com.vtiger.GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.ContactInformation;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPopupPage;
import com.vtiger.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.vtiger.GenericUtility.IListenerImplClass.class)
public class CreateOrgByPOM_TestNgTest extends BaseClass {
		
	@Test(groups = "Integration")
	public void createOrganization() throws Exception {
			
			ContactPage cp=null;
			OrganizationPopupPage orgpop=null;
			OrganizationsPage op=null;
			ExcelUtility eu=new ExcelUtility();
			WebDriverUtility wdu=null;
			JavaUtility ju=new JavaUtility();
			CreateNewOrganizationPage cnorg=null;
			CreateNewContactPage cncont=null;
			OrganizationInformationPage orginfo=null;
			ContactInformation continfo=null;
			
			/* Excel Files */
			String industry=eu.getExcelCellData("Organization", 3, 1);
			String lastName=eu.getExcelCellData("Organization", 3, 3);
			String orgName=eu.getExcelCellData("Organization", 3, 0);
			
			/*Generate Random Number*/
			orgName=orgName+"_"+ju.getRandomNumber(1000);
			lastName=lastName+"_"+ju.getRandomNumber(1000);
			/* Object Creation */
			cp=new ContactPage(driver);
			hp=new HomePage(driver);
			lp=new LoginPage(driver);
			orgpop=new OrganizationPopupPage(driver);
			op=new OrganizationsPage(driver);
			wdu=new WebDriverUtility();
			cnorg=new CreateNewOrganizationPage(driver);
			cncont=new CreateNewContactPage(driver);
			orginfo=new OrganizationInformationPage(driver);
			continfo=new ContactInformation(driver);
			
			/* Create Organisation */
			hp.getOrgLink().click();
			op.getCreateOrgIcon().click();
			cnorg.createOrgRecordWithMandatoryField(orgName);
			
			WebElement selectIndustry=cnorg.getIndustryfieldDropDown();
			wdu.select(selectIndustry, industry);
			cnorg.getSaveButton().click();
			
			/*Validation*/
			String getval=orginfo.getSaveTitle().getText();
			
			if(getval.contains(orgName)) {
				System.out.println("Validationn Pass");
			}
			else
				System.out.println("Validation Fail"); 
			
			/*Explicitly Wait-Element to be clickable For Contact Module*/
			WebElement contact=hp.getContactLink();
			wdu.waitForElemnetToBeClickAble(driver, contact);
			
			
			/* Create Contact */
			hp.getContactLink().click();
			cp.getCreateContactIcon().click();
			cncont.createContactRecordWithMandatoryField(lastName);
			
			/* Select Organization icon */
			
			cncont.getSelectOrgIcon().click();	
			String mainID=driver.getWindowHandle();
			wdu.swithToWindow(driver, "Accounts");
			
			/* Select Organization from Popup Window */
			orgpop.getSearchTextField().sendKeys(orgName);
			orgpop.getSearchButton().click();
			orgpop.dynamicXpath(driver,orgName);
						
			/*Driver Focus Change to Main Window*/
			driver.switchTo().window(mainID);
			
			/*Contact Record Saved*/
			cncont.save();
			
			/* Validation */
			String getval1=continfo.getSavedTitle().getText();
			
			if(getval1.contains(lastName)) {
				System.out.println("Validationn Pass");
			}
			else
				System.out.println("Validation Fail"); 

		}

	}
