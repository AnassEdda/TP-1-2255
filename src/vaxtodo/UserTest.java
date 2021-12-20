package vaxtodo;

public class UserTest {
	
	public void runTests() {
		testValid();
		testValidFail();
	}
	
	public void testValid() {
		String[] infos = {"Qazwsx123@","Achard","Fred","2000-02-06","frederic.achard-groleau@umontreal.ca","1600,Pennsylvania","20500","Washington","6038320277","NON"};
		
		System.out.println(User.isValid(infos));
	}
	
	public void testValidFail() {
		String[] infos = {"Bonjour","Achard","Fr_d","2000/02/06","frederic.achard-groleauatumontreal.ca","16oo,Pennsylvania","20_500","Washington","(603)832-0277","AHH"};
		
		System.out.println(User.isValid(infos));
	}
}
