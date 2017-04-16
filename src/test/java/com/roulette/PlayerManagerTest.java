package com.roulette;


import org.junit.Assert;
import org.junit.Test;

import com.roulette.exception.PropertiesPlayerNotFoundException;
import com.roulette.model.Player;
import com.roulette.report.RouletteReport;
import com.roulette.util.PlayerManager;

public class PlayerManagerTest {

	private final PlayerManager playerManager;

	public PlayerManagerTest() throws PropertiesPlayerNotFoundException {
		this.playerManager = new PlayerManager();
	}

	@Test
	public void testResults() throws PropertiesPlayerNotFoundException {
		this.playerManager.getPlayers().add(new Player("Tiki_Money", "2", 1.0F));
		this.playerManager.getPlayers().add(new Player("Barbara", "EVEN", 3.0F));

		final int randomBet = 4;
		this.playerManager.updatePlayers(randomBet);

		Assert.assertFalse(this.playerManager.getPlayers().get(0).isEvenBet());
		Assert.assertFalse(this.playerManager.getPlayers().get(0).isOddBet());
		Assert.assertEquals("LOSE", this.playerManager.getPlayers().get(0).getOutcome());
		Assert.assertEquals(0.0F, this.playerManager.getPlayers().get(0).getWinnings(), 1);

		Assert.assertTrue(this.playerManager.getPlayers().get(1).isEvenBet());
		Assert.assertFalse(this.playerManager.getPlayers().get(1).isOddBet());
		Assert.assertEquals("WIN", this.playerManager.getPlayers().get(1).getOutcome());
		Assert.assertEquals(6.0F, this.playerManager.getPlayers().get(1).getWinnings(), 1);

		final RouletteReport report = new RouletteReport();
		final int randomValue = 4;
		report.print(this.playerManager.getPlayers(), randomValue);
	}
}