package teamVehicle;

abstract public class Vehicle {
	int speed;
	public abstract double getKiloPerLiter();
	
	public void printSpeed(){
		System.out.println("현재속도:" + speed);
	}
}
