package com.blaze.actions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class TextBox extends PageObject {

	WaitPage wait = new WaitPage();

	public WebElement textbox(By locator, String textBoxAction, String value) {
		wait.waitForElementPresent(getDriver(), locator);
		WebElement element = wait.waitForElement(getDriver(), locator, 20);
		if (element == null) {
			element = wait.waitForElement(getDriver(), locator, 100);
		}

		try {
			if (element != null) {
				try {
					if (element.getAttribute("type").compareToIgnoreCase("hidden") == 0) {
						element = null;
					}
				} catch (IllegalStateException e) {
				}
			}
		} catch (NullPointerException e) {
			// Catch any NPE that might be thrown by the getAttribute
		}

		if (textBoxAction.compareToIgnoreCase("exists") != 0) {
			try {
				if (textBoxAction.compareToIgnoreCase("enter") == 0) {
					element.clear();
					element.sendKeys(value);
				} else {
					Assert.fail("TEXTBOX ACTION NOT VALID. TEST Assert.failED.");
				}
			} catch (IllegalStateException e) {
				element.clear();
				element.sendKeys(value);
			} catch (InvalidElementStateException e) {

				element.clear();
				element.sendKeys(value);
			} catch (NoSuchElementException e) {
				Assert.fail(locator + " TEXTBOX NOT FOUND. TEST Assert.failED.");
			} catch (NullPointerException e) {
				Assert.fail(locator + " TEXTBOX NOT FOUND. TEST Assert.failED.");
			}
		}
		return element;
	}

}
