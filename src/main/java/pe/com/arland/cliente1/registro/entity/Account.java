package pe.com.arland.cliente1.registro.entity;

public class Account {

	//ID CUENTA STRING / ESTADO CUENTA DOUBLE
	private String accountId;
	private long balance;

	public Account(String accountId, long initialBalance) {
		this.accountId = accountId;
		this.balance = initialBalance;
	}

	public void debit(long amount) {
		this.balance -= amount;
	}

	public void credit(long amount) {
		this.balance += amount;
	}

	public long getBalance() {
		return this.balance;
	}
}
