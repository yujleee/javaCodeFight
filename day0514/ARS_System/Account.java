public class Account {

	private int balance;
	
	public synchronized void deposit(int amount) { // synchronized 임계영역으로 설정
		balance += amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
}
