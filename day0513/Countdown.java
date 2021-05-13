public class Countdown implements Runnable{

	@Override
	public void run() {
		
		try {
			for (int i = 20; i>=1; i--) {
				System.out.println(i + "초입니다.");
				Thread.sleep(1000);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("발사!");
	}

}
