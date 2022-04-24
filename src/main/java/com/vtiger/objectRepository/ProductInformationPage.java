package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	/**
	 * It is Use for Initialize the variables with WebElements
	 * @param driver
	 */
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className  = "lvtHeaderText")
	private WebElement savedTitle;

	public WebElement getSavedTitle() {
		return savedTitle;
	}
}
