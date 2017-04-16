package com.roulette;

import org.junit.Assert;
import org.junit.Test;

import com.roulette.rules.BetPlayerRules;

public class BetPlayerRulesTest {

	@Test
	public void testIsBetValid() {
		String bet = "eVeN";
		Assert.assertTrue(BetPlayerRules.isBetValid(bet));

		bet = "oDd";
		Assert.assertTrue(BetPlayerRules.isBetValid(bet));

		bet = "1";
		Assert.assertTrue(BetPlayerRules.isBetValid(bet));

		bet = "36";
		Assert.assertTrue(BetPlayerRules.isBetValid(bet));

		bet = "15";
		Assert.assertTrue(BetPlayerRules.isBetValid(bet));

		bet = "oDd23443";
		Assert.assertFalse(BetPlayerRules.isBetValid(bet));

		bet = null;
		Assert.assertFalse(BetPlayerRules.isBetValid(bet));

		bet = "0";
		Assert.assertFalse(BetPlayerRules.isBetValid(bet));
	}
}