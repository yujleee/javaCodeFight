// 상속의 일부분만 배우기 시작한 상태 

class Bird{
	String name;
	String color;
	boolean wing;

	public Bird(){}

	public Bird(String name, String color, boolean wing){
		this.name = name;
		this.color = color;
		this.wing = wing;
	}

	public void fly(){
		if (wing == true){
			System.out.println(color + "색 " + name + "은(는) 날고 있다");
		} else{
			System.out.println(color + "색 " + name + "은(는) 날 수 없다");
		}
	}
}

class Airplane extends Bird{ //Bird 클래스를 상속받는 Airplane 클래스 
	boolean engine;

	public Airplane(String name, String color, boolean wing, boolean engine){
		this.name = name;
		this.color = color;
		this.wing = wing;
		this.engine = engine;
	}

	public void fly(){ //메소드 오버라이딩 
		if (wing == true && engine == true){
			System.out.println(color + "색 " + name + "은(는) 비행하고 있다");
		} else{
			System.out.println(color + "색 " + name + "은(는) 비행할 수 없다");
		}
	}

}

class BirdTest02
{
	public static void main(String[] args) 
	{
		Bird b1 = new Bird("참새", "노랑", true);
		b1.fly();

		Airplane a1 = new Airplane("보잉747", "하늘", true, true);
		a1.fly();
	}
}
