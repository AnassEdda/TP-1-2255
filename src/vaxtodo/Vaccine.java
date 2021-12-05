package vaxtodo;

public class Vaccine {

	private String date;
	private int doseNumber;
	private String code;
	private VaxName vaccineName;
	
	public Vaccine(String date, int doseNumber, VaxName vaccineName) {
		this.date = date;
		this.doseNumber = doseNumber;
		this.vaccineName = vaccineName;
		this.code = generateVaccineCode();
	}
	
	public String generateVaccineCode() {
		// TODO - implement Vaccine.generateVaccineCode
		return null;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDoseNumber() {
		return doseNumber;
	}
	public void setDoseNumber(int doseNumber) {
		this.doseNumber = doseNumber;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public VaxName getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(VaxName vaccineName) {
		this.vaccineName = vaccineName;
	}

}