package exam06;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public CardDeck() {
		String []suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String []number = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
				"Jack", "Queen", "King", "Ace"};
	
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < number.length; j++) {
				deck.add(new Card(suit[i], number[j]));
			}
		}
	}
	
	// 무작위로 섞어주는 메소드 	shuffle(List<?> list)
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card deal() { //처음 뽑은 카드 목록에서 없앰 
		return deck.remove(0);
	}
	
	
}
