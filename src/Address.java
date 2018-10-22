
public class Address {
	

	private String StreetAddress;  
	private String City; 
	private String PostalCode; 
	private String Country;
	private MufasaAddress AddressInterface;
	
	
	public void setListener(MufasaAddress AddressInterface) {
	    this.AddressInterface = AddressInterface;
	  }
	
	
	public Address() {
		// TODO Auto-generated constructor stub
		
	}

	public String getAddressInfo() {
		return (StreetAddress + City + PostalCode + Country
				);
	}
	
	/**
	 * @return the addressInterface
	 */
	public MufasaAddress getAddressInterface() {
		return AddressInterface;
	}

	/**
	 * @param addressInterface the addressInterface to set
	 */
	public void setAddressInterface(MufasaAddress addressInterface) {
		AddressInterface = addressInterface;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return StreetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 * @throws AddressException 
	 */
	public void setStreetAddress(String streetAddress) throws AddressException {
		String pattern = "^[a-zA-Z0-9]*$";
		boolean check = streetAddress.matches(pattern);
		if(check == true){
			StreetAddress = streetAddress;
		}else{
			throw new AddressException("Street Address is invalid");
		}
		
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}

	/**
	 * @param city the city to set
	 * @throws AddressException 
	 */
	public void setCity(String city) throws AddressException {
		String pattern = "^[A-z]+$";
		boolean check = city.matches(pattern);
		if(check == true){
			City = city;
		}else{
			throw new AddressException("City is invalid");
		}
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return PostalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 * @throws AddressException 
	 */
	public void setPostalCode(String postalCode) throws AddressException {
		String pattern = "^[0-9-]+$";
		boolean check = postalCode.matches(pattern);
		if(check == true){
			PostalCode = postalCode;
		}else{
			throw new AddressException("Postal Code is invalid");
		}
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * @param country the country to set
	 * @throws AddressException 
	 */
	public void setCountry(String country) throws AddressException {
		String pattern = "^[A-z]+$";
		boolean check = country.matches(pattern);
		if(check == true){
			Country = country;
		}else{
			throw new AddressException("Country is invalid");
		}
	}

}
