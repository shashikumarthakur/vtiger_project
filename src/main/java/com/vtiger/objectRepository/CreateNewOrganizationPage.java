package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	/**
	 * It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public CreateNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input[name='accountname']")
	private WebElement orgNameTextfield;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryfieldDropDown;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrgNameTextfield() {
		return orgNameTextfield;
	}

	public WebElement getIndustryfieldDropDown() {
		return industryfieldDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	/**
	 * 
	 *  Create Organization Record with Madatory Feilds Only
	 * @param orgName
	 */
	
	
	public void createOrgRecordWithMandatoryField(String orgName) {
		orgNameTextfield.sendKeys(orgName);
	}
	
	/**
	 *  This method is usefull to save a records
	 */
}
