package game;

public class GameCharacter {

	protected String name;
	protected int level;
	
	//생성자
	public GameCharacter(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public GameCharacter() {}
	

	// setter, getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	//toString
	@Override
	public String toString() {
		return "GameCharacter [name=" + name + ", level=" + level + "]";
	}

	//draw, getLife 메소드 
	public void draw() {
		System.out.println("GameCharacter()의 draw()");
	}
	
	public void getLife() {
		System.out.println("GameCharacter()의 getLIfe()");
	}
	
}
