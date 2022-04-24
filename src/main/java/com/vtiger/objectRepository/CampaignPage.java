package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Shashi
 *
 */
public class CampaignPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignIcon;
	

	public WebElement getCreateCampaignIcon() {
		return createCampaignIcon;
	}
		
}
