package vaxtodo;

public class Menu {
	
	private User currentUser;
	private LoginController login;
	private ReservationController reservation;
	private VisitorController visitor;
	
	public Menu () {
		login = new LoginController();
		reservation = new ReservationController();
		visitor = new VisitorController();
	}

	public void open() {
		currentUser = login.login();
		displayMenu();
	}

	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}

	public void displayMenu() {
		
		
		
	}

	public void displayLogin() {
		// TODO - implement Menu.displayLogin
	}

	public void displayReservation() {
		// TODO - implement Menu.displayReservation
	}

	public void displayVisitor() {
		// TODO - implement Menu.displayVisitor
	}

	/**
	 * 
	 * @param msg
	 */
	public void printError(String msg) {
		System.out.println(msg);
	}

	public void exit() {
		// TODO - implement Menu.exit
	}

}