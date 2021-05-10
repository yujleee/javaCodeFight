package exam06;

public class Card {
	String suit;
	String number;
	
	public Card(String suit, String number) {
		super();
		this.suit = suit;
		this.number = number;
	}
	
	@Override
	public String toString() {
		//return "Card [suit=" + suit + ", number=" + number + "]";
		return suit + ":" + number;
	}
	
		
}
