package com.blaze.actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;

public class DropDownPage extends PageObject {

	WaitPage wait = new WaitPage();

	public Select selectByValue(By locator, String selectAction, String value) {

		Select localeList;

		WebElement element = wait.waitForElement(getDriver(), locator, 20);
		if (element == null) {
			element = wait.waitForElement(getDriver(), locator, 20);
		}

		if (element != null) {
			try {
				if (element.getAttribute("type").compareToIgnoreCase("hidden") == 0) {
					element = null;
				}
			} catch (IllegalStateException e) {
			} catch (NullPointerException e) {
			}

		}

		if (element != null) {
			localeList = new Select(element);
		} else {
			localeList = null;
		}

		if (selectAction.compareToIgnoreCase("exists") != 0) {
			try {
				if (selectAction.compareToIgnoreCase("select") == 0) {
					localeList.selectByValue(value);
				} else {
					Assert.fail(" SELECT ACTION NOT VALID. TEST Assert.failED.");
				}
			} catch (IllegalStateException e) {
				localeList.selectByValue(value);
			} catch (NoSuchElementException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST Assert.failED.");
			} catch (NullPointerException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST Assert.failED.");
			} catch (org.openqa.selenium.WebDriverException e) {
				Assert.fail(locator + "WEB DRIVER EXCEPTION, ACTION Assert.failED. TEST Assert.failED.");
			}
		}
		return localeList;
	}

	public Select selectByVisibleText(By locator, String selectAction, String value) {

		Select localeList;

		WebElement element = wait.waitForElement(getDriver(), locator, 20);
		if (element == null) {
			element = wait.waitForElement(getDriver(), locator, 20);
		}

		if (element != null) {
			try {
				if (element.getAttribute("type").equalsIgnoreCase("hidden")) {
					element = null;
				}
			} catch (IllegalStateException e) {
			} catch (NullPointerException e) {
			}
		}

		if (element != null) {
			try {
				localeList = new Select(element);
			} catch (IllegalStateException e) {
				localeList = new Select(element);
			}
		} else {
			localeList = null;
		}

		if (!selectAction.equalsIgnoreCase("exists")) {

			try {
				if (selectAction.equalsIgnoreCase("select")) {
					localeList.selectByVisibleText(value);
				} else {
					Assert.fail(" SELECT ACTION NOT VALID. TEST Assert.failED.");
				}
			} catch (IllegalStateException e) {
				localeList.selectByVisibleText(value);
			} catch (NoSuchElementException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST Assert.failED.");
			} catch (NullPointerException e) {
				Assert.fail(locator + " LISTBOX NOT FOUND. TEST Assert.failED.");
			} catch (org.openqa.selenium.WebDriverException e) {
				Assert.fail(locator + " ACTION Assert.failED. TEST Assert.failED.");
			}
		}

		return localeList;
	}

}
