import java.util.*;
public class Base {
	private static Rules uno;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			uno = new Rules();
			uno.beginGame();
			uno.gamePlay();

			
			
			//all that's left to work on is the computer's gameplay and the rules, such as checking if the card placed matches the face card
			//and also things like +2, reverse, etc
			//add what color do you want to use w/ wild card
			//add "type valid response" if they type a card number to play that doesnt exist (types 7 but only 6 cards)
	}
}
