package vaxtodo;

import java.util.*;

public class UserController {

	public void createUser() {
		
		String[] infos = new String[10];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nCreation d'un nouvel utilisateur");
		
		System.out.println("Entrer le mot de passe du compte de l'utilisateur : ");
		infos[0] = scanner.nextLine();
		
		System.out.println("Entrer le nom de famille de l'utilisateur : ");
		infos[1] = scanner.nextLine();
		
		System.out.println("Entrer le prenom de l'utilisateur: ");
		infos[2] = scanner.nextLine();
		
		System.out.println("Entrer la date de naissance de l'utilisateur (AAAA-MM-JJ) : ");
		infos[3] = scanner.nextLine();
		
		System.out.println("Entrer l'adresse courriel de l'utilisateur : ");
		infos[4] = scanner.nextLine();
		
		System.out.println("Entrer le numero de rue de l'utilisateur : ");
		String stNumber = scanner.nextLine();
		System.out.println("Entrer le nom de rue de l'utilisateur : ");
		String stName = scanner.nextLine();
		
		infos[5] = stNumber + "," + stName;
		
		System.out.println("Entrer le code postal de l'utilisateur : ");
		infos[6] = scanner.nextLine();
		
		System.out.println("Entrer la ville de residence de l'utilisateur : ");
		infos[7] = scanner.nextLine();
		
		System.out.println("Entrer le numero de telephone de l'utilisateur : ");
		infos[8] = scanner.nextLine();
		
		System.out.println("L'utilisateur est-il un employe? (OUI/NON) : ");
		infos[9] = scanner.nextLine();
		
		if(User.isValid(infos)) {
			VaxTodo.users.add(new User(infos[0], infos[1], infos[2], infos[3], infos[4], new Address(infos[5]), infos[6], infos[7], Long.parseLong(infos[8]), infos[9]));
			System.out.println("Utilisateur cree");
			return;
		}
		
		System.out.println("Voulez vous reessayer de creer un utilisateur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			createUser();
		}
		return;
	}
	
	public void modifyUser() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de compte de l'utilisateur a modifier : ");
		String temp = scanner.nextLine();
		long number = 0;
		
		try {
			number = Long.parseLong(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de compte du visiteur invalide");
			return;
		}
		
		for(User user : VaxTodo.users) {
			if(user.getAccountNumber() == number) {
				user = modifyInfo(user);
				return;
			}
		}
		
		System.out.println("Le numero de compte de l'utilisateur n'existe pas");
		System.out.println("Voulez vous reessayer de modifier un utilisateur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			deleteUser();
		}
		return;
	}

	public void deleteUser() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de compte de l'utilisateur a supprimer : ");
		String temp = scanner.nextLine();
		long number = 0;
		
		try {
			number = Long.parseLong(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de compte de l'utilisateur invalide");
			return;
		}
		
		for(User user : VaxTodo.users) {
			if(user.getAccountNumber() == number) {
				VaxTodo.users.remove(user);
				System.out.println("Le compte de " + user.getFirstName() + " " + user.getLastName() + " a ete supprime");
				return;
			}
		}
		
		System.out.println("Le numero de compte de l'utilisateur n'existe pas");
		System.out.println("Voulez vous reessayer de supprimer un utilisateur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			deleteUser();
		}
		return;
	}
	
	public User modifyInfo(User user) {
		
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		
		while (isContinue) {
            System.out.println("\n1. Quelle information souhaitez vous changer?");
            System.out.println("1. Nom de famille");
            System.out.println("2. Prenom");
            System.out.println("3. Adresse courriel");
            System.out.println("4. Numero de telephone");
            System.out.println("5. Adresse");
            System.out.println("6. Code postal");
            System.out.println("7. Ville de residence");
            System.out.println("8. Date de naissance");
            System.out.println("9. Mot de passe");
            System.out.println("10. Quitter le menu de modification");
            System.out.print("Choisissez une option : ");

            int choice = scanner.nextInt();
            String newInfo = null;
            
            switch (choice) {
                case 1:
                	
                	System.out.println("Entrer le nouveau nom de famille");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	if(!newInfo.matches("[a-zA-Z]+")) {
            			System.out.println("Nom de famille invalide");
            			return user;
            		}
                	user.setLastName(newInfo);
                	System.out.println("Nom de famille modifie avec succes");
                	return user;
                	
                case 2:
                	
                	System.out.println("Entrer le nouveau prenom");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	if(!newInfo.matches("[a-zA-Z]+")) {
            			System.out.println("Prenom invalide");
            			return user;
            		}
                	user.setFirstName(newInfo);
                	System.out.println("Prenom modifie avec succes");
                	return user;
                	
                case 3:
                	
                	System.out.println("Entrer la nouvelle adresse courriel");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	String[] emailVerif = newInfo.split("@");
            		if(emailVerif.length != 2) {
            			System.out.println("Adresse courriel invalide");
            			return user;
            		}
            		user.setEmail(newInfo);
            		System.out.println("Adresse courriel modifiee avec succes");
            		return user;
            		
                case 4:
                	
                	System.out.println("Entrer le nouveau numero de telephone");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	if(newInfo.length() != 10) {
                		System.out.println("Numero de telephone invalide");
                		return user;
                	}
                	user.setPhoneNumber(Long.parseLong(newInfo));
                	System.out.println("Numero de telephone modifie avec succes");
                	return user;
                	
                case 5:
                	
                	String[] newInfos = new String[2];
                	System.out.println("1. Entrer le numero de rue");
                	scanner.nextLine();
                	newInfos[0] = scanner.nextLine();
                	System.out.println("1. Entrer le nom de rue");
                	newInfos[1] = scanner.nextLine();
                	
                	if(!Address.isValid(newInfos)) return user;
                	
                	user.setAddress(new Address(Integer.parseInt(newInfos[0]), newInfos[1]));
                	System.out.println("Adresse modifiee avec succes");
                	return user;
                	
                case 6:
                	
                	System.out.println("Entrer le nouveau code postal");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	if(newInfo.length() != 6) {
                		System.out.println("Code postal invalide");
                		return user;
                	}
                	user.setPostalCode(newInfo);
                	System.out.println("Code postal modifie avec succes");
                	return user;
                	
                case 7:
                	
                	System.out.println("Entrer la nouvelle ville");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	if(!newInfo.matches("[a-zA-Z]+")) {
            			System.out.println("Ville invalide");
            			return user;
            		}
                	user.setCity(newInfo);
                	System.out.println("Ville modifiee avec succes");
                	return user;
                	
                case 8: 
                	
                	System.out.println("Entrer la nouvelle date de naissance (AAAA:MM:JJ)");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	try {
            			String[] date = newInfo.split("-");
            			int[] dateInt = new int[date.length];
            			for(int i = 0; i < date.length; ++i) {
            				dateInt[i] = Integer.parseInt(date[i]);
            			}
            			if(date.length != 3 || dateInt[2] < 1 || dateInt[2] > 31 || dateInt[1] < 1 || dateInt[1] > 12 || dateInt[0] > 2021) {
            				System.out.println("Date de naissance invalide");
            				return user;
            			}
            		} catch(NumberFormatException e) {
            			System.out.println("Date de naissance invalide");
            			return user;
            		}
                	user.setBirthdate(newInfo);
                	System.out.println("Date de naissance modifiee avec succes");
                	return user;
                	
                case 9:
                	System.out.println("Entrer le nouveau mot de passe");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	//TODO Verifier que le nouveau mot de passe est valide
                	
                	user.setPassword(newInfo);
                	System.out.println("Mot de passe avec succes");
                	return user;
                	
                case 10:
                	isContinue = false;
                	return user;
                default : System.out.println("La valeur entree est invalide");
            }
        }
		return user;
	}

	public void userList(){
		System.out.println("\nAffichage des informations des utilisateurs");
		
		for (User user: VaxTodo.users){
			
			String nextShift = "";
			
			if(user.getSchedule() == null) {
				nextShift = "aucun quart de travail planifie";
			}else {
				nextShift = "prochain quart de travail : " + user.getSchedule()[0].getDate() + ", de " 
							+ user.getSchedule()[0].getStartTime() + " a " + user.getSchedule()[0].getEndTime();
			}
			
			System.out.println(user.getFirstName() + " " + user.getLastName() + ", " + user.getEmail() + ", numero de telephone : " 
														+ user.getPhoneNumber() + ", " + nextShift);

		}
	}
	
}
