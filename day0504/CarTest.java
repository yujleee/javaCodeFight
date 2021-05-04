package teamVehicle;

public class CarTest {

	public static void main(String[] args) {
	//	Vehicle v = new  Vehicle(); 추상클래스 객체 생성 불가능
		Car c1 = new Car("k5", "하얀색");
		
		c1.speedUp(70);
		c1.speedDown(20);
		
		System.out.println("-----------------------");
		
		Movable m = new Car();	
		m.speedUp(100);
		m.speedDown(50);
		c1.printSpeed();
		
		//Car c = m; 타입x
		Car c = (Car)m; //가능
		//Car c = new Car(); 가능
		//Movable m = c; 불가능
		//Movable m = (Movable)c; 불가능
		c.speedUp(30);
		c.printSpeed();
		
		c = new Car("아반떼", "검정");
		
		System.out.println();
		System.out.println(c1);
		System.out.println(c);
	}

}
