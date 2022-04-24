package com.vtiger.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.GenericUtility.BaseClass;
import com.vtiger.GenericUtility.ExcelUtility;
import com.vtiger.GenericUtility.JavaUtility;
import com.vtiger.GenericUtility.PropertyUtility;
import com.vtiger.GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationPopupPage;
import com.vtiger.objectRepository.OrganizationsPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.ProductPopupPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.vtiger.GenericUtility.IListenerImplClass.class)
public class CreateCampaignByPOMTestNgTest extends BaseClass {

	@Test(groups = "Smoke")
	public void createCampaign() throws Exception {

		HomePage hp = null;
		LoginPage lp = null;
		CampaignPage cp = null;
		ProductPage pp = null;
		ProductPopupPage prodPopup = null;

		ExcelUtility eu = new ExcelUtility();
		// WebDriverUtility wdu=null;
		JavaUtility ju = new JavaUtility();
		CreateNewProductPage cnprod = null;
		ProductInformationPage prodinfo = null;
		CreateNewCampaignPage cncamp = null;
		CampaignInformationPage campinfo = null;

		/* Retrive Excel File Data */
		String product = eu.getExcelCellData("Organization", 2, 4);
		String campaign = eu.getExcelCellData("Organization", 2, 5);

		/* Generate Random data to make a each data unique while saving */
		product = product + "_" + ju.getRandomNumber(1000);
		campaign = campaign + "_" + ju.getRandomNumber(1000);

		/* create Product */
		hp = new HomePage(driver);
		hp.getProductLink().click();
		pp = new ProductPage(driver);
		pp.getCreateProductIcon().click();
		cnprod = new CreateNewProductPage(driver);
		cnprod.getProductNameTextField().sendKeys(product);
		cnprod.save();

		/* Validation */
		prodinfo = new ProductInformationPage(driver);
		String expectedProduct = prodinfo.getSavedTitle().getText();
//		Assert.fail("Error-Due to Fail Method");
		Assert.assertEquals(expectedProduct.contains(product), true);
		

//		if(expected.contains(product)) {
//			System.out.println("Validation Pass: Product");
//		}
//		else
//			System.out.println("Validation Fail: Prouduct"); 

		/* MouseOver in "More" Module to See More Module Options */
		hp.moreOver(driver);

		/* Create Campaign */
		cp = new CampaignPage(driver);
		cp.getCreateCampaignIcon().click();
		cncamp = new CreateNewCampaignPage(driver);
		cncamp.getCampaignNameTextField().sendKeys(campaign);
		/* Select Organization icon */
		cncamp = new CreateNewCampaignPage(driver);
		cncamp.getSelectProductIcon().click();
		String mainID = driver.getWindowHandle();
		wdu.swithToWindow(driver, "Products");

		/* select Organization from Popup Window */
		prodPopup = new ProductPopupPage(driver);
		prodPopup.getSearchField().sendKeys(product);
		prodPopup.getSearchButton().click();
		prodPopup.dynamicXpath(driver, product);

		/* Driver Focus Change to Main Window */
		driver.switchTo().window(mainID);

		/* Contact Record Saved */

		cncamp.getSaveButton().click();

		/* Validation */
		campinfo = new CampaignInformationPage(driver);
		String expectedCampaign = campinfo.getSavedTitle().getText();
		Assert.assertEquals(expectedCampaign.contains(campaign), true);
//		if(expected1.contains(campaign)) {
//			System.out.println("Validation Pass: Campaign");
//		}
//		else {
//			System.out.println("Validation Pass: Campaign");
//		}

	}

}
