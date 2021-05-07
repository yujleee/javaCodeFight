/*
 영어단어를 추가하고, 검색하고 삭제하고 출력할 수 있는 프로그램
 HashMap 이용.
  */

package engdic;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu;

		HashMap<String, String> dic = new HashMap<String, String>();

		while(true) {
			System.out.print("1.단어 추가    2. 단어 검색    3. 단어 삭제    4. 단어 모두 출력    0. 종료 ==>"); //메뉴 설정
			menu = sc.nextInt();

			if ( menu == 0) { //0을 입력시 종료 
				break;
			} 

			switch (menu) {
				case 1: addWords(dic); break;
				case 2: searchWords(dic); break;
				case 3: deleteWords(dic); break;
				case 4: printWords(dic); break;
			}
		}
		System.out.println("사전 종료");

	}

	//단어를 추가하는 메소드 
	private static void addWords(HashMap<String, String> dic) {
		Scanner sc = new Scanner(System.in);
		String word="", meaning="";
		
		System.out.print("추가할 단어 입력==>");
		word = sc.next();
		
		System.out.print("추가할 단어의 설명 입력==>");
		meaning = sc.next();
		
		dic.put(word, meaning);
		System.out.println("추가되었습니다");
	}
	
	//단어를 검색하는 메소드 
	private static void searchWords(HashMap<String, String> dic) {
		Scanner sc = new Scanner(System.in);
		String word="";
		
		System.out.print("검색할 단어 입력==>");
		word = sc.next();
				
		if(dic.get(word) == null) {
			System.out.println("찾으려는 단어가 없습니다.");
			return;
		}
		
		System.out.println(dic.get(word));
	}
	
	
	//단어를 삭제하는 메소드 
	private static void deleteWords(HashMap<String, String> dic) {
		Scanner sc = new Scanner(System.in);
		String word="";
		
		System.out.print("삭제할 단어 입력==>");
		word = sc.next();
		
		if(dic.get(word) == null) {
			System.out.println("삭제하려는 단어가 없습니다.");
			return;
		}
		
		dic.remove(word);
		System.out.println("삭제되었습니다");

	}
	
	//단어 전체 출력하는 메소드 
	private static void printWords(HashMap<String, String> dic) { 
		System.out.println(dic.entrySet());
	}

}
