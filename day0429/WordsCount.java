import java.util.Scanner;
class WordsCount
{
	public static int matchWords(String []words, String temp, int n){
		for (int i=0; i<n; i++){
			if (words[i].equals(temp)){ //등록된 단어와 등록해야 할 temp의 단어가 같은지 비교
				return i; //매칭되면 그 숫자를 반환 
			}
		}
		return -1; //매칭되지 않으면 -1 반환 
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String data;

		System.out.print("문장을 입력하세요==>");
		data = sc.nextLine();

		String []list = data.split(" "); //공백을 기준으로 단어 쪼개서 배열에 넣음
		
		//중복되는 단어를 넣귀 위한 배열
		String []words = new String[list.length];

		//단어 카운트 세는 배열
		int []cnt = new int[list.length];
	
		//words 배열이 비어있기 때문에 첫번째 단어는 일단 넣는다.
		words[0] = list[0];
		cnt[0] = 1;

		int n=1; //words 배열 카운트를 위한 변수

		for (int i=1; i<list.length; i++){
			String temp = list[i]; 

			int idx = matchWords(words,temp,n);
			if (idx != -1){ //인덱스가 -1이 아닐 때
				cnt[idx]++; //인덱스에 해당하는 카운트 1씩 증가
			} else{
				words[n] = temp; //인덱스 -1일때 words 배열에 temp 저장
				cnt[n] = 1; //새롭게 카운트 
				n++;
			}
			
		}

		//출력
		System.out.println();
		for (int i=0; i<n; i++){
			System.out.println(words[i] + "==>" + cnt[i] + "회 누적");
		}
	}
}
