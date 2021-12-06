package vaxtodo;

import java.util.*;

public class User {

	private int userCode;
	private String password;
	private int accountNumber;
	private String lastName;
	private String firstName;
	private Address address;
	private int phoneNumber;
	private WorkingDay[] schedule;
	private boolean isEmployee;

	public User(String password, String lastName, String firstName, Address address, int phoneNumber, String isEmployee) {
		this.userCode = generateUserCode();
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;

		if(isEmployee.equals("OUI")) {
			this.isEmployee = true;
		}else {
			this.isEmployee = false;
		}
		
		this.schedule = null;
		this.accountNumber = generateAccountNumber();
	}
	
	public boolean isValid(String[] infos) {
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
			Integer.parseInt(infos[3]);
		} catch(NumberFormatException e) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		if(infos[3].length() != 10) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		
		if(!infos[4].equals("NON") || !infos[4].equals("OUI")) {
			System.out.println("Entrer OUI ou NON lors de la demande de si l'utilisateur est un employe");
			isValid = false;
		}
		
		return isValid;
	}
	
	public int generateAccountNumber() {
		int number = 0;
		Random rand = new Random();
		
		for(int i = 0; i < 12; ++i) {
			number += rand.nextInt() * Math.pow(10, i);
		}
		
		//TODO verifier que number est unique
		
		return number;
	}
	
	public int generateUserCode() {
		int code = 0;
		Random rand = new Random();
		
		for(int i = 0; i < 9; ++i) {
			code += rand.nextInt() * Math.pow(10, i);
		}
		
		//TODO verifier que code est unique
		
		return code;
	}
	
	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
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