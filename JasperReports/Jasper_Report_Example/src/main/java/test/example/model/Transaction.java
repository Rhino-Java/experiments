package test.example.model;

public class Transaction {

	private String transactionDate;;
	private String type;
	private String customerSupplier;
	private String reference;
	private String description;
	private String inclusiveAmount;
	private String taxCode;
	private String bankCode;
	private String accountNumber;
	private String statementDate;

	public Transaction(String transactionDate, String type, String customerSupplier, String reference,
			String description, String inclusiveAmount, String taxCode, String bankCode, String accountNumber,
			String statementDate) {
		this.transactionDate = transactionDate;
		this.type = type;
		this.customerSupplier = customerSupplier;
		this.reference = reference;
		this.description = description;
		this.inclusiveAmount = inclusiveAmount;
		this.taxCode = taxCode;
		this.bankCode = bankCode;
		this.accountNumber = accountNumber;
		this.statementDate = statementDate;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInclusiveAmount() {
		return inclusiveAmount;
	}

	public void setInclusiveAmount(String inclusiveAmount) {
		this.inclusiveAmount = inclusiveAmount;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(String statementDate) {
		this.statementDate = statementDate;
	}

	public String getCustomerSupplier() {
		return customerSupplier;
	}

	public void setCustomerSupplier(String customerSupplier) {
		this.customerSupplier = customerSupplier;
	}

}
