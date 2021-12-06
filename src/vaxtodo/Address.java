package vaxtodo;

public class Address {

	private int stNumber;
	private String stName;
	
	public Address(int stNumber, String stName) {
		this.stNumber = stNumber;
		this.stName = stName;
	}
	
	public static boolean isValid(String infos[]) {
		boolean isValid = true;
		
		try {
			int number = Integer.parseInt(infos[0]);
			if(number < 0) {
				System.out.println("Numero de rue invalide");
				isValid = false;
			}
		} catch(NumberFormatException e) {
			System.out.println("Numero de rue invalide");
			isValid = false;
		}
		
		if(!infos[1].matches("[a-zA-Z]+")) {
			System.out.println("Nom de rue invalide");
			isValid = false;
		}
		
		return isValid;
	}
	
	public int getStNumber() {
		return stNumber;
	}
	
	public void setStNumber(int stNumber) {
		this.stNumber = stNumber;
	}
	
	public String getStName() {
		return stName;
	}
	
	public void setStName(String stName) {
		this.stName = stName;
	}
	
}