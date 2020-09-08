package com.blaze.actions;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class ButtonPage extends PageObject {

	WaitPage wait = new WaitPage();
	VerificationPage verify = new VerificationPage();

	public WebElement button(By locator, String action, int WaitTime) {

		WebElement element = wait.waitForElement(getDriver(), locator, WaitTime);
		wait.waitForElementPresent(getDriver(), locator);
		if (action.compareToIgnoreCase("exists") != 0) {
			try {
				if (action.compareToIgnoreCase("click") == 0) {
					if (verify.elementIsClickable(locator)) {
						element.click();
						//
					} else {

						new Actions(getDriver()).moveToElement(element).build().perform();

						element.click();

					}

				} else {
					fail("BUTTON ACTION NOT VALID. TEST FAILED.");
				}
			} catch (IllegalStateException e) {

				element.click();
			} catch (StaleElementReferenceException e) {

				try {

					wait.fluentWait(locator, 30, 5).click();

				} catch (Exception e1) {
					
				}
			} catch (NoSuchElementException e) {

				fail(locator + " BUTTON NOT FOUND. TEST FAILED.");
			} catch (NullPointerException e) {

				fail(locator + " BUTTON NOT FOUND. TEST FAILED.");
			} catch (WebDriverException e) {
				try {

					new Actions(getDriver()).moveToElement(element).build().perform();

					element.click();

				} catch (Exception e1) {
					JavascriptExecutor executor = (JavascriptExecutor) getDriver();
					executor.executeScript("arguments[0].click();", element);

				}
			} catch (IllegalArgumentException e) {

				fail(locator + " BUTTON NOT FOUND. TEST FAILED.");
			}
		}

		return element;
	}

}
