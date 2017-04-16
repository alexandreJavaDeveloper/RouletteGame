package com.roulette.application;

import java.util.Random;

import com.roulette.exception.PropertiesPlayerNotFoundException;
import com.roulette.report.RouletteReport;
import com.roulette.util.PlayerManager;

/**
 * Class that run the game and have all control of it.
 */
public class RouletteGame {

	private static final long DELAY_TO_LAND_ON_BALL = 30000;

	private final PlayerManager playerManager;

	private final RouletteReport report;

	// attempt '1' just to test the application faster
	private int attempts = 1;

	public RouletteGame() throws PropertiesPlayerNotFoundException {
		this.playerManager = new PlayerManager();
		this.report = new RouletteReport();
	}

	/**
	 * Run the game.
	 * Starts the list of player, loading a file properties and starts the game.
	 *
	 * @throws PropertiesPlayerNotFoundException
	 */
	public void run() throws PropertiesPlayerNotFoundException {

		this.playerManager.preparePlayers();

		final Random random = new Random();

		while (this.attempts-- > 0) {
			try {
				final int randomValue = random.nextInt(36);

				this.playerManager.updatePlayers(randomValue);

				this.report.print(this.playerManager.getPlayers(), randomValue);

				Thread.sleep(RouletteGame.DELAY_TO_LAND_ON_BALL);

			} catch (final InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}