package com.blaze.pageobjects;

import org.openqa.selenium.By;

import com.blaze.actions.ButtonPage;
import com.blaze.actions.DropDownPage;
import com.blaze.actions.TextBox;

public class HomePage {

	ButtonPage button;
	TextBox text;
	DropDownPage dropdown;

	private final By departure_city = By.name("fromPort");
	private final By destination_city = By.name("toPort");
	private final By find_flights = By.xpath("//input[@value='Find Flights']");

	public void search_flights() {
		button.button(departure_city, "click", 5);
		dropdown.selectByValue(departure_city, "select", "Portland");
		button.button(destination_city, "click", 5);
		dropdown.selectByValue(destination_city, "select", "London");
		button.button(find_flights, "click", 5);
	}

}
