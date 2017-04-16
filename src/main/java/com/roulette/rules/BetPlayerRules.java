package com.roulette.rules;

/**
 * Class that keep all rules necessaries of the bet players.
 */
public class BetPlayerRules {

	/**
	 * Check if the {@value bet} is a valid bet (informed by the user).
	 *
	 * @param bet
	 * @return if the {@value bet} is valid
	 */
	public static boolean isBetValid(final String bet) {
		if (bet == null || bet.isEmpty())
			return false;

		if ("EVEN".equals(bet.toUpperCase()) || "ODD".equals(bet.toUpperCase()))
			return true;

		try {
			if (Integer.valueOf(bet) >= 1 && Integer.valueOf(bet) <= 36)
				return true;
		} catch (final NumberFormatException e) {
			// unchecked exceptions is not recommended, but this is a case to be checked
			// because the variable "bet" could have expected Strings with Integer.
			// And in this case, should return false without error to the user
		}

		return false;
	}
}