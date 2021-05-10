package exam06;

import java.util.ArrayList;

public class CardGame03 {

	public static void main(String[] args) {
		
		//원페어 기능 player 클래스에 추가 구현 
		CardDeck deck = new CardDeck();
		
		deck.shuffle();
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		for (int i = 0; i < 7; i++) {
			p1.getCard(deck.deal());
			p2.getCard(deck.deal());
		}
		
		p1.showCards();
		p2.showCards();
	
		
		if(p1.isTwoPair() != -1) {
			System.out.println("Player1이 투페어입니다.");
		}else {
			if(p1.isOnePair() != -1)
				System.out.println("Player1이 원페어입니다.");
		}
		
		if(p2.isTwoPair() != -1) {
			System.out.println("Player2가 투페어입니다.");
		}else {
			if(p2.isOnePair() != -1)
				System.out.println("Player2가 원페어입니다.");
		}
		
		int p1_score = p1.isTwoPair() + p1.isOnePair();
		int p2_score = p2.isTwoPair() + p2.isOnePair();
		
		if( p1_score == p2_score  ) {
			System.out.println("비겼습니다.");
		} else if(p1_score > p2_score) {
			System.out.println("Player1이 승리했습니다.");
		} else {
			System.out.println("Player2가 승리했습니다.");
		}
		
