// 인터페이스와 다형성 LAB 1번

abstract class Vehicle
{
	int speed;
	public abstract double getKilosPerLiter();

	public void printSpeed(){
		System.out.println("현재속도는 70km/h");
	}
}

class Car extends Vehicle
{
	public double getKilosPerLiter(){
		return 60.5;
	}

	public void printSpeed(){
		super.printSpeed();
		
	}
}

class CarTest 
{
	public static void main(String[] args) 
	{
		//Vehicle v1 = new Vehicle(); 추상클래스라 객체 생성 불가능 
		//v1.printSpeed();

		Car c1 = new Car();
		c1.getKilosPerLiter();
		c1.printSpeed();
	}
}
