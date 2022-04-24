package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements
	 * @param driver
	 */
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input[name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

	/**
	 * Create Product Record with Madatory Feilds Only
	 * @param productName
	 */
	
	public void createProduct(String productName) {
		
		productNameTextField.sendKeys(productName);
	}
	
	/**
	 * This method is usefull to save a records
	 */
	public void save() {
		saveButton.click();
	}
}
