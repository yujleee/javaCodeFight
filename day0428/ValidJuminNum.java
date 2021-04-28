/*
ㄱㄴㄷㄹㅁㅂ - ㅅㅇㅈㅊㅋㅌㅍ
ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}

연산결과가 ㅍ과 같으면 올바른 주민번호라고 출력

*/

import java.util.Scanner; 
class TeamHWValidJumin  
{
	public static boolean validJumin(String data){
		boolean isValid = false; 

		if (data.length() != 14) //data의 길이가 14가 아니면 메소드 종료(올바르지 않은 주민번호)
			return isValid;
		
		String []temp = new String[14];
		for (int i=0; i<temp.length; i++){
			if (i==6) // - 일때는 쪼개서 저장 안하고 넘어감
				continue;
			temp[i] = data.substring(i,i+1); //data에서 한자리씩 쪼개서 temp배열에 넣음
		}

		int []num = {2,3,4,5,6,7,8,9,2,3,4,5}; //올바른 주민번호 계산식에 필요한 숫자
		int total = 0;
		for (int i=0; i<num.length; i++){
			if (i==6) // - 일때는 넘어감
				continue;
			total += num[i] * Integer.parseInt(temp[i]); // 계산식숫자 * 정수로 반환한 값 total에 누적 
		}
		
		int result = 11-(total%11);
		if (result == Integer.parseInt(temp[13])) //결과가 ㅍ(주민번호 마지막 숫자)과 같을때
			isValid = true;

		return isValid; 
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String jumin;
		
		System.out.print("주민번호를 입력하세요==>");
		jumin = sc.next();
		validJumin(jumin);
		
		if (validJumin(jumin) == true){
			System.out.println("올바른 주민번호입니다");
		}else{
			System.out.println("올바르지 않은 주민번호입니다");
		}
	}
}
