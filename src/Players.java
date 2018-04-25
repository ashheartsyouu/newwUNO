import java.util.*;

public class Players {
	
	private String name;
	public ArrayList<Cards> hand;
	public ArrayList<Players> players = new ArrayList<Players>();
	private Scanner scnr = new Scanner(System.in);
	public String currPlayer;
	
	public Players(String name)
	{
		this.name = name;
		hand = new ArrayList<Cards>();
	}
	
	public Players() {
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * @return the hand
	 */
	public ArrayList<Cards> getHand() {
		return hand;
	}

	/**
	 * @param hand the hand to set
	 */
	public void setHand(ArrayList<Cards> hand) {
		this.hand = hand;
	}

	public void takeCard(Cards aCard)
	{
		hand.add(aCard);
	}
	
	public void printHand()
	{
		System.out.println("-------------------------------------------");
		System.out.println(name + "'s Hand:");
		int i = 1;
		for(Cards aCard: hand)
		{
			System.out.print(i + ": ");
			aCard.printInfo();
			++i;
		}
		System.out.println("-------------------------------------------");
	}

	public void generateHand(PickUpCards deck) {
		for(int i = 0; i < 7; ++i) {
			takeCard(deck.gimmeACard());
		}
	}
	
	public void plusTwo(PickUpCards deck) {
		for(int i = 0; i < 2; ++i) {
			takeCard(deck.gimmeACard());
		}
	}

	
	

}
