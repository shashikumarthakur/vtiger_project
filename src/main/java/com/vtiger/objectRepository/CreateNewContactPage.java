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
public class CreateNewContactPage {
	/**
	 * It is Use for Initialize the variables with WebElements
	 * @param driver
	 */
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="emailoptout")
	private WebElement emailoptoutvox;
	
	@FindBy(name = "donotcall")
	private WebElement donotcallbox;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement contactLastTextfield;
	
	@FindBy(xpath = "//td/img[@title='Select']")
	private WebElement selectOrgIcon;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getEmailoptoutvox() {
		return emailoptoutvox;
	}
	public WebElement getDonotcallbox() {
		return donotcallbox;
	}
	public WebElement getContactLastTextfield() {
		return contactLastTextfield;
	}
	public WebElement getSelectOrgIcon() {
		return selectOrgIcon;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 *  Create Contact Record with Madatory Feilds Only
	 * @param contactName
	 */
	public void createContactRecordWithMandatoryField(String contactName) {
		
		contactLastTextfield.sendKeys(contactName);
		
	}
	/**
	 * This method use for save the record
	 */
	
	public void save() {
		saveButton.click();
	}
}
