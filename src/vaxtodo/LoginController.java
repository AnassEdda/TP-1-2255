package vaxtodo;

import java.util.*;

public class LoginController {

	public User login() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entrer votre code d'utilisateur : ");
		long code;
		try {
			code = scanner.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Le code d'utilisateur dois etre un nombre");
			return login();
		}
		
		System.out.println("Entrer votre mot de passe : ");
		scanner.nextLine();
		String password = scanner.nextLine();
		
		for(User user : VaxTodo.users) {
			if(user.getPassword().equals(password) && user.getUserCode() == code) {
				System.out.println("Connexion reussie");
				return user;
			}
		}
		System.out.println("Code d'utilisateur ou mot de passe invalide");
		return login();
	}

	public void logout() {
		System.out.println("Utilisateur deconnecte");
		login();
	}

	/**
	 * 
	 * @param infos
	 */
	public void createUser() {
		Scanner scanner = new Scanner(System.in);
	}

	/**
	 * 
	 * @param infos
	 */
	public void modifyUser() {
		Scanner scanner = new Scanner(System.in);
	}

	/**
	 * 
	 * @param infos
	 */
	public void deleteUser() {
		Scanner scanner = new Scanner(System.in);
	}

	/**
	 * 
	 * @param infos
	 */
	public User find(String[] infos) {
		// TODO - implement LoginController.find
		return null;
	}

}