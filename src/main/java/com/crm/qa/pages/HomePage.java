package com.crm.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Ankit')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	WebElement contactUslink;

	@FindBy(xpath = "//div[@class='go_DOp'][2]")
	WebElement moreLink;

	@FindBy(xpath = "//ul[@class='pO9syL']/li")
	List<WebElement> moreOptions;

	public HomePage() {
		PageFactory.initElements(driver, this);
		aBuilder = new Actions(driver);
	}

	public String verifyHomepageTitle() {
		return driver.getTitle();

	}

	public ContactPage clickOnContactsLink() {
		contactUslink.click();
		return new ContactPage();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public List<WebElement> verifyMoreOptions() throws InterruptedException {
		Thread.sleep(6000);
		aBuilder.moveToElement(moreLink).build().perform();
		return moreOptions;
	}
}
