package vaxtodo;

import java.util.Random;

public class Visitor {

	private int accountNumber;
	private String lastName;
	private String firstName;
	private int phoneNumber;
	private String email;
	private String birthdate;
	private Vaccine[] vaccines;

	public Visitor(String lastName, String firstName, String birthdate, String email, int phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthdate = birthdate;
		this.accountNumber = generateAccountNumber();
		this.vaccines = new Vaccine[Vaccine.VACCINE_MAX_NUMBER];
	}
	
	public boolean isValid(String[] infos) {
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
			Integer.parseInt(infos[2]);
		} catch(NumberFormatException e) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		if(infos[2].length() != 10) {
			System.out.println("Numero de telephone invalide");
			isValid = false;
		}
		
		String[] emailVerif = infos[3].split("@");
		if(emailVerif.length != 2) {
			System.out.println("Adresse courriel invalide");
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