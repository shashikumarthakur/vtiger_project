package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.GenericUtility.WebDriverUtility;

public class HomePage {
	
	WebDriverUtility wdu=null;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//span[@class='userName']/../following-sibling::td[1]/img")
	private WebElement adminMouseOver;

	@FindBy(linkText = "Sign Out")
	private WebElement logout;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath="//a[text()='More']/..")
	private WebElement moreModuleDropDown;
	
	@FindBy(xpath="//a[@class='drop_downnew' and @name='Campaigns']")
	private WebElement campaignLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getAdminMouseOver() {
		return adminMouseOver;
	}
	public WebElement getlogout() {
		return logout;
	}
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebDriverUtility getWdu() {
		return wdu;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreModuleDropDown() {
		return moreModuleDropDown;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public void Logout(WebDriver driver) {
		wdu=new WebDriverUtility();
		wdu.mouseOverOnElemnet(driver, adminMouseOver);
		logout.click();
		
	}
	public void moreOver(WebDriver driver) {
	wdu=new WebDriverUtility();
	WebElement more = moreModuleDropDown;
	wdu.waitForElemnetToBeClickAble(driver, more);
	wdu.mouseOverOnElemnet(driver, more);
	campaignLink.click();
	
	}
}
