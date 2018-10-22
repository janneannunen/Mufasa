
import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.easymock.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class Person extends EasyMockSupport{
			
		@Rule
		public EasyMockRule rule = new EasyMockRule(this);

		@Mock
		private MufasaAccountCreation Jussi; // 1
		private MufasaAddress userAddress; // 1
		private MufasaBankACC userBank; // 1
		private MufasaTransaction transaction; // 1
		//private Transaction info; // 1
		
		@TestSubject
		//Bank Account
		public BankAccount newBank = new BankAccount();// 2
		//Address
		public	Address newAddress = new Address();// 2
		//Info
		public Transaction info = new Transaction();// 2
		
		@Before
		public void setup(){
			Jussi = EasyMock.createMock(MufasaAccountCreation.class);
			info.setAccount(Jussi);
			replayAll(); // 4
			userAddress = EasyMock.createMock(MufasaAddress.class);
			info.setAddress(userAddress);
			
			userBank = EasyMock.createMock(MufasaBankACC.class);
			info.setBank(userBank);
			
			transaction = EasyMock.createMock(MufasaTransaction.class);
			info.setTransaction(transaction);
			
		}

		@Test
		public void test() throws UserException, ParseException, AddressException, BankAccountException {
			//User
			User newUser = new User();
			
			newUser.setFirstName("Tatja");
			newUser.setLastName("Patja");
			newUser.setPassword("123asdf!@#", "123asdf!@#");
			newUser.setUsername("Tatja69");
			newUser.setPhoneNumber("1231231231");
			newUser.setBirthdate("12/12/1912");
			newUser.setCountry("Belarus");
			newUser.setEmail("69meditation@gmail.com", "69meditation@gmail.com");
			
			EasyMock.expect(Jussi.getAccInfo()).andReturn(newUser);
			EasyMock.replay(Jussi);
			
			
			
			newAddress.setStreetAddress("sorvankylanjuuri");
			newAddress.setCity("Sorvankyla");
			newAddress.setPostalCode("00001");
			newAddress.setCountry("Belarus");
			
			EasyMock.expect(userAddress.getAddressInfo()).andReturn(newAddress);
			EasyMock.replay(userAddress);
			
			
			
			newBank.setUserAddress(newAddress);
			newBank.setBankAccountPassword("123asdf!@#", "123asdf!@#");
			newBank.setCardHolderName("Tatja Patja");
			newBank.setCardNumber("1231231231231231"); //16
			newBank.setExpiryDate("06/69");
			
			EasyMock.expect(userBank.getBankInfo(newUser)).andReturn(newBank);
			EasyMock.replay(userBank);
			
			EasyMock.expect(transaction.getTransactionResult()).andReturn(334);
			EasyMock.replay(transaction);
			String result = info.getTransactionResult();
			
			verifyAll(); // 6
			assertEquals("Transaction Passed", result);
		}
}
