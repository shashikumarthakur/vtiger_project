package practices;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserTest {
	
	@Test(retryAnalyzer =com.vtiger.GenericUtility.ReAnalyser.class)
	public void create() {
		System.out.println("Retry");
		Assert.assertEquals(false, true);
	}

}
