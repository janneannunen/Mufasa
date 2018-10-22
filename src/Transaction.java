
public class Transaction {
	private MufasaAccountCreation account;
	private MufasaBankACC bank;
	private MufasaAddress address;
	private MufasaTransaction transaction;
	

	public void setListener(MufasaTransaction transaction) {
	    this.transaction = transaction;
	  }
	public void setListener(MufasaAddress address) {
	    this.address = address;
	  }
	public void setListener(MufasaBankACC bank) {
	    this.bank = bank;
	  }
	public void setListener(MufasaAccountCreation account) {
	    this.account = account;
	  }
	/**
	 * @return the account
	 */
	public MufasaAccountCreation getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(MufasaAccountCreation account) {
		this.account = account;
	}
	/**
	 * @return the account
	 */

	
	public String getTransactionResult() {
		int length = (int) Math.log10(getTransaction().getTransactionResult()) + 1;
		boolean check = length == 3;
		if(check == true && getAddress() != null && getAccount() != null && getBank() != null){
			return "Transaction Passed";
		}else{
			return "Transaction Failed";
		}	
	}
	/**
	 * @return the bank
	 */
	public MufasaBankACC getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(MufasaBankACC bank) {
		this.bank = bank;
	}
	/**
	 * @return the address
	 */
	public MufasaAddress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(MufasaAddress address) {
		this.address = address;
	}
	/**
	 * @return the transaction
	 */
	public MufasaTransaction getTransaction() {
		return transaction;
	}
	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(MufasaTransaction transaction) {
		this.transaction = transaction;
	}

}
