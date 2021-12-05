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

	public boolean isValid() {
		// TODO - implement Reservation.isValid
		return false;
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