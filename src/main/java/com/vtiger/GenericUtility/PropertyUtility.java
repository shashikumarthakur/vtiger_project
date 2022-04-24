package com.vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Shashi
 *
 */
public class PropertyUtility {

/**
 *  This method is use for getting value of key from property files	
 * @param path
 * @param key
 * @return This Method return Properties File Key-Values
 * @throws Exception
 */
	public String getPropertiesFileData(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./Commons_Files\\\\CredentialInfo.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
}
