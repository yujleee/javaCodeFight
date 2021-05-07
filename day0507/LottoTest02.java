package remind;

import java.util.HashSet;

public class LottoTest02 {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		while(true) {
			int num = (int)(Math.random() * 45 + 1);
			lotto.add(num);
			
			if(lotto.size() >= 6)
				break;
		}
		
		System.out.println("** 이주의 로또 번호 **");
		System.out.println(lotto);

	}

}
