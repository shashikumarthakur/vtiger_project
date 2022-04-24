package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(className  = "dvHeaderText")
	private WebElement savedTitle;
	public WebElement getSavedTitle() {
		return savedTitle;
	}

}
