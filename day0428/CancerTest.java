import java.util.Scanner;
import java.util.Date;
class CancerTest 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int thisYear = today.getYear() + 1900;

		String name;
		String jumin;
	
		System.out.print("이름을 입력하세요==>");
		name = sc.next();
		System.out.print("주민번호를 입력하세요==>");
		jumin = sc.next(); //8010101-1234567

		int userYear = (Integer.parseInt(jumin.substring(0,2)) + 1900);
		//연도 뽑아와서 1900더한 값을 현재연도에서 뺌

		if (jumin.charAt(7) == '3'|| jumin.charAt(7) == '4'){
			userYear += 100;
		}

		int age = thisYear - userYear + 1;

		//무료 암검진 대상자가 아닌 경우: 나이가 40세 미만 or 올해연도 2로 나눈 나머지 != 출생연도 2로나눈 나머지
		if (age < 40 || (thisYear%2 != userYear%2)){
			System.out.println(name + "님은 " + thisYear + "년도 무료암검진 대상자가 아닙니다.");
			return;
		}

		String result = "위암, 간암";
		if (age >= 50){
			result += ", 대장암";
		}
		if ( jumin.charAt(7) == '2' || jumin.charAt(7) == '4'){
			result += ", 유방암, 자궁경부암";
		}

		System.out.println(name + "님은 " + thisYear + "년도 무료암검진 대상자이며 검진 항목은 " + result + "입니다.");

	}
}
