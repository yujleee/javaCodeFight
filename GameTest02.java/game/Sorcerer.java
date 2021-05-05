package game;

public class Sorcerer extends GameCharacter {
	//생성자
	public Sorcerer() {
	}

	public Sorcerer(String name, int level) {
		super(name, level);
	}
	
	
	public void draw() {
		System.out.println("주술사를 그립니다.");
	}
	

	public void getRing() {
		System.out.println("GameCharacter()의 getRing()");
	}
	
}
