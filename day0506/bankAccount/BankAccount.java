package bank.account;

public class BankAccount{
	private int balance;
	
	public void deposit(int cash) {
		balance += cash;
		System.out.println("입금 금액:" + cash);
		System.out.println("현재 잔액:" + balance);
		System.out.println();
	}
	
	public void withdraw(int cash) throws NegativeBalanceException{
		if (cash > balance) {
			throw new NegativeBalanceException("인출 금액이 현재 잔액보다 큽니다.");
		}
		
		balance -= cash;
		
		System.out.println("인출 금액:" + cash);
		System.out.println("현재 잔액:" + balance);
		System.out.println();
	}
	
}
