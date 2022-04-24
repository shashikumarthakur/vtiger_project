package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public OrganizationInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}	@FindBy(className  = "dvHeaderText")
	private WebElement saveTitle;
	
	public WebElement getSaveTitle() {
		return saveTitle;
	}


}
