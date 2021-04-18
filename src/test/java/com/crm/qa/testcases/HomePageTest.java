package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactpage = new ContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void VerifyHomePageTitleTest() {
		String title = homepage.verifyHomepageTitle();
		Assert.assertEquals(title, "Here's the amazing journey that you've had with Flipkart",
				"Home Page Title is not Found");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		boolean flag = homepage.verifyUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyContactsLink() throws InterruptedException {

		contactpage = homepage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void verifyMoreOptions() throws InterruptedException {
		int i = homepage.verifyMoreOptions().size();
		Assert.assertEquals(i, 5);
		for (WebElement w : homepage.verifyMoreOptions()) {
			System.out.println(w.getText());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
