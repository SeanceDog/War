import java.util.ArrayList;

public class deck {
	//Probably need a few "decks", 1 for each player, middle deck, and then 2 discard decks
	//When you have a static branch this means it'll be the same for every object 
	//So you can have 3 deck objects, but they all draw from this deck
	//So, maybe not static? 
	public static ArrayList<card> deckOfCards = new ArrayList<card>();
	
	deck() {
		
	}
	public void shuffle() {
		//Implement way to shuffle a deck
		
	}
	public void compare() {
		//Implement way to compare decks
	}
	public void visibility() {
		
	}
	//Probably also need functions related to removing cards?
	
	

}
