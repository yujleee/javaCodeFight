/*
	이메일에 @을 포함하지 않은 경우에 대해 처리 (@ = at)
	id는 적어도 5자 이상이 되도록 프로그램 수정 
*/
import java.util.Scanner;
class PrintEmailId04
{
	//이메일을 문자열로 전달받아 올바른 이메일인지 판별하여 true,false를 반환하는 메소드
	//조건: 반드시 @을 포함해야 한다 + 아이디는 적어도 5자 이상이어야 한다
	public static boolean isValidEmail(String data){
		/*boolean flag = false;
		if (data.indexOf("@") >= 5){
			flag = true;
		} */
		return data.indexOf("@") >= 5; //어차피 불린 변수이므로 true/false로 반환되기 때문
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String email;

		System.out.print("이메일을 입력하세요==>");
		email = sc.next();

		if ( isValidEmail(email) == false){
			System.out.println("올바르지 않은 아이디입니다.");
			return;
		}

		int n = email.indexOf("@"); //@의 위치
		String id = email.substring(0,n); //@ 전까지를 새로운 문자열로 생성

		System.out.println("아이디는 " + id + "입니다.");
		
	}
}
