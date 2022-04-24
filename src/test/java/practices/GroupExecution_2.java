package practices;

import org.testng.annotations.Test;

public class GroupExecution_2 {	

	@Test(groups = { "smoke", "integration","regration" })
	  public void test_method1()
	  {
	    System.out.println("M1-Groups");
	  }
	 
	  @Test(groups = {"regration"} )
	  public void test_method2()
	  {
	    System.out.println("M2-Regration");
	  }
	 
	  @Test(groups = {"smoke"})
	  public void test_method3()
	  {
		  System.out.println("M3-Smoke");
	  }
	  
	  @Test(groups = {"integration"})
	  public void test_method4() {
		  
		  System.out.println("M4-Integration");
	  }

}
