package com.blaze.testsuites;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;

public class Sample extends SerenityStories {


	public Sample() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.serenitybdd.jbehave.SerenityStories#storyPaths()
	 */
	@Override
	public List<String> storyPaths() {
		return Arrays.asList("stories/BlazeDemo.story");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jbehave.core.junit.JUnitStories#run()
	 */
	@Override
	public void run() {
		super.run();
	}
}