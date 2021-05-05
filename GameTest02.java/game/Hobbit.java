package game;

public class Hobbit extends GameCharacter {
		
	//생성자
	public Hobbit() {}

	public Hobbit(String name, int level) {
		super(name, level);
	}

	public void draw() {
		System.out.println("호빗을 그립니다.");
	}
		
	public void getRing() {
		System.out.println("GameCharacter()의 getRing()");
	}
	
}
