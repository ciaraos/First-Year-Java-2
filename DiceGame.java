import java.util.Scanner;

/* SELF ASSESSMENT 
1. ResolveBet
I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: I believe I done this 
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: my program does this
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: my program does this
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]
Comment: my program does this 
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: I believe my program does this
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: I believe my program does this

2. Main
I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: my program does this
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: I believe my program does this
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: my program prints out all the options 
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: my program calls resolveBet for each 
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: my program says how much the player had at the start and end of the game
 Total Mark out of 100 (Add all the previous marks): 100
*/
public class DiceGame {
	public static void resolveBet(double cashEntered, Wallet wallet) {
		Scanner betScanner = new Scanner(System.in);
		Scanner newScanner = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			System.out.println(wallet.toString());
			System.out.print("Place your bet: triple, field, high, low ");
			String bet = betScanner.nextLine();
			/*
			 * if (betScanner.hasNext("quit")) { finished = true; betScanner.close();
			 * System.out.print("Goodbye"); }
			 */
			System.out.print("How much cash would you like to bet? (or type 'quit')  ");
			if (newScanner.hasNextInt()) {
				double cashBet = newScanner.nextDouble();
				Dice dice1 = new Dice();
				Dice dice2 = new Dice();
				Dice dice3 = new Dice();
				int roll1 = dice1.roll();
				int roll2 = dice2.roll();
				int roll3 = dice3.roll();
				int answer = roll1 + roll2 + roll3;
				if (wallet.get(cashBet) == true) {
					System.out.println("roll 1: " + roll1 + ", roll 2: " + roll2 + ", roll 3: " + roll3
							+ ". These add to " + answer);
					if (win(wallet, cashBet, roll1, roll2, roll3, bet, answer) == true) {
						System.out.println("WINNER");
					} else if (win(wallet, cashBet, roll1, roll2, roll3, bet, answer) == false) {
						System.out.println("LOSER");
					}
				} else if (wallet.get(cashBet) == false) {
					System.out.println("Sorry, there is not enough cash in your wallet ");
					// finished = true;
				} else if (wallet.check() == 0) {
					finished = true;
					betScanner.close();
					System.out.print("Sorry, you have no more cash in your wallet ");
				}
			} else if (newScanner.hasNext("quit")) {
				finished = true;
				betScanner.close();
				//System.out.print("Goodbye");
			}
		}

	}

	public static boolean win(Wallet wallet, double cashBet, int roll1, int roll2, int roll3, String bet, int answer) {
		boolean win = false;
		// triple
		if (roll1 == roll2 && roll1 == roll3 && roll2 == roll3) {
			System.out.println("triple");
			if (roll1 == 1 || roll1 == 6) {
				win = false;
				cashBet *= -30;
				wallet.put(cashBet);
			} else if (bet.equals("triple")) {
				win = true;
				cashBet *= 30;
				wallet.put(cashBet);
			}
		}
		// field
		if ((answer < 8) || (answer > 12)) {
			System.out.println("field");
			if (bet.equals("field")) {
				win = true;
				cashBet += cashBet;
				wallet.put(cashBet);
			} else 
				//if (bet.equals("field") && answer > 8 || answer < 12) 
				{
				win = false;
				cashBet -= cashBet;
				wallet.put(cashBet);
			}
		}
		// high
		if ((answer > 10)) {
			System.out.println("high");
			if (bet.equals("high")) {
				win = true;
				cashBet += cashBet;
				wallet.put(cashBet);
			} else if ((roll1 == 4 && roll2 == 4 && roll3 == 4) || (roll1 == 5 && roll2 == 5 && roll3 == 5)
					|| (roll1 == 6 && roll2 == 6 && roll3 == 6)) {
				win = false;
				cashBet -= cashBet;
				wallet.put(cashBet);
			}
		}
		// low
		if ((answer < 11)) {
			System.out.println("low");
			if (bet.equals("low")) {
				win = true;
				cashBet += cashBet;
				wallet.put(cashBet);
			} else if ((roll1 == 1 && roll2 == 1 && roll3 == 1) || (roll1 == 2 && roll2 == 2 && roll3 == 2)
					|| (roll1 == 3 && roll2 == 3 && roll3 == 3)) {
				win = false;
				cashBet -= cashBet;
				wallet.put(cashBet);
			}
		}
		return win;
	}

	public static void main(String[] args) {
		System.out.print("How much cash would you like to add to your wallet? ");
		Wallet wallet = new Wallet();
		Scanner inputScanner = new Scanner(System.in);
		double cashEntered = inputScanner.nextDouble();
		wallet.put(cashEntered);
		boolean finished = false;
		while (!finished) {
			// if (inputScanner.hasNextInt()) {
			resolveBet(cashEntered, wallet);
			// }

			if (inputScanner.hasNext("quit")) {
				finished = true;
				inputScanner.close();
			}
		}
		System.out.print("You had €" + cashEntered + " at the start and finished with " + wallet.toString());
	}
}
