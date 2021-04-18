package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[1]")
	WebElement loginid;

	@FindBy(xpath = "(//div[@class='IiD88i _351hSN']/input)[2]")
	WebElement password;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement logBtn;

	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement flipkartLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateLogo() {
		return flipkartLogo.isDisplayed();

	}

	public HomePage login(String un, String pwd) {
		loginid.sendKeys(un);
		password.sendKeys(pwd);
		logBtn.click();

		return new HomePage();

	}
}
