package vaxtodo;

public class Vaccine {

	public static final int VACCINE_MAX_NUMBER = 2;
	
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
	
	public Vaccine(String infos) {
		String[] vaccines = infos.split(",");
		
		this.date = vaccines[0];
		this.doseNumber = Integer.parseInt(vaccines[1]);
		this.code = vaccines[2];
		this.vaccineName = VaxName.valueOf(vaccines[3]);
	}
	
	
	
	@Override
	public String toString() {
		return date + "," + doseNumber + "," + code + "," + vaccineName;
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