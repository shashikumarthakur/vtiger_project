package testNgPractice;

import com.vtiger.GenericUtility.BaseClass;
import com.vtiger.GenericUtility.JavaUtility;
import com.vtiger.GenericUtility.ReportGenerate;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.vtiger.GenericUtility.ReportGenerate.class)
public class ExtentReportGeneration extends BaseClass {

    @Test
    public void createOrg(){
        System.out.println("Organization Created");
    }

    @Test
    public void createLead(){
        System.out.println("Lead Created");
        Assert.fail("Explicitly Failing This Method");
    }

    @Test
    public void createProduct(){
        System.out.println("Product Created");
        throw new SkipException("Explicitly Skipping This Method");
    }

    @Test
    public void createContact(){
        System.out.println("Contact Created");
    }

}
