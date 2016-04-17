package test.example.model;

public class CustomerAccountMapping {

	private int id;

	private String customerId;

	private String accountNo;

	public CustomerAccountMapping(int id, String customerId, String accountNo) {

		this.id = id;
		this.customerId = customerId;
		this.accountNo = accountNo;
	}

	public CustomerAccountMapping(String customerId, String accountNo) {

		this.customerId = customerId;
		this.accountNo = accountNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerAccountMapping [id=").append(id).append(", customerId=").append(customerId)
				.append(", accountNo=").append(accountNo).append("]");
		return builder.toString();
	}

}
