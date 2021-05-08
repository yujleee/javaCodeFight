package exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest{
	
	public static void insertStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String name, addr, phone;
		System.out.print("추가할 학생의 이름을 입력하세요==>");
		name = sc.next();

		System.out.print("추가할 학생의 주소를 입력하세요==>");
		addr = sc.next();
		
		System.out.print("추가할 학생의 전화번호를 입력하세요==>");
		phone = sc.next();
			
		list.add(new Student(name, addr, phone));
		System.out.println("학생을 추가했습니다.");
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String name;
		boolean flag = false;
		
		System.out.print("검색할 학생의 이름을 입력하세요==>");
		name = sc.next();
		
		for (Student student : list) {
			if(student.getName().equals(name)) {
				System.out.println(student.getName() + "\t" + student.getAddr() + "\t" + student.getPhone());
				flag = true;
			}
		}
		
		if (flag == false) {
			System.out.println("찾는 학생 " + name + "은 없습니다.");
		}
		
	}
	
	public static void deleteStudent(ArrayList<Student> list) {
		Scanner sc = new Scanner(System.in);
		String name;
	
		System.out.println("삭제할 학생의 이름을 입력하세요==>");
		name = sc.next();
		boolean flag = false;
		
		for (Student student : list) {
			if(student.getName().equals(name)) {
				list.remove(student);
				flag = true;
			}
		}
		
		if (flag == true) {
			System.out.println("해당 학생을 삭제했습니다.");
		} else {
			System.out.println("해당 학생이 없습니다. ");
		}
		
	}
	
	public static void printAllStudent(ArrayList<Student> list) {
		System.out.println("*** 학생 목록 ***");
		System.out.println("이름\t주소\t전화번호");
		for (Student student : list) {
			System.out.println(student.getName() + "\t" + student.getAddr() + "\t" + student.getPhone() );
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		int menu;
		
		while(true) {
			System.out.print("1.추가  2.검색  3.삭제  4.모두출력  0.종료  ==> ");
			menu = sc.nextInt();
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1: insertStudent(list); break;
				case 2: searchStudent(list); break;
				case 3: deleteStudent(list); break;
				case 4: printAllStudent(list); break;
			}//end switch
			
		}//end while
		System.out.println("프로그램을 종료합니다.");
		
	}//end main

}
