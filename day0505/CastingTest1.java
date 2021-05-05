//자바의 정석 예제 실습
package just;

class Car{
	String color;
	int door;
	
	void drive() { //운전하는 기능
		System.out.println("drive, Brrrrr~");
	}
	
	void stop() { //멈추는 기능
		System.out.println("stop!!!");
	}
	

}

class FireEngine extends Car{
	void water() { //물을 뿌리는 기능
		System.out.println("water!!!");
	}
}


public class CastingTest1 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; 	// car = (Car)fe 형변환 생략. 자식 타입 참조변수를 부모타입 참조변수에 할당할 경우 생략 가능 
		//car = water(); //에러 발생. car는 Car 타입이기 때문에 FireEngine의 water() 사용 불가.
		
		fe2 = (FireEngine)car; //car를 FireEngine으로 형변환
		fe2.water(); //FireEngine 타입이므로 사용가능 

	}

}
