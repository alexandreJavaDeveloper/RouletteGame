package com.roulette.model;

public class Player {

	private String playerName;

	private String bet;

	private float valueOfBet;

	private float winnings;

	public Player(final String playerName, final String bet, final float valueOfBet) {
		super();
		this.playerName = playerName;
		this.bet = bet;
		this.valueOfBet = valueOfBet;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(final String playerName) {
		this.playerName = playerName;
	}

	public String getBet() {
		return this.bet.toUpperCase();
	}

	public void setBet(final String bet) {
		this.bet = bet;
	}

	public float getValueOfBet() {
		return this.valueOfBet;
	}

	public void setValueOfBet(final float valueOfBet) {
		this.valueOfBet = valueOfBet;
	}

	public float getWinnings() {
		return this.winnings;
	}

	public void addWinnings(final float winnings) {
		this.winnings += winnings;
	}

	public String getOutcome() {
		if (this.winnings > 0)
			return "WIN";

		return "LOSE";
	}

	@Override
	public int hashCode() {
		return this.playerName.hashCode() + this.bet.hashCode() + String.valueOf(this.valueOfBet).hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null)
			return false;

		final Player another = (Player) obj;

		if (this.getPlayerName().equals(another.getPlayerName()) && this.getBet().equals(another.getBet()) &&
				this.getValueOfBet() == another.getValueOfBet())
			return true;

		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public boolean isEvenBet() {
		return this.getBet().toUpperCase().equals("EVEN");
	}

	public boolean isOddBet() {
		return this.getBet().toUpperCase().equals("ODD");
	}
}