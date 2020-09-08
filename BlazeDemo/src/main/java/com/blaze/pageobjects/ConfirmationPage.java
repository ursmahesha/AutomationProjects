package com.blaze.pageobjects;

import org.openqa.selenium.By;

import com.blaze.actions.VerificationPage;

public class ConfirmationPage {

	VerificationPage verfication;
	private final By id = By.xpath("//td[2]");

	public boolean verify_confirmationid() {
		return verfication.elementPresent(id);
	}

}
