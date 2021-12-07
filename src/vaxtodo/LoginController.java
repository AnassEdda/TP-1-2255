package vaxtodo;

import java.util.*;

public class LoginController {

	public User login() {
		User user = null;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entrer votre code d'utilisateur");
		String username = scanner.nextLine();
		
		System.out.println("Entrer votre mot de passe");
		String password = scanner.nextLine();
		
		//TODO check if username/password is correct
		
		return user;
	}

	public void logout() {
		// TODO - implement LoginController.logout
	}

	/**
	 * 
	 * @param infos
	 */
	public void createUser(String[] infos) {
		// TODO - implement LoginController.createUser
	}

	/**
	 * 
	 * @param infos
	 */
	public void modifyUser(String[] infos) {
		// TODO - implement LoginController.modifyUser
	}

	/**
	 * 
	 * @param infos
	 */
	public void deleteUser(String[] infos) {
		// TODO - implement LoginController.deleteUser
	}

	/**
	 * 
	 * @param user
	 */
	public User add(User user) {
		// TODO - implement LoginController.add
		return null;
	}

	/**
	 * 
	 * @param user
	 */
	public User modify(User user) {
		// TODO - implement LoginController.modify
		return null;
	}

	/**
	 * 
	 * @param user
	 */
	public User delete(User user) {
		// TODO - implement LoginController.delete
		return null;
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