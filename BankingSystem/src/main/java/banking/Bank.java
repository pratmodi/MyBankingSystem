package banking;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		Account acc = null;

		for(Map.Entry<Long, Account> entry:accounts.entrySet()){
			if(entry.getValue().getAccountNumber()==accountNumber){
				acc = entry.getValue();
				break;
			}
		}

        return acc;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
	Long accNo = 0L;
		for(Map.Entry<Long, Account> entry:accounts.entrySet()){
			if(entry.getValue().getAccountHolder().equals(company)){
				accNo = entry.getValue().getAccountNumber();
				break;
			}
		}

        return accNo;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {

		Long accNo = 0L;
		for(Map.Entry<Long, Account> entry:accounts.entrySet()){
			if(entry.getValue().getAccountHolder().equals(person)){
				accNo = entry.getValue().getAccountNumber();
				break;
			}
		}

		return accNo;

	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		boolean flag = false;

		Long accNo = 0L;
		for(Map.Entry<Long, Account> entry:accounts.entrySet()){
			if(entry.getValue().getAccountNumber()==accountNumber){
				accNo = entry.getValue().getAccountNumber();
				if(entry.getValue().validatePin(pin)){
					flag = true;
				}
				break;
			}
		}

		return flag;

	}

	public double getBalance(Long accountNumber) {
		double bal = 0L;
		for(Map.Entry<Long, Account> entry:accounts.entrySet()){
			if(entry.getValue().getAccountNumber()==accountNumber){
				bal = entry.getValue().getBalance();
				break;
			}
		}
		return bal;
	}

	public void credit(Long accountNumber, double amount) {

		for(Map.Entry<Long, Account> entry:accounts.entrySet()) {
			if (entry.getValue().getAccountNumber() == accountNumber) {
				this.accounts.get(accountNumber).creditAccount(amount);
				break;
			}

		}

	}

	public boolean debit(Long accountNumber, double amount) {
		boolean flag = false;
		for(Map.Entry<Long, Account> entry:accounts.entrySet()) {
			if (entry.getValue().getAccountNumber() == accountNumber) {
				if(this.accounts.get(accountNumber).debitAccount(amount)) {
					flag = true;
				}
				}
				break;
			}

        return flag;
	}
}
