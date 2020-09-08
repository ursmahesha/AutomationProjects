package com.blaze.steps;

import org.jbehave.core.annotations.BeforeStory;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * The Class NavigationSteps.
 */
public class NavigationSteps extends ScenarioSteps {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Navigate to application.
	 */
	@Step
	public void navigateTo(String url) {
		getDriver().manage().window().maximize();
		getDriver().get(url);
	}

	@BeforeStory
	public void browserStack_config() {

		// TODO
	}

}