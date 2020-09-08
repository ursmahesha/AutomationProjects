package com.blaze.utilities;

import java.util.Random;
import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomGenerator.
 */
public class RandomGenerator {

	/** The rnd. */
	private static Random rnd = new Random();

	/** The Constant ALPHA_NUMERIC_STRING. */
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/** The Constant ALPHA_STRING. */
	private static final String ALPHA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/** The Constant NUMERIC_STRING. */
	private static final String NUMERIC_STRING = "123456789";

	/**
	 * Creates the guid.
	 *
	 * @return the string
	 */
	public static String createGuid() {
		UUID guid = UUID.randomUUID();
		return guid.toString();
	}

	/**
	 * Gets the random number.
	 *
	 * @return the random number
	 */
	public static int getRandomNumber() {
		return 1 + rnd.nextInt(999999);
	}

	/**
	 * First char uppercase.
	 *
	 * @param name the name
	 * @return the string
	 */
	public static String firstCharUppercase(String name) {
		return Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
	}

	/**
	 * Random alpha numeric.
	 *
	 * @param count the count
	 * @return the string
	 */
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	/**
	 * Random alphabetic.
	 *
	 * @param count the count
	 * @return the string
	 */
	public static String randomAlphabetic(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_STRING.length());
			builder.append(ALPHA_STRING.charAt(character));
		}
		return builder.toString();
	}

	/**
	 * Random numeric.
	 *
	 * @param count the count
	 * @return the string
	 */
	public static String randomNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	
	

}
