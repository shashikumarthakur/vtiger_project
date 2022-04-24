package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input[name='campaignname']")
	private WebElement campaignNameTextField;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveButton;
	

	public WebElement getSelectProductIcon() {
		return selectProductIcon;
	}

	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectProductIcon;
	
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
}
