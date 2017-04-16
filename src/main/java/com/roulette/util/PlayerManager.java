package com.roulette.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.roulette.exception.PropertiesPlayerNotFoundException;
import com.roulette.model.Player;
import com.roulette.rules.BetPlayerRules;

/**
 * Manage the players since loading a file properties until to update them, following the rules
 * defined by the scope.
 *
 * If needs a rule more specific, see {@link BetPlayerRules}.
 */
public class PlayerManager
{
	private static final String PLAYERS_PROPERTIES = "players.properties";

	private final List<Player> players;

	public PlayerManager() throws PropertiesPlayerNotFoundException {
		this.players = new ArrayList<>();
	}

	/**
	 * Update the winnings of each player.
	 * @param randomBet value of bet by a random value
	 */
	public void updatePlayers(final int randomBet) {
		for (final Player player : this.players) {

			//If the number is 1-36 then any bet on that number wins, and the player wins 36x the bet's amount.
			if (player.getBet().equals(String.valueOf(randomBet)))
				player.addWinnings(36 * player.getValueOfBet());

			//If the number is even, any bet on EVEN wins, and the player wins 2x the bet's amount.
			else if (player.isEvenBet() && randomBet % 2 == 0)
				player.addWinnings(2 * player.getValueOfBet());

			//If the number is odd, any bet on ODD wins, and the player wins 2x the bet's amount.
			else if (player.isOddBet())
				player.addWinnings(2 * player.getValueOfBet());
		}
	}

	/**
	 * Load some attributes of the player model informed by the user, via console output.
	 * @throws PropertiesPlayerNotFoundException
	 */
	public void preparePlayers() throws PropertiesPlayerNotFoundException {
		final List<String> players = this.loadPlayers();

		if (players.isEmpty()) {
			System.out.println("There is no players to load.");
			return;
		}

		Scanner scanner = null;
		String bet;

		for (final String playerName : players) {
			scanner = new Scanner(System.in); // is necessary create for each player to avoid some inconsistencies

			do {
				System.out.println("Player " + playerName + ", enter your bet:");
				bet = scanner.nextLine();
			} while (!BetPlayerRules.isBetValid(bet));

			System.out.println("Now, enter your value of bet:");
			final float valueOfBet = scanner.nextFloat();

			final Player betPlayer = new Player(playerName, bet, valueOfBet);
			this.players.add(betPlayer);
		}

		scanner.close();
	}

	private List<String> loadPlayers() throws PropertiesPlayerNotFoundException {
		final ClassLoader classLoader = this.getClass().getClassLoader();

		final File file = new File(classLoader.getResource(PlayerManager.PLAYERS_PROPERTIES).getFile());

		if (file == null || !file.exists())
			System.out.println("The file not exists. ");

		final List<String> players = new ArrayList<>();

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				players.add(scanner.nextLine());
			}

			scanner.close();

		} catch (final IOException e) {
			e.printStackTrace();
			throw new PropertiesPlayerNotFoundException();
		}

		return players;
	}

	public List<Player> getPlayers() {
		return this.players;
	}
}