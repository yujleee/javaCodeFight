package game;

public class GameTest {

	public static void main(String[] args) {
		GameCharacter g1 = new Hobbit(); //호빗 객체 생성
		GameCharacter g2 = new Titan(); //타이탄 객체 생성
		GameCharacter g3 = new Sorcerer(); //주술사 객체 생성
		
		g1.getLife();
		//g1.getRing();
		/*오류 발생. 부모의 참조변수가 자식클래스의 새로운 메소드를 호출 불가능 */
		
		//Hobbit으로 형변환 
		((Hobbit)g1).getRing();
		
		System.out.println();
		g2.getLife();
		g3.getLife();
		
	}

}
