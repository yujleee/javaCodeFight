package teamVehicle;

public class Car extends Vehicle implements Movable{
	
	String name;
	String color;
	
	
	public Car() {
		super();
	}

	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	public void turnLeft() {
		System.out.println("왼쪽으로 갑니다");
	}
	
	public void turnRight() {
		System.out.println("오른쪽으로 갑니다");
	}
	

	@Override
	public void speedUp(int amount) {
		System.out.println(amount + "만큼 속도를 올립니다");
	}
	
	@Override
	public void speedDown(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount + "만큼 속도를 내립니다");
	}

	@Override
	public double getKiloPerLiter() {
		// TODO Auto-generated method stub
		return 20;
	}

}
