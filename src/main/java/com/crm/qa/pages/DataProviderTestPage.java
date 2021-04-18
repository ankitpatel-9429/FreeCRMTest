package com.crm.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DataProviderTestPage extends TestBase {

	@FindBy(id = "edit-please-choose-a-category-that-best-describes-your-reason-for-con")
	WebElement cat;

	@FindBy(xpath = "(//input[@form='coveo-dummy-form'])[2]")
	WebElement subject;

	@FindBy(xpath = "//textarea[@id='edit-message']")
	WebElement message;

	@FindBy(id = "edit-your-name")
	WebElement name;

	@FindBy(id = "edit-email")
	WebElement email;

	@FindBy(id = "edit-phone-number")
	WebElement number;

	@FindBy(xpath = "//div[@id='edit-actions']")
	WebElement submit;

	public DataProviderTestPage() {
		PageFactory.initElements(driver, this);
	}

	public void createContact(int sel_index, String sub, String msg, String fname, String mail, String no) {
		Select select = new Select(cat);
		select.selectByIndex(sel_index);
		subject.sendKeys(sub);
		message.sendKeys(msg);
		name.sendKeys(fname);
		email.sendKeys(mail);
		number.sendKeys(no);
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].click();", submit);
		// submit.click();
	}
}
