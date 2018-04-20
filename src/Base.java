import java.util.*;
public class Base {
	private static Rules uno;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			uno = new Rules();
			uno.beginGame();
			uno.gamePlay();

			
			
			//all that's left to work on is the computer's gameplay and the rules, such as checking if the card placed matches the face card
			//and also things like +2,etc
	}
}