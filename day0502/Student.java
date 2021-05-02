abstract class Human
{
	protected String name;
	protected int age;

	//생성자
	public Human(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println("Human 생성자 호출");
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

	/*public static void main(String[] args) 
	{
		Human h1 = new Human("춘향", 18);
		Human h2 = new Human("몽룡", 21);
		Human h3 = new Human("사또", 50);

		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
	}*/

	public abstract String getProfesstion();

}

class Student extends Human
{
	private String major;

	//생성자
	public Student(String name, int age, String major){
		super(name, age);
		this.major = major;
		System.out.println("Student 생성자 호출");
	}

	//setter
	public void setMajor(String major){
		this.major = major;
	}

	//getter
	public String getMajor(){
		return major;
	}

	@Override
	public String toString(){
		return super.toString() + ", 전공: " + major;
	}

	@Override
	public String getProfesstion(){
		if (major.equals("컴퓨터")){
			return ", 현재 직업은 프로그래머";
		} else if(major.equals("경영")){
			return ", 현재 직업은 회사원";
		} else{
			return ", 현재 직업은 회계사";
		}
	}

	public static void main(String[] args) 
	{
		Student s1 = new Student("명진", 21, "컴퓨터");
		Student s2 = new Student("미현", 22, "경영");
		Student s3 = new Student("용준", 24, "경제");

		System.out.println(s1 + s1.getProfesstion());
		System.out.println(s2 + s2.getProfesstion());
		System.out.println(s3 + s3.getProfesstion());
	}
}




