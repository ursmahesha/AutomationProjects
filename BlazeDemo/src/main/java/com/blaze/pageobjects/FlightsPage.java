package com.blaze.pageobjects;

import org.openqa.selenium.By;

import com.blaze.actions.ButtonPage;

public class FlightsPage {
	ButtonPage button;
	private final By chooseyourFlight = By.xpath("//input[@value='Choose This Flight']");

	public void click_chooseYour_flight() {
		button.button(chooseyourFlight, "click", 5);
	}

}
