package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DataProviderTestPage;
import com.crm.qa.util.TestUtil;

public class DataProviderTest extends TestBase {

	DataProviderTestPage dataprovider;

	public DataProviderTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization_1();
		dataprovider = new DataProviderTestPage();

	}

	@DataProvider
	public Object[][] data() {
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}

	@Test(dataProvider = "data")
	public void submitContctDetails(String id, String subject, String msg, String name, String email, String no) {
		// dataprovider.createContact("asd", 1, "msg", "name", "abc@gmail.com",
		// "1234567899");

		int b = Integer.parseInt(String.valueOf(id).split("\\.")[0]);

		dataprovider.createContact(b, subject, msg, name, email, no);
	}

	@AfterMethod
	public void exit() {
		driver.quit();
	}
}
