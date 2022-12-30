package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountHolder =accountHolder;
		this.accountNumber=accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	public AccountHolder getAccountHolder() {
        return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
        boolean flag = false;
		if(attemptedPin==this.pin){
			flag = true;
		}
		return flag;
	}

	public double getBalance() {
        return this.balance;
	}

	public Long getAccountNumber() {
        return this.accountNumber;
	}

	public void creditAccount(double amount) {
		this.balance = this.balance + amount;
	}

	public boolean debitAccount(double amount) {
		boolean flag = false;

		if(amount<=this.balance){
			this.balance = this.balance - amount;
			flag = true;
		}

        return flag;
	}
}
