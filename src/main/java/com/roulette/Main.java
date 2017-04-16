package com.roulette;

import com.roulette.application.RouletteGame;
import com.roulette.exception.PropertiesPlayerNotFoundException;

public class Main {

	public static void main(final String[] args) throws PropertiesPlayerNotFoundException {
		new RouletteGame().run();
	}
}