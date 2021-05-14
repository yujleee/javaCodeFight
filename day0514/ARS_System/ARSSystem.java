public class ARSSystem {

	public static void main(String[] args) {
		Account account = new Account();
		Donor d1 = new Donor("111", account); //6번줄의 Account를 공유함 
		Donor d2 = new Donor("222", account);
		Donor d3 = new Donor("333", account);
		Donor d4 = new Donor("444", account);
		Donor d5 = new Donor("555", account);

		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		//스레드 가동 => 시스템의 스케줄링 => 종료 시점이 실행때마다 다름.

		//join 스레드가 종료될 때까지 대기하는 메소드  
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("종료");
		System.out.println("전체모금액:" + account.getBalance());
		//동시에 공유자원에 access 하기 때문에 누락이 있을 수 있음
		

	}

}
