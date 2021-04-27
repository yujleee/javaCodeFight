import java.util.Scanner;
class Student
{
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private int avg;

	//생성자
	public Student(){}
	
	public Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = kor + eng + math;
		this.avg = this.tot/3;
	}

	//setter
	public void setName(String name){
		this.name = name;
	}

	public void setKor(int kor){
		this.kor = kor;
	}

	public void setEng(int eng){
		this.eng = eng;
	}

	public void setMath(int math){
		this.math = math;
	}

	//getter
	public String getName(){
		return name;
	}

	public int getKor(){
		return kor;
	}

	public int getEng(){
		return eng;
	}

	public int getMath(){
		return math;
	}

	public int getTot(){
		return tot;
	}

	public int getAvg(){
		return avg;
	}
}

class InfoMenu
{
	//학생의 이름과 점수를 등록하는 메소드
	public void addInfo(Student []a, int n){
		Scanner sc = new Scanner(System.in);
		String name;
		int kor,eng,math;

		System.out.println();
		System.out.print("학생 이름==>");
		name = sc.next();
		System.out.print("학생 국어점수==>");
		kor = sc.nextInt();
		System.out.print("학생 영어점수==>");
		eng = sc.nextInt();
		System.out.print("학생 수학점수==>");
		math = sc.nextInt();

		a[n] = new Student(name,kor,eng,math);
		System.out.println();
	}

	//모든 학생을 출력하는 메소드
	public void printInfo(Student []a, int n){
		System.out.println("------------------------------------------------------");
		System.out.println("이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------");
		for (int i=0; i<n; i++){
			System.out.println(a[i].getName() + "\t\t" + a[i].getKor() + "\t"  + a[i].getEng() + "\t"  + a[i].getMath() + "\t" 
				 + a[i].getTot() + "\t"  + a[i].getAvg());
		}
		System.out.println();
	}

	//내림차순으로 성적을 정렬하는 메소드
	public void sortInfo(Student []a, int n){
		for (int i=0; i<n; i++){
			for (int j=i+1; j<n; j++){
				if (a[j].getTot() > a[i].getTot()){
					Student temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("----정렬 완료----");
		System.out.println();
	}

	//학생의 이름을 검색하여 성적을 출력하는 메소드
	public void searchInfo(Student []a, int n){
		Scanner sc = new Scanner(System.in);
		String name;
		boolean flag = false;

		System.out.print("검색할 학생 이름 입력==>");
		name = sc.next();

		for (int i=0; i<n; i++){
			if (a[i].getName().equals(name)){
				flag = true;
				System.out.println("------------------------------------------------------");
				System.out.println("이름\t\t국어\t영어\t수학\t총점\t평균");
				System.out.println("------------------------------------------------------");
				System.out.println(a[i].getName() + "\t\t" + a[i].getKor() + "\t"  + a[i].getEng() + "\t"  + a[i].getMath() + "\t" 
				 + a[i].getTot() + "\t"  + a[i].getAvg());
         System.out.println();
				break;
			}
		}

		if (flag == false)
			System.out.println(name + "학생의 정보는 존재하지 않습니다.");
      System.out.println();		

	}
}

class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		InfoMenu ctrl = new InfoMenu();
		Student s[] = new Student[100];
		int menu, n=0;
		
		while(true){
			System.out.print("1.학생등록  2. 모든 학생 출력	3.정렬하기   4.검색하기   0.종료 ===> ");
			menu = sc.nextInt();

			if (menu == 0){
				break;
			}

			switch(menu){
				case 1: ctrl.addInfo(s,n); n++; break;
				case 2: ctrl.printInfo(s,n); break;
				case 3: ctrl.sortInfo(s,n); break;
				case 4: ctrl.searchInfo(s,n); break;
			}
		}
	}
}
