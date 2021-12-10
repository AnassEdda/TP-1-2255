package vaxtodo;

import java.util.*;

public class User {

	private long userCode;
	private String password;
	private long accountNumber;
	private String lastName;
	private String firstName;
	private String birthdate;
	private String email;
	private long phoneNumber;
	private Address address;
	private String postalCode;
	private String city;
	private WorkingDay[] schedule;
	private boolean isEmployee;

	//constructor used during the creation of a new User
	public User(String password, String lastName, String firstName, String birthdate, String email, Address address, String postalCode, String city, long phoneNumber, String isEmployee) {
		this.userCode = generateUserCode();
		this.password = password;
		this.accountNumber = generateAccountNumber();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.schedule = null;

		if(isEmployee.equals("OUI")) {
			this.isEmployee = true;
		}else {
			this.isEmployee = false;
		}
	}
	
	//constructor used when fetching Users from storage
	public User(long userCode, String password, String lastName, String firstName, String birthdate, String email, Address address, String postalCode, String city, long phoneNumber, String isEmployee, long accountNumber, WorkingDay[] schedule) {
		this.userCode = userCode;
		this.password = password;
		this.accountNumber = accountNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.schedule = schedule;

		if(isEmployee.equals("OUI")) {
			this.isEmployee = true;
		}else {
			this.isEmployee = false;
		}
	}

	@Override
	public String toString() {
		String text = userCode + " " + password + " " + lastName + " " + firstName + " "
				+ birthdate + " " + email + " " + address.toString() + " " + postalCode + " " 
				+ city + " " + phoneNumber + " ";
		
		if(isEmployee == true) text += "OUI";
		else text += "NON";
		
		text += " " + accountNumber + " ";
		
		if(schedule == null) text += "empty";
		else {
			for(int i = 0; i < schedule.length - 1; ++i) {
				text += schedule[i].toString() + "/";
			}
			text += schedule[schedule.length-1].toString();
		}
		return text;
	}

	public static boolean isValid(String[] infos) {
		boolean isValid = true;
		
		//TODO password check (infos[0])
		
		if(!infos[1].matches("[a-zA-Z]+")) {
			System.out.println("Nom de famille invalide");
			isValid = false;
		}
		
		if(!infos[2].matches("[a-zA-Z]+")) {
			System.out.println("Prenom invalide");
			isValid = false;
		}
		
		try {
			String[] date = infos[3].split("-");
			int[] dateInt = new int[date.length];
			for(int i = 0; i < date.length; ++i) {
				dateInt[i] = Integer.parseInt(date[i]);
			}
			if(date.length != 3 || dateInt[2] < 1 || dateInt[2] > 31 || dateInt[1] < 1 || dateInt[1] > 12 || dateInt[0] > 2021) {
				System.out.println("Date de naissance invalide");
				isValid = false;
			}
		} catch(NumberFormatException e) {
			System.out.println("Date de naissance invalide");
			isValid = false;
		}
		
		String[] emailVerif = infos[4].split("@");
		if(emailVerif.length != 2) {
			System.out.println("Adresse courriel invalide");
			isValid = false;
		}
		
		String[] addressVerif = infos[5].split(",");
		if(addressVerif.length != 2 || !Address.isValid(addressVerif)) {
			isValid = false;
		}
		
		if(infos[6].length() != 6) {
			System.out.println("Code postal invalide");
			isValid = false;
		}
		
		if(!infos[7].matches("[a-zA-Z]+")) {
			System.out.println("Ville invalide");
			isValid = false;
		}
		
		try {
			Integer.parseInt(infos[8]);
		} catch(NumberFormatException e) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		if(infos[8].length() != 10) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		
		if(!infos[9].equals("NON") || !infos[9].equals("OUI")) {
			System.out.println("Entrer OUI ou NON lors de la demande de si l'utilisateur est un employe");
			isValid = false;
		}
		
		return isValid;
	}
	
	public int generateAccountNumber() {
		int number = 0;
		Random rand = new Random();
		
		for(int i = 0; i < 12; ++i) {
			number += rand.nextInt(10) * Math.pow(10, i);
		}
		
		for(User user : VaxTodo.users) {
			if(user.accountNumber == number) return generateAccountNumber();
		}
		
		return number;
	}
	
	public int generateUserCode() {
		int code = 0;
		Random rand = new Random();
		
		for(int i = 0; i < 9; ++i) {
			code += rand.nextInt(10) * Math.pow(10, i);
		}
		
		for(User user : VaxTodo.users) {
			if(user.userCode == code) return generateUserCode();
		}
		
		return code;
	}

	public long getUserCode() {
		return userCode;
	}

	public void setUserCode(long userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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