package game;

public class Titan extends GameCharacter {
	//생성자
	public void draw() {
		System.out.println("타이탄을 그립니다.");
	}
	
	public Titan() {}

	public Titan(String name, int level) {
		super(name, level);
	}

	public void getRing() {
		System.out.println("GameCharacter()의 getRing()");
	}
}
