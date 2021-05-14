import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

//한빛출판사의 새로운 도서목록의 문서내용 수집하여 출력하는 프로그램 

public class URLTest02 {

	public static void main(String[] args) {
		try {
			//한빛출판사의 새로운 도서 목록을 출력하는 URL 객체 생성 
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");

			//URL의 내용을 읽어오기 위한 스트림 생성 
			InputStream is = url.openStream();
			
			//바이트 단위로 읽어오기 위해 배열 생성 
			byte []data = new byte[100];

			//네트워크 데이터가 있는 만큼 읽어오기 위해 반복문 사용 
			while(true){
				
				//준비된 배열의 데이터를 읽어들임 
				int n = is.read(data); //읽어들인 data를 배열에 담아 바이트 수 반환 
				if(n == -1 ) {
					break;
				} //더이상 읽을 것이 없을 때 (-1 반환) while문 탈출 
		
				//읽어들인 데이터가 담긴 byte형의 배열인 data를 갖고 String 생성 
				String str = new String(data, "utf-8"); //한글 처리를 위해 문자셋 "utf-8"으로 설정. 
				
				System.out.println(str);
				
				Arrays.fill(data, (byte)0); 
				//배열을 다 못채울 때 원치않는 글자까지 출력될 수 있음 => 다음 while문으로 가기 전에 배열을 초기화해줌. 
			}
			
			is.close();

		}catch (Exception e) {
			System.out.println("예외발생:"  + e.getMessage());
		}

	}

}
