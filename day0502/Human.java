class Human
{
	String name;
	int age;

	//생성자
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}

	//setter
	public void setName(String name){
		this.name = name;
	}

	public void setAge(int age){
		this.age = age;
	}

	//getter
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public String toString(){
		return "이름: " + name + ", 나이: " + age + "세";
	}

	public static void main(String[] args) 
	{
		Human h1 = new Human("춘향", 18);
		Human h2 = new Human("몽룡", 21);
		Human h3 = new Human("사또", 50);

		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
	}
}
