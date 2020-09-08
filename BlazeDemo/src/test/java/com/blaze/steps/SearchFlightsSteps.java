package com.blaze.steps;

import org.junit.Assert;

import com.blaze.pageobjects.ConfirmationPage;
import com.blaze.pageobjects.FlightsPage;
import com.blaze.pageobjects.HomePage;
import com.blaze.pageobjects.PurchasePage;
import com.blaze.utilities.AppConfigLoader;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class SearchFlightsSteps {

	@Steps
	HomePage home;

	@Steps
	NavigationSteps navigation;

	@Steps
	FlightsPage flights;

	@Steps
	PurchasePage purchase;

	@Steps
	ConfirmationPage confirmation;

	@Step
	public void search_flights() {
		navigation.navigateTo(AppConfigLoader.getInstance().getBaseURL());
		home.search_flights();
	}
	
	@Step
	public void choose_Flight() {
		flights.click_chooseYour_flight();
	}
	
	@Step
	public void make_Payment() {
		purchase.makePayment();
	}
	
	@Step
	public void verify_confirmationid() {
		Assert.assertTrue(confirmation.verify_confirmationid());
	}

}
