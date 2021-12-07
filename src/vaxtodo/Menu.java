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
		currentUser = login.login();
	}

	public void open() {
		// TODO - implement Menu.open
	}

	public User getCurrentUser() {
		// TODO - implement Menu.getCurrentUser
		return null;
	}
	
	public void setCurrentUser() {
		
	}

	public void displayMenu() {
		// TODO - implement Menu.displayMenu
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
		// TODO - implement Menu.printError
	}

	public void exit() {
		// TODO - implement Menu.exit
	}

}