package practices;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class TestNgXMLDataDriven {
	
	@Test
	public void fetchData(XmlTest xml) {
		
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
	}
	
}

