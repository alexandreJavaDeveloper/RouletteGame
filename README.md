## RouletteGame

# Technologies used
- Java 8
- Maven

# Description
- Roulette is a popular casino game. The aim of the exercise is to create a simple command line multiplayer version of the game.
- Every 30 seconds the game should choose a random number between 0 and 36 (inclusive) for the ball to land on.
- If the number is 1-36 then any bet on that number wins, and the player wins 36x the bet's amount.
- If the number is even, any bet on EVEN wins, and the player wins 2x the bet's amount.
- If the number is odd, any bet on ODD wins, and the player wins 2x the bet's amount.
- All other bets lose.
- At the end, is displayed a report containing information about players, e.g: Bet, Outcome and Winnings.

# How to execute (running tests)
- git clone https://github.com/alexandreJavaDeveloper/RouletteGame.git
- cd RouletteGame/
- n clean package
