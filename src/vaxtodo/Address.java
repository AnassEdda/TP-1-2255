package vaxtodo;

public class Address {

	private String stNumber;
	private String stName;
	private String postalCode;
	private Province province;
	private String country;
	private String city;
	
	public Address(String stNumber, String stName, String postalCode, Province province, String country, String city) {
		this.stNumber = stNumber;
		this.stName = stName;
		this.postalCode = postalCode;
		this.province = province;
		this.country = country;
		this.city = city;
	}
	
	public String getStNumber() {
		return stNumber;
	}
	
	public void setStNumber(String stNumber) {
		this.stNumber = stNumber;
	}
	
	public String getStName() {
		return stName;
	}
	
	public void setStName(String stName) {
		this.stName = stName;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Province getProvince() {
		return province;
	}
	
	public void setProvince(Province province) {
		this.province = province;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}