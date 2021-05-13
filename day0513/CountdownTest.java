public class CountdownTest {

	public static void main(String[] args) {
		Countdown cnt = new Countdown();
		(new Thread(cnt)).start(); 
		
		CountdownEvent cde = new CountdownEvent(2000, "연결장치 분리");
		cde.start();

	}

}
