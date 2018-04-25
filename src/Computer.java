import java.util.*;

public class Computer extends Players {
	
	private Cards removedCard;
	private String[] colors = {"Red", "Blue", "Yellow", "Green"};
	private String pickedColor;
	private Random rand = new Random();

	/**
	 * 
	 */
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public Computer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Cards compTurn(Cards topCard, ArrayList<Cards> placecard, PickUpCards deck, ArrayList<Players> players) {	//Plays the computer's card
		
		boolean validCard = checkHand(topCard);
			if (validCard == true) {
				placecard.add(removedCard);
				if (removedCard.getColor() == "Black") {
					pickedColor = colors[rand.nextInt(4)];
					System.out.println("The new color is: " + pickedColor);
					removedCard.setColor(pickedColor);
					
				if(removedCard.getCardVal().equals("Reverse")) {
						Collections.reverse(players);
					}
			
				else if(removedCard.getCardVal().equals("+2")) {
						Players np = players.get(1);
						np.plusTwo(deck);
					}
				}
					return removedCard;
				}
				return null;
	}
		

	
	public boolean checkHand(Cards topCard) {	//Checks to see if the computer has a card to play
		
		for(int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getColor() == topCard.getColor()) {
				System.out.println("Computer played " + hand.get(i).getColor() + ", " + hand.get(i).getCardVal());
				removedCard = hand.get(i);
				hand.remove(i);
				return true;
			}
			else if (hand.get(i).getCardVal() == topCard.getCardVal()) {
				System.out.println("Computer played " + hand.get(i).getColor() + ", " + hand.get(i).getCardVal());
				removedCard = hand.get(i);
				hand.remove(i);
				return true;
			}
			else if (hand.get(i).getColor() == "Black") {
				System.out.println("Computer played " + hand.get(i).getColor() + ", " + hand.get(i).getCardVal());
				removedCard = hand.get(i);
				hand.remove(i);
				return true;
			}
		}
		System.out.println("The computer does not have a card that matches");
		return false;
	}

}
