package vaxtodo;

public class User {

	private String username;
	private String password;
	private int accountNumber;
	private String lastName;
	private String firstName;
	private Address address;
	private int phoneNumber;
	private WorkingDay[] schedule;
	private boolean isEmployee;

	public User(String username, String password, String lastName, String firstName, Address address, int phoneNumber, boolean isEmployee) {
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.isEmployee = isEmployee;
		this.schedule = null;
		this.accountNumber = generateAccountNumber();
	}
	
	public boolean isValid() {
		// TODO - implement User.isValid
		return false;
	}
	
	public int generateAccountNumber() {
		// TODO - implement User.generateAccountNumber
		return 0;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public WorkingDay[] getSchedule() {
		return schedule;
	}

	public void setSchedule(WorkingDay[] schedule) {
		this.schedule = schedule;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}