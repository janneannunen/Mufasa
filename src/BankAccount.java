

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class BankAccount {
	
	private String BankAccountPassword; // check confirm password
	private Address UserAddress =  new Address(); //from class
//	private User userAccount = new User();
	private String CardHolderName;
	private String CardType; //selection from list (Mastercard,VISA, Discover), 
	private String CardNumber;
	private String ExpiryDate; 

	
	
	
//	private MufasaBankACC BankAccInterface;
//	private MufasaTransaction transaction;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	
		
	/**
	 * @return the transaction
	 */
//	public MufasaTransaction getTransaction() {
//		return transaction;
//	}

	/**
	 * @param transaction the transaction to set
	 */
//	public void setTransaction(MufasaTransaction transaction) {
//		this.transaction = transaction;
//	}


	/**
	 * @return the bankAccInterface
	 */
//	public MufasaBankACC getBankAccInterface() {
//		return BankAccInterface;
//	}

	/**
	 * @param bankAccInterface the bankAccInterface to set
	 */
//	public void setBankAccInterface(MufasaBankACC bankAccInterface) {
//		BankAccInterface = bankAccInterface;
//	}

	/**
	 * @return the bankAccountPassword
	 */
	public String getBankAccountPassword() {
		return BankAccountPassword;
	}

	/**
	 * @param bankAccountPassword the bankAccountPassword to set
	 * @throws BankAccountException 
	 */
	public void setBankAccountPassword(String bankAccountPassword, String confirmPassword) throws BankAccountException {
		String pattern = "^(?=.*[a-zA-Z!@#$%^&*()_+])[[A-Za-z]\\d!@#$%^&*()_+]{8,19}$";
		boolean check = bankAccountPassword.matches(pattern);
		if(check == true && bankAccountPassword == confirmPassword){
			BankAccountPassword = bankAccountPassword;
		}else{
			throw new BankAccountException("Password is invalid");
		}
	}

	/**
	 * @return the userAddress
	 */
	public Address getUserAddress() {
		return UserAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(Address userAddress) {
		UserAddress = userAddress;
	}

	/**
	 * @return the cardHolderName
	 */
	public String getCardHolderName() {
		return CardHolderName;
	}

	/**
	 * @param cardHolderName the cardHolderName to set
	 * @throws BankAccountException 
	 */
	public void setCardHolderName(String cardHolderName) throws BankAccountException {
		String pattern = "^[A-z ]+$";
		boolean check = cardHolderName.matches(pattern);
		if(check == true){
			CardHolderName = cardHolderName;
		}else{
			throw new BankAccountException("Name is invalid");
		}
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return CardType;
	}

	/**
	 * @param cardType the cardType to set
	 * @throws BankAccountException 
	 */
	public void setCardType(String cardType) throws BankAccountException {
		String pattern = "^[A-z]+$";
		boolean check = cardType.matches(pattern);
		
		//because we don't have the selection in UI we check manually
		if(check == true && (cardType == "Mastercard"||cardType == "VISA"||cardType == "Discover")){
			CardType = cardType;
		}else{
			throw new BankAccountException("Card Type is invalid");
		}
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return CardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 * @throws BankAccountException 
	 */
	public void setCardNumber(String cardNumber) throws BankAccountException {
		boolean check = cardNumber.length() == 16;
		if(check == true){
			CardNumber = cardNumber;
		}else{
			throw new BankAccountException("Card Number is invalid");
		}
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return ExpiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 * @throws BankAccountException 
	 * @throws ParseException 
	 */
	public boolean isValidExpiryDate(String input) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("mm/yy");
	     try {
	          format.parse(input);
	          return true;
	     }
	     catch(ParseException e){
	          return false;
	     }
	}
	
	public void setExpiryDate(String expiryDate) throws ParseException, BankAccountException {
		boolean check = isValidExpiryDate(expiryDate);
		if(check == true){
			ExpiryDate = expiryDate;
		}else{
			throw new BankAccountException("Expiry Date is invalid");
		}
	}

	/**
	 * @param cvc the cvc to test the transaction
	 */
	

	/**
	 * @return the userAccount
	*/
//	public User getUserAccount() {
//		return userAccount;
//	}

	/**
	 * @param userAccount the userAccount to set
	 */
//	public void setUserAccount(User userAccount) {
//		this.userAccount = userAccount;
//	}
	

}