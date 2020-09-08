package com.blaze.actions;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class VerificationPage extends PageObject {

	WaitPage wait = new WaitPage();
	Windows window;

	@SuppressWarnings("unused")
	public boolean elementIsClickable(By Locator) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public boolean elementPresent(By webElement) {
		try {
			WebElement element = null;
			try {
				wait.waitForElementPresent(getDriver(), webElement);
				element = getDriver().findElement(webElement);
				wait.waitForElement(getDriver(), webElement, 1);
			} catch (UnhandledAlertException e) {

				window.AcceptifAlertPresent();
				element = getDriver().findElement(webElement);
				wait.waitForElement(getDriver(), webElement, 1);
			}
			if (element.isEnabled()) {

				return true;
			} else {

				return false;
			}
		} catch (NoSuchElementException e) {

			return false;
		}

	}

	public boolean textPresentIn(By locator, String expectedText) {
		wait.waitForElementPresent(getDriver(), locator);
		try {
			if (elementPresent(locator)) {
				String textFound = getDriver().findElement(locator).getText();
				if (textFound.contains(expectedText)) {
					return true;
				}
			}
		} catch (NoSuchElementException e) {
			fail("[ELEMENT SEARCH FAILED] ELEMENT WITH DESCRIPTION " + locator
					+ " NOT FOUND; TEXT CANNOT BE VERIFIED!");
			return false;
		}
		return false;
	}

	public String getText(By locator, int sec) throws Exception {
		// wait.sleepFor(3);
		WebElement we = wait.waitForElement(getDriver(), locator, sec);
		return we.getText();
	}

	public boolean isTextPresentIn(String expectedText, int sec) throws Exception {
		// sleepFor((DELAY * sec) * 1000);
		if (getDriver().getPageSource().contains(expectedText)) {
			return true;
		} else {
			if (getDriver().getTitle().contains(expectedText)) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

	public boolean verifyTextPresentIn(By locator, String expectedText, int sec) throws Exception {
		wait.sleepFor(3);
		WebElement we = wait.waitForElement(getDriver(), locator, sec);
		if (we != null) {
			if (we.getText().contains(expectedText)) {
				return true;
			} else if (we.getText().equalsIgnoreCase(expectedText)) {
				return true;
			} else if (we.getText().replace("\n", "").replace("\r", "")
					.contains(expectedText.replace("\r", "").replace("\n", ""))) {
				return true;
			} else if (getDriver().getPageSource().contains(expectedText)) {
				return true;
			} else if (getDriver().getPageSource().equalsIgnoreCase(expectedText)) {
				return true;
			} else {
				fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText + " NOT FOUND; TEXT CANNOT BE VERIFIED!");
				return false;
			}
		} else if (getDriver().getPageSource().contains(expectedText)) {
			return true;
		} else if (getDriver().getPageSource().equalsIgnoreCase(expectedText)) {
			return true;
		}
		fail("[TEXT SEARCH FAILED] ELEMENT WITH TEXT " + expectedText + " NOT FOUND; TEXT CANNOT BE VERIFIED!");
		return false;
	}

}
