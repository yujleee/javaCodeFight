package teamVehicle;

public interface Movable {
	//int speed; 상수가 아니라 불가능 
	int speed = 100;
	public void speedUp(int amount);
	public void speedDown(int amount);
	 //인터페이스는 상수,추상메소드를 구성요소로 가져서 final , abstract 없어도 ok 

}
