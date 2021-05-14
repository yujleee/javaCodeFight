public class Donor extends Thread {
	private Account account;
	private String phone;
	
	public Donor(String phone, Account account) {
		this.phone = phone;
		this.account = account;
	}
	
	public void run() {
		for (int i = 1; i <=10; i++) {
			account.deposit(1000); //모든 기부자들은 1000원씩 10번 입금.
			System.out.println(phone + "가(이) " + i + "번째 입금하였습니다.");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		}
	}
	
}
