import java.util.*;

public class Rules {
	private ArrayList<Players> players = new ArrayList<Players>();
	private static Scanner scnr = new Scanner(System.in);
	private Players p = new Players();
	private ArrayList<Cards> placecard = new ArrayList<Cards>();
	private PickUpCards deck = new PickUpCards();
	private Cards removedCard;
	private Cards topCard;
	private Computer c = new Computer();
	private int wildCardColor;
	
	
	public Rules() {//constructor, so that players, scnr, etc can be accessable everywhere (it cant if its private)
		players = new ArrayList<Players>();
		scnr = new Scanner(System.in);
		placecard = new ArrayList<Cards>();
		deck = new PickUpCards();
	}
	

	public void addPlayer() { // Method to generate new players and to check if there are more players to be
								// added
		System.out.println("Please enter a name for Player:");
		String name = scnr.next();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		Players Player = new Players(name);
		players.add(Player);

		boolean done = false;

		while (done == false) {
			System.out.println("Do you have players to add? Y or N");
			String response = scnr.next();
			if (response.toUpperCase().equals("Y")) {
				System.out.println("Please enter a name for Player:");
				name = scnr.next();
				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				Players newPlayer = new Players(name);
				players.add(newPlayer);
			} else if (response.toUpperCase().equals("N")) {
				done = true;
				return;
			} else {
				System.out.println("Please type a valid repsonse.");
			}
		}

	}

	public void addComputer() { // Method to generate the computer player.
		String name = "Computer";
		Computer comp = new Computer(name);
		players.add(comp);
	}

	public void printPlayers() {
		int i = 0;
		System.out.println("-------------------------------------------");
		for (Players thePlayer : players) {
			System.out.println("Player " + (i + 1) + " is " + thePlayer.getName());
			i++;
		}
		System.out.println("-------------------------------------------");
	}

	public void beginGame() {
		System.out.println("Welcome to UNO!");
		System.out.println("Would you like to begin? Y or N?");
		String response = scnr.next();
		addComputer();

		if (response.toUpperCase().equals("Y")) {// Starts the set-up for the game
			addPlayer();
			printPlayers();
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
		}
		
		for(Players p: players) {
			p.generateHand();
		}
		

		
		
		System.out.println("-------------------------------------------");
		System.out.print("First Card: ");
		Cards firstcard = deck.gimmeACard();
		firstcard.printInfo();
		placecard.add(firstcard);

	}
	
	public void gamePlay() {
		boolean winnerFound = false;
		while(winnerFound == false) {
			for(Players ap: players) {
				if(deck.getDeck().size() == 0) {
					deck.moveDeck(placecard);
				}
				
				if(ap.getName().equals("Computer")) {
					c.compTurn(getTopCard(), placecard);
					System.out.println("Computer completed it's turn.");
					//need to finish
				}
				else {
					playerTurn(ap);
					}
				if(placecard.get(placecard.size()-1).getCardVal().equals("Skip")) {
					ap = players.get(players.indexOf(ap)+1);
				}
				if(ap.getHand().size() == 0) {
					System.out.println(ap.getName() + "is the winner! Congrats! Thanks for playing!");
					winnerFound = true;
					}

		
				
				}
				}
			}
	
	public void playerTurn(Players curr) {
		System.out.println(curr.getName() + "'s turn. What would you like to do? \n");
		
		topCard();
		curr.printHand();
		printOptions();

		int action = scnr.nextInt();
		boolean repeat = true;
		while(repeat == true) {
			
		switch(action) {
		case 1: 
			curr.printHand();
			System.out.println("What card do you want to use?: ");
			int cardNum = scnr.nextInt()-1;
			
			removedCard = curr.getHand().remove(cardNum);
			
			
			if(checkCard() == false) {
				curr.getHand().add(removedCard);
			}

			System.out.print(curr.getName() + " placed the card: ");
			removedCard.printInfo();
			
	
			if(removedCard.getCardVal().equals("Reverse")) {
				reverse();
			}
			else if(removedCard.getCardVal().equals("Skip")) {
				int next = players.indexOf(curr)+1;
				Players np = players.get(next);
			}
			else if(removedCard.getCardVal().equals("+2")) {
				int next = players.indexOf(curr)+1;
				Players np = players.get(next);
				np.plusTwo();
			}
			
			
			printOptions();
			action = scnr.nextInt();
			repeat = true;
			break;
		case 2:
			curr.printHand();
			System.out.print("\nHere is your card: ");
			Cards newCard = deck.gimmeACard();
			newCard.printInfo();
			curr.takeCard(newCard);
			
			printOptions();
			action = scnr.nextInt();
			
			repeat = true;
			break;
		case 3: 
			if(curr.getHand().size() == 1) {
				System.out.println("UNO!");
			}
			else {
				System.out.print("\nYou do not have one card left. \nAs punishment, here is your card: ");
				Cards pCard = deck.gimmeACard();
				pCard.printInfo();
				curr.takeCard(pCard);
			}
			repeat = false;
			break;
		case 4:
			System.out.println(curr.getName() + "'s turn is over \n");
			repeat = false;
			break;
		default:
			System.out.println("Please pick a valid option");
			printOptions();
			action = scnr.nextInt();
			repeat = true;
			break;
			}
		}
	}
	
	public void printOptions() {
		System.out.println("\nYour options are: \n" + "1: Place card on deck \n" + "2: Pick up card \n" + "3: Call UNO! \n" + "4: Finish turn");
	}
	
	public void topCard() {
		System.out.print("New face card: ");
		if(placecard.size() == 0) {
			placecard.get(placecard.size()).printInfo();
		}

		
		else {
			placecard.get(placecard.size()-1).printInfo();
		}
	}
	
	public void reverse() {
		Collections.reverse(players);
		
	}
	
	public boolean checkCard() {
		if(removedCard.getColor() == placecard.get(placecard.size()-1).getColor()) {
			placecard.add(removedCard);
			topCard();
			return true;	
		}
		else if(removedCard.getCardVal() == placecard.get(placecard.size()-1).getCardVal()) {
			placecard.add(removedCard);
			topCard();
			return true;
			
		}
		else if(removedCard.getColor().equals("Black")) {
			placecard.add(removedCard);
			topCard();
			System.out.println("What color would you like to make the deck?");
			System.out.println("1. Red \n" + "2. Blue \n" + "3. Green \n" + "4. Yellow \n");
			wildCardColor = scnr.nextInt();
			
			
			boolean repeat = true;
			while(repeat == true) {
			
			switch(wildCardColor) {
			case 1:
				removedCard.setColor("Red");
				repeat = false;
				break;
			case 2:
				removedCard.setColor("Blue");
				repeat = false;
				break;
			case 3:
				removedCard.setColor("Green");
				repeat = false;
				break;
			case 4:
				removedCard.setColor("Yellow");
				repeat = false;
				break;
			default:
				System.out.println("Please type in a valid response");
				wildCardColor = scnr.nextInt();
				repeat = true;
				break;
			}
			}
			
			return true;
		}
		else {
			System.out.println("You cannot use this card because either the color or value does not match the face card.");
			return false;
		}
	}
	
	public Cards getTopCard() {
		topCard = placecard.get(placecard.size()-1);
		return topCard;
	}
	

	
}




