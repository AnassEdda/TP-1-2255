package vaxtodo;

import java.util.*;


public class Visitor {

	private long accountNumber;
	private String lastName;
	private String firstName;
	private String birthdate;
	private String email;
	private long phoneNumber;
	private Address address;
	private String postalCode;
	private String city;
	private Vaccine[] vaccines;

	//constructor used when creating a new Visitor
	public Visitor(String lastName, String firstName, String birthdate, String email, Address address, String postalCode, String city, long phoneNumber) {
		this.accountNumber = generateAccountNumber();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.vaccines = new Vaccine[Vaccine.VACCINE_MAX_NUMBER];
	}

	//constructor used when fetching Visitors from storage
	public Visitor(long accountNumber, String lastName, String firstName, String birthdate, String email, Address address, String postalCode, String city, long phoneNumber, Vaccine[] vaccines) {
		this.accountNumber = accountNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.vaccines = vaccines;
	}


	@Override
	public String toString() {
		String text = accountNumber + " " + lastName + " " + firstName + " "
				+ birthdate + " " + email + " " + address.toString() + " "
				+ postalCode + " " +city + " " + phoneNumber + " ";
		
		if(vaccines[0] == null) text += "empty";
		else {
			for(int i = 0; i < vaccines.length - 1; ++i) {
				text += vaccines[i].toString() + "/";
			}
			text += vaccines[vaccines.length-1].toString();
		}
		return text;
	}
	
	public static boolean isValid(String[] infos) {
		boolean isValid = true;

		if(!infos[0].matches("[a-zA-Z]+")) {
			System.out.println("Nom de famille invalide");
			isValid = false;
		}
		
		if(!infos[1].matches("[a-zA-Z]+")) {
			System.out.println("Prenom invalide");
			isValid = false;
		}
		
		try {
			String[] date = infos[2].split("-");
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
		
		String[] emailVerif = infos[3].split("@");
		if(emailVerif.length != 2) {
			System.out.println("Adresse courriel invalide");
			isValid = false;
		}
		
		String[] addressVerif = infos[4].split(",");
		if(addressVerif.length != 2 || !Address.isValid(addressVerif)) {
			isValid = false;
		}
		
		if(infos[5].length() != 6 && !infos[5].matches("[A-Z0-9]+")) {
			System.out.println("Code postal invalide");
			isValid = false;
		}
		
		if(!infos[6].matches("[a-zA-Z]+")) {
			System.out.println("Ville invalide");
			isValid = false;
		}
		
		try {
			Long.parseLong(infos[7]);
		} catch(NumberFormatException e) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		if(infos[7].length() != 10) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		
		return isValid;
	}

	public long generateAccountNumber() {
		long number = 0;
		Random rand = new Random();
		
		for(int i = 0; i < 12; ++i) {
			number += rand.nextInt(10) * Math.pow(10, i);
		}
		
		for(Visitor visitor : VaxTodo.visitors) {
			if(visitor.accountNumber == number) return generateAccountNumber();
		}
		return number;
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

	public Vaccine[] getVaccines() {
		return vaccines;
	}

	public void setVaccines(Vaccine[] vaccines) {
		this.vaccines = vaccines;
	}
}