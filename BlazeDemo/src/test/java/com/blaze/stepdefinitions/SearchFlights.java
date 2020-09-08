package com.blaze.stepdefinitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.blaze.steps.SearchFlightsSteps;

import net.thucydides.core.annotations.Steps;

public class SearchFlights {

	@Steps
	SearchFlightsSteps homeSteps;

	@Given("On blazedemo page searh for flights")
	public void serchflights() throws Exception {
		homeSteps.search_flights();

	}

	@When("Have choosen your flight")
	public void chooseflight() throws Exception {
		homeSteps.choose_Flight();
	}
	
	@When("Make payment")
	public void makepayment() throws Exception {
		homeSteps.make_Payment();
	}
	
	@Then("verify confirmation ID")
	public void verify_confirmation() throws Exception {
		homeSteps.verify_confirmationid();
	}

}
