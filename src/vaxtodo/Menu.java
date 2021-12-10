package vaxtodo;

import java.util.Scanner;

public class Menu {
	
	private User currentUser;
	private LoginController login;
	private ReservationController reservation;
	private VisitorController visitor;
	private UserController user;
	
	public Menu () {
		login = new LoginController();
		reservation = new ReservationController();
		visitor = new VisitorController();
		user = new UserController();
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
		
		Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Changer le compte utilisateur");
            System.out.println("2. Gestion de reservations");
            System.out.println("3. Gestion de visiteurs");
            System.out.println("4. Gestion d'utilisateurs");
            System.out.println("5. Consultation d'informations");
            System.out.println("6. ");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	login.logout();
                	break;
                case 2:
                	displayReservation();
                	break;
                case 3:
                	displayVisitor();
                	break;
                case 4:
                	displayUser();
                	break;
                case 5:
                	displayInfo();
                	break;
                case 6:
                	
                	break;
                case 7:
                	isContinue = false;
                	System.out.println("Fin de session");
                	break;
                default:
                    System.out.println("La valeur entree est invalide");
                    break;

            }

        }
		
	}

	public void displayReservation() {
		Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Creer une reservation");
            System.out.println("2. Supprimer une reservation");
            System.out.println("3. Confirmer une reservation");
            System.out.println("4. Quitter le menu des reservations");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	reservation.createReservation();
                	break;
                case 2:
                	reservation.deleteReservation();
                	break;
                case 3:
                	reservation.confirmReservation();
                	break;
                case 4:
                	isContinue = false;
                	break;
                default : System.out.println("La valeur entree est invalide");
            }
        }
	}

	public void displayVisitor() {
		Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Creer un visiteur");
            System.out.println("2. Supprimer un visiteur");
            System.out.println("3. Modifier un visiteur");
            System.out.println("4. Quitter le menu des visiteurs");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	visitor.createVisitor();
                	break;
                case 2:
                	visitor.deleteVisitor();
                	break;
                case 3:
                	visitor.modifyVisitor();
                	break;
                case 4:
                	isContinue = false;
                	break;
                default : System.out.println("La valeur entree est invalide");
            }
        }
	}
	
	public void displayUser() {
		Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Creer un utilisateur");
            System.out.println("2. Supprimer un utilisateur");
            System.out.println("3. Modifier un utilisateur");
            System.out.println("4. Quitter le menu des utilisateurs");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	user.createUser();
                	break;
                case 2:
                	user.deleteUser();
                	break;
                case 3:
                	user.modifyUser();
                	break;
                case 4:
                	isContinue = false;
                	break;
                default : System.out.println("La valeur entree est invalide");
            }
        }
	}
	
	public void displayInfo() {
		Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Consulter le calendrier");
            System.out.println("2. Consulter la liste des visiteurs");
            System.out.println("3. Consulter la liste des utilisateurs");
            System.out.println("4. Quitter le menu de la consultation d'informations");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	
                	break;
                case 2:
                	
                	break;
                case 3:
                	
                	break;
                case 4:
                	isContinue = false;
                	break;
                default : System.out.println("La valeur entree est invalide");
            }
        }
	}
}