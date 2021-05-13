public class CountdownEvent extends Thread {

	int delay;
	String msg;
	
	public CountdownEvent(int delay, String msg) {
		this.delay = delay;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			Thread.sleep(delay);
			System.out.println(msg);
			
		}catch (Exception e) {
		
		}
	}

}
