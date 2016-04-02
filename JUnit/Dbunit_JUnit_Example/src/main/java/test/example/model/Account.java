package test.example.model;

public class Account {

	private String accountNo;

	private String accountType;

	private long balance;

	public Account(String accountNo, String accountType, long balance) {
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNo=").append(accountNo).append(", accountType=").append(accountType)
				.append(", balance=").append(balance).append("]");
		return builder.toString();
	}
}
