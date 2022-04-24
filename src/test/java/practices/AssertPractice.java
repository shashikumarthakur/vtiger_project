package practices;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	/* Soft Assert */
	
	@Test
	public void softAssertExample() {
		String actual = "TestYantra";
		String expected = "TestYantra";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}
	
	//No Order Method
	@Test
	public void softAssertNoOrderExample() {
		Object[] actual= {"a","b","c"};
		Object[] expected= {"c","b","a"};

		SoftAssert sa = new SoftAssert();
		sa.assertEqualsNoOrder(actual, expected);
		sa.assertAll();
		System.out.println("No Order "+actual);

	}
	


	/* Hard Assert */
	

	@Test
	public void byteVerificationEqual() {
		byte actual = 127;
		byte expected = 127;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void byteVerificationNotEqual() {
		byte actual = 12;
		byte expected = 127;

		Assert.assertNotEquals(actual, expected);
	}

	@Test
	public void objectVerificationNull() {
		byte actual = 12;
		byte expected = 127;
		GoibiboTest goibibots = null;

		Assert.assertNull(goibibots);

	}

	@Test
	public void objectVerificationNotNull() {
		byte actual = 12;
		byte expected = 127;
		GoibiboTest goibibots = new GoibiboTest();
		;

		Assert.assertNotNull(goibibots);

	}

	@Test
	public void assertSameExample() {

		GoibiboTest goibibots = new GoibiboTest();
		;
		GoibiboTest gonotnull = goibibots;

		Assert.assertSame(goibibots, gonotnull);
	}

	@Test
	public void assertFailExample() {

		boolean b = false;
		Assert.assertFalse(b);

	}

	@Test
	public void shortVarification() {
		short actual = 32767;
		short expected = 32767;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void intVarification() {
		int actual = 2147483647;
		int expected = 2147483647;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void longVarification() {
		long actual = 9223372036854775807l;
		long expected = 9223372036854775807l;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void floatVarification() {
		float actual = 2743.54553434f;
		float expected = 2743.54553434f;

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void doubleVarification() {
		double actual = 565465465465463213.3051;
		double expected = 565465465465463213.3051;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void booleanVarification() {
		boolean actual = false;
		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void charVarification() {
		char actual = 'S';
		char expected = 'S';
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void stringVerification() {
		String actual = "shashi";
		String expected = "shashi";

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void objectVerification() {
		Object actual = new GoibiboTest().getClass();
		Object expected = new GoibiboTest().getClass();
		System.out.println(actual);
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void arrayVerification() {
		int[] actual = { 10, 20, 30, 40, 50 };
		int[] expected = { 10, 20, 30, 40, 50 };

		// Assert.assertEquals(actual,expected);

	}

	@Test
	public void listCollectionVerification() {
		List list = new ArrayList();
		list.add("Shashi");
		list.add("Vivek");
		list.add("Saraswat");

		List listt = new LinkedList();
		listt.add("Shashi");
		listt.add("Vivek");
		listt.add("Saraswat");

		Assert.assertEquals(list, listt);

	}

}
