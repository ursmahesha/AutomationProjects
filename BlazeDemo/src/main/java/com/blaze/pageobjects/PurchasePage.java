package com.blaze.pageobjects;

import org.openqa.selenium.By;

import com.blaze.actions.ButtonPage;
import com.blaze.actions.TextBox;
import com.blaze.utilities.RandomGenerator;

public class PurchasePage {

	TextBox text;
	ButtonPage button;
	private final By firstName = By.id("inputName");
	private final By address = By.id("address");
	private final By city = By.id("city");
	private final By state = By.id("state");
	private final By zipCode = By.id("zipCode");
	private final By creditCardNumber = By.id("creditCardNumber");
	private final By creditCardYear = By.id("creditCardYear");
	private final By nameOnCard = By.id("nameOnCard");
	private final By purchaseFlight = By.xpath("//input[@value='Purchase Flight']");

	public void makePayment() {
		text.textbox(firstName, "enter", RandomGenerator.randomAlphabetic(5));
		text.textbox(address, "enter", "101 channel dr");
		text.textbox(city, "enter", "Port Washington");
		text.textbox(state, "enter", "New York");
		text.textbox(zipCode, "enter", "11050");
		text.textbox(creditCardNumber, "enter", RandomGenerator.randomNumeric(12));
		text.textbox(creditCardYear, "enter", "11");
		text.textbox(nameOnCard, "enter", RandomGenerator.randomAlphabetic(5));
		button.button(purchaseFlight, "click", 10);
	}
}
