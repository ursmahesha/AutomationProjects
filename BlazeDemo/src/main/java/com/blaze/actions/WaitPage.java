package com.blaze.actions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import net.serenitybdd.core.pages.PageObject;

public class WaitPage extends PageObject {

	private final static int PAGE_TIMEOUT_TIME = 60000;
	public final static long ACTION_TIMEOUT_TIME = 60000;
	public static Integer DELAY = 1;

	public WebElement fluentWait(final By locator, int TimeOutSeconds, int pollingSeconds) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(TimeOutSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
	}

	public void WaitUntilelement(By Element) {
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(getDriver(), 20))
				.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public WebElement waitForElement(WebDriver driver, By element, int sec) {
		Wait<WebDriver> wait = new WebDriverWait(driver, DELAY * sec);
		ExpectedCondition<WebElement> condition = new ElementPresent(element);
		try {
			WebElement we = wait.until(condition);
			return we;
		} catch (WebDriverException e) {
			return null;
		}
	}

	public void waitForTextToAppear(String textToAppear, By element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(element, textToAppear));
	}

	public void waitForElementPresent(WebDriver driver, By locator) {
		@SuppressWarnings("unused")
		String documentation = "Waiting upto " + ACTION_TIMEOUT_TIME + "ms for element with locator: \"" + locator
				+ "\" to appear on page.";

		try {
			long timeStamp = System.currentTimeMillis();
			while (driver.findElements(locator).size() == 0
					&& (System.currentTimeMillis() - timeStamp <= ACTION_TIMEOUT_TIME)) {
				Thread.sleep(500);
			}
			if (System.currentTimeMillis() - timeStamp > ACTION_TIMEOUT_TIME) {

				throw new TimeoutException(
						"Waited 10 seconds for " + locator + " but Assert.failed to find its presence.");
			}

		} catch (Exception e) {
			
		}
	}

	public boolean waitForPageToLoad(WebDriver driver) {
		try {
			long start = System.currentTimeMillis();
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			while (System.currentTimeMillis() - start < PAGE_TIMEOUT_TIME) {
				if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equalsIgnoreCase("complete")) {
					return true;
				} else {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception ignore) {
		}
		return false;
	}

	public WebElement waitForElement(By locator) {
		try {
			int count = 1;
			while (getDriver().findElements(locator).size() == 0 && count <= 60) {
				Thread.sleep(1000);
				count++;
			}
			return (getDriver().findElement(locator));
		} catch (NoSuchElementException e) {

			Assert.fail(locator + " NoSuchElementException NOT FOUND. TEST FAILED.");
		} catch (NullPointerException e) {
			Assert.fail(locator + "NullPointerException NOT FOUND. TEST FAILED.");
		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
		}
		return null;
	}

	public WebElement _getElementWithFluentWait(int timeUnit, final WebElement element) throws Exception {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(timeUnit, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
	}

	public WebElement WaitUntilelement(WebElement Element) {
		return (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(Element));
	}

	public void sleepFor(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean waitForElementToBePresent(WebDriver driver, By element, Integer sec) {

		Wait<WebDriver> wait = new WebDriverWait(driver, DELAY * sec);
		ExpectedCondition<WebElement> condition = new ElementPresent(element);
		try {
			@SuppressWarnings("unused")
			WebElement we = wait.until(condition);
			return true;
		} catch (WebDriverException e) {
			return false;
		}

	}

	// To explicitly wait for an element upon timeout seconds
	public void Webdriverwaitforelement(int timeoutInSeconds, By element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitForURLtoChange(String verifyURL, String verifyURL2) {
		try {
			for (int i = 0; i <= 9; i++) {
				sleepFor(5);
				// waitForPageToLoad(LocalDriverManager.getDriver());
				if (getDriver().getCurrentUrl().contains(verifyURL)) {
					break;
				} else if (getDriver().getCurrentUrl().contains(verifyURL2)) {
					break;
				}
			}
		} catch (Exception ignore) {
		}

	}

}

class ElementPresent implements ExpectedCondition<WebElement> {
	private final By locator;

	public ElementPresent(By locator) {
		this.locator = locator;
	}

	public WebElement apply(WebDriver driver) {
		return driver.findElement(locator);
	}
}
