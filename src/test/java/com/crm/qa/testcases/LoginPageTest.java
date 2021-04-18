package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		assertEquals(title, "Here's the amazing journey that you've had with Flipkart");
	}

	@Test(priority = 2)
	public void flipkartLogoTest() {
		boolean logoImg = loginpage.validateLogo();
		assertTrue(logoImg);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

}
