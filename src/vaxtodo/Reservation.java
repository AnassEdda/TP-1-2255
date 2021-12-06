package vaxtodo;

public class Reservation {

	private int reservationNumber;
	private String lastName;
	private String firstName;
	private String visitDate;
	private String visitTime;
	private int doseNumber;
	
	public Reservation(String lastName, String firstName, String visitDate, String visitTime, int doseNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.visitDate = visitDate;
		this.visitTime = visitTime;
		this.doseNumber = doseNumber;
		this.reservationNumber = generateReservationNumber();
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
		
		String[] date = infos[2].split("-");
		int[] dateInt = new int[date.length];
		for(int i = 0; i < date.length; ++i) {
			dateInt[i] = Integer.parseInt(date[i]);
		}
		if(date.length != 3 || dateInt[2] < 1 || dateInt[2] > 31 || dateInt[1] < 1 || dateInt[1] > 12 || dateInt[0] > 2021) {
			System.out.println("Date invalide");
			isValid = false;
		}
		
		try {
			String[] time = infos[3].split(":");
			int[] timeInt = new int[time.length];
			for(int i = 0; i < time.length; ++i) {
				timeInt[i] = Integer.parseInt(date[i]);
			}
			if(time.length != 2 || timeInt[0] < 0 || timeInt[1] < 0 || timeInt[0] > 24 || timeInt[1] > 60) {
				System.out.println("Heure de rendez-vous invalide");
				isValid = false;
			}
		} catch(NumberFormatException e) {
			System.out.println("Heure de rendez-vous invalide");
			isValid = false;
		}
		
		try {
			int dose = Integer.parseInt(infos[4]);
			if(dose > Vaccine.VACCINE_MAX_NUMBER || dose < 1) {
				System.out.println("Numero de dose de vaccin invalide");
				isValid = false;
			}
		} catch(NumberFormatException e) {
			System.out.println("Numero de dose de vaccin invalide");
			isValid = false;
		}
		
		return isValid;
	}

	public int generateReservationNumber() {
		// TODO - implement Reservation.generateReservationNumber
		return 0;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
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

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public int getDoseNumber() {
		return doseNumber;
	}

	public void setDoseNumber(int doseNumber) {
		this.doseNumber = doseNumber;
	}

}