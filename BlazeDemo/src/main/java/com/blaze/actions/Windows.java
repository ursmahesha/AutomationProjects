package com.blaze.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class Windows extends PageObject {

	WaitPage wait = new WaitPage();
	VerificationPage verify = new VerificationPage();

	public void AcceptifAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException ignore) {
		} catch (UnhandledAlertException ignore) {
		} catch (WebDriverException ignore) {
		}
	}


	public void navigateTo(String URL) throws Exception {
		getDriver().manage().deleteAllCookies();
		try {
			getDriver().navigate().refresh();
			AcceptifAlertPresent();

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().navigate().to(URL);
		AcceptifAlertPresent();
	}

}
