package bank.account;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
			BankAccount b = new BankAccount();
			
			b.deposit(10000);
			b.deposit(10000);
			b.withdraw(30000);
			
		} catch (NegativeBalanceException e) {
			System.out.println("예외 발생:" + e);
		}

	}

}
