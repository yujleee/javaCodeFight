package game;

public class GameTest02 {

	public static void drawAll(GameCharacter []a) {
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] instanceof Hobbit) {
				System.out.println("호빗의 객체입니다.");
			} else if (a[i] instanceof Titan) {
				System.out.println("타이탄의 객체입니다.");
			} else {
				System.out.println("주술사의 객체입니다.");
			}
			
			a[i].draw();
			System.out.println(a[i]);
			System.out.println();
		}
	}
	
	//Object 타입의 배열을 매개변수로 가지는 것 불가능.
	//Object 클래스는 나중에 생성된 draw 메소드를 참조할 수 없기 때문. 
	
	
	public static void main(String[] args) {
		//객체 배열 참조변수 생성 
		GameCharacter []g = new GameCharacter[6];
		
		//객체 생성 
		g[0] = new Hobbit("프로도", 5);
		g[1] = new Hobbit("빌보", 8);
		g[2] = new Titan("스마우그", 20);
		g[3] = new Titan("김리", 21);
		g[4] = new Sorcerer("간달프", 40);
		g[5] = new Sorcerer("사우론", 50);
		
		drawAll();
		
	}

}
