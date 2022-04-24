package com.vtiger.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class Contact_DoNotCall_BoxTest extends BaseClass {
	
	@Test(groups = "Regration")
		public void createContact() throws Exception {
			ContactPage cp=null;
			HomePage hp=null;
			LoginPage lp=null;
			ExcelUtility eu=new ExcelUtility();
			WebDriverUtility wdu=null;
			JavaUtility ju=new JavaUtility();
			CreateNewContactPage cncont=null;
			ContactInformation continfo=null;
			
			//Excel Files
			
			String lastName=eu.getExcelCellData("Organization", 3, 3);
			
			/*Generate Random Number*/
			
			lastName=lastName+"_"+ju.getRandomNumber(1000);

			/* create Contact */
			hp=new HomePage(driver);
			hp.getContactLink().click();
			cp=new ContactPage(driver);
			cp.getCreateContactIcon().click();
			cncont=new CreateNewContactPage(driver);
			cncont.getContactLastTextfield().sendKeys(lastName);
			cncont.getDonotcallbox().click();
				
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
