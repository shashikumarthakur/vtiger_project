package testNgPractice;

import org.testng.annotations.Test;

public class DependsOnTest {
	
	
	/*If 1st Script Fail Then all other Dependent-Methods are Skipped but Not Fail And It Will Be Skipped in Alphbetical Order*/
	
	@Test
	public void createOrganization() throws Exception {
		System.out.println("Login");
		System.out.println("Create Organization");
		System.out.println("Logout");
		throw new Exception();
	} 
	
	@Test(dependsOnMethods = "createOrganization")
	public void createContact() {
		System.out.println("Login");
		System.out.println("Create Contact");
		System.out.println("Logout");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact() {
		System.out.println("Login");
		System.out.println("Modify Contact");
		System.out.println("Logout");
	}
	
	@Test(dependsOnMethods = "modifyContact")
	public void deleteContact() {
		
		System.out.println("Login");
		System.out.println("Delete Contact");
		System.out.println("Logout");
	}
}
