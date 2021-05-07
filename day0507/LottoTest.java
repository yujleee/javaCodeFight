package remind;

public class LottoTest {

	public static void main(String[] args) {
		//배열로 랜덤 정수 6개 출력하기
		
		int []lotto = new int[6];
		
		for (int i = 0; i < lotto.length; i++) {
			int num = (int)(Math.random() * 45 + 1);
			lotto[i] = num;			
		}

		System.out.println("** 이 주의 로또 번호 **");
		for (int i = 0; i < lotto.length; i++) {		
			System.out.print(lotto[i] + "\t");
		}
		
	}
}
