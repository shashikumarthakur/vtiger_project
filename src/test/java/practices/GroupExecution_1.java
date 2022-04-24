package practices;

import org.testng.annotations.Test;

public class GroupExecution_1 {
	
	@Test(groups = { "smoke", "integration","regration" })
	  public void createOrganization()
	  {
	    System.out.println("M1-Create_Organization");
	  }
	 
	  @Test(groups = {"regration"} )
	  public void createContact()
	  {
	    System.out.println("M2-Create_Contact");
	  }
	 
	  @Test(groups = {"smoke"})
	  public void createVendor()
	  {
		  System.out.println("M3-CreateVendors");
	  }
	  
	  @Test(groups = {"integration"})
	  public void createInvoice() {
		  
		  System.out.println("M4-Create_Invoice");
	  }

}
