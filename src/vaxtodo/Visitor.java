package vaxtodo;

public class Visitor {

	private int accountNumber;
	private String lastName;
	private String firstName;
	private String birthdate;
	private String email;
	private int phoneNumber;
	private Vaccine[] vaccines;

	public Visitor(String lastName, String firstName, String birthdate, String email, int phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.accountNumber = generateAccountNumber();
		this.vaccines = null;
	}
	
	public boolean isValid() {
		// TODO - implement Visitor.isValid
		return false;
	}

	public int generateAccountNumber() {
		// TODO - implement Visitor.generateAccountNumber
		return 0;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Vaccine[] getVaccines() {
		return vaccines;
	}

	public void setVaccines(Vaccine[] vaccines) {
		this.vaccines = vaccines;
	}
}