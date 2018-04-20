	import java.util.ArrayList;
	import java.util.Random;
public class PickUpCards {
		private ArrayList<Cards> deck;

		public PickUpCards() {
			deck = new ArrayList<Cards>();
			generateDeck();
		}
		
		public ArrayList<Cards> getDeck(){
			return deck;
		}
		
		public Cards gimmeACard() { //picking up deck
			Random ranGen = new Random();
			
			int position = ranGen.nextInt(deck.size());
			Cards aCard = deck.get(position); //getting the card at a position from a deck and putting it in the deck
			deck.remove(position);
			
			return aCard;
		}
		
		//need to have a loop that goes up to 13 four times
		private void generateDeck() { //private so that the user uses this as an object and not edit this
			
			String[] color = {"Red", "Blue", "Green", "Yellow"};
			String[] cardVal = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Reverse", "Skip", "+2",
					"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Reverse", "Skip", "+2"};
			
			for(int i = 0; i < 4; ++i) {
				Cards wCard =  new Cards("Black", "Wild Color");
				deck.add(wCard);
			};
			
			for(int i=0; i<4;++i) {
				Cards wCard =  new Cards("Black", "+4 & Wild Color");
				deck.add(wCard);
			}
				
			int deckSpot = 0; //this is the counter that increments and counts the number of cards
			for(int i = 0; i < color.length; ++i) {
				for(int j = 0; j < cardVal.length;++j) {
					Cards aCard = new Cards(color[i], cardVal[j]);
					deck.add(aCard);
				}
			}
		}
		
		public void moveDeck(ArrayList<Cards> pd) { //create method to move place cards deck into pick up cards
			while(!pd.isEmpty()) {
				deck.add(pd.remove(0));
			}
		}
		
		
		

	}
	

