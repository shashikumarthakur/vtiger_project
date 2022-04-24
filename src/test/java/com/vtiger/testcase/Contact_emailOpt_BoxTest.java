package com.vtiger.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPopupPage;
import com.vtiger.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.vtiger.GenericUtility.IListenerImplClass.class)
public class Contact_emailOpt_BoxTest extends BaseClass{
	
	@Test(groups = "Regration")
	public  void createContacts() throws Exception {
	
		
	ContactPage cp=null;
	HomePage hp=null;
	LoginPage lp=null;
	WebDriverUtility wdu=new WebDriverUtility();
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	CreateNewContactPage cncont=null;
	ContactInformation continfo=null;
	
	/* Excel Files */
	String industry=eu.getExcelCellData("Organization", 3, 1);
	String lastName=eu.getExcelCellData("Organization", 3, 3);
	String orgName=eu.getExcelCellData("Organization", 3, 0);
	
	/*Generate Random Number*/
	orgName=orgName+"_"+ju.getRandomNumber(1000);
	lastName=lastName+"_"+ju.getRandomNumber(100);
		
	/* Contact Link */
	hp=new HomePage(driver);
	hp.getContactLink().click();
	
	/* Create Contact With Madatory Field */
	hp.getContactLink().click();
	cp=new ContactPage(driver);
	cp.getCreateContactIcon().click();
	cncont=new CreateNewContactPage(driver);
	cncont.getContactLastTextfield().sendKeys(lastName);
	cncont.getEmailoptoutvox().click();
	
		
	/*Contact Record Saved*/
	cncont.save();
	
	/* Validation */
	continfo=new ContactInformation(driver);
	String getval1=continfo.getSavedTitle().getText();
	if(getval1.contains(lastName)) {
		System.out.println("Validationn Pass");
	}
	else
		System.out.println("Validation Fail"); 
	
}

}
