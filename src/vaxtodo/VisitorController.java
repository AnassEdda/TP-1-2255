package vaxtodo;

import java.util.ArrayList;
import java.util.Scanner;

public class VisitorController {

	public void createVisitor() {
		
		String[] infos = new String[8];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nCreation d'un nouveau visiteur");
		
		System.out.println("Entrer le nom de famille du visiteur : ");
		infos[0] = scanner.nextLine();
		
		System.out.println("Entrer le prenom du visiteur : ");
		infos[1] = scanner.nextLine();
		
		System.out.println("Entrer la date de naissance du visiteur (AAAA-MM-JJ) : ");
		infos[2] = scanner.nextLine();
		
		System.out.println("Entrer l'adresse courriel du visiteur : ");
		infos[3] = scanner.nextLine();
		
		System.out.println("Entrer le numero de rue du visiteur : ");
		String stNumber = scanner.nextLine();
		System.out.println("Entrer le nom de rue du visiteur : ");
		String stName = scanner.nextLine();
		
		infos[4] = stNumber + "," + stName;
		
		System.out.println("Entrer le code postal du visiteur : ");
		infos[5] = scanner.nextLine();
		
		System.out.println("Entrer la ville de residence du visiteur : ");
		infos[6] = scanner.nextLine();
		
		System.out.println("Entrer le numero de telephone du visiteur : ");
		infos[7] = scanner.nextLine();
		
		if(Visitor.isValid(infos)) {
			VaxTodo.visitors.add(new Visitor(infos[0], infos[1], infos[2], infos[3], new Address(infos[4]), infos[5], infos[6], Long.parseLong(infos[7])));
			System.out.println("Visiteur cree");
			return;
		}
		
		System.out.println("Voulez vous reessayer de creer un visiteur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			createVisitor();
		}
		return;
	}
	
	public void modifyVisitor() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de compte du visiteur a modifier : ");
		String temp = scanner.nextLine();
		long number = 0;
		
		try {
			number = Long.parseLong(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de compte du visiteur invalide");
			return;
		}
		
		for(Visitor visitor : VaxTodo.visitors) {
			if(visitor.getAccountNumber() == number) {
				visitor = modifyInfo(visitor);
				return;
			}
		}
		
		System.out.println("Le numero de compte du visiteur n'existe pas");
		System.out.println("Voulez vous reessayer de supprimer un visiteur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			deleteVisitor();
		}
		return;
	}

	public void deleteVisitor() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de compte du visiteur a supprimer : ");
		String temp = scanner.nextLine();
		long number = 0;
		
		try {
			number = Long.parseLong(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de compte du visiteur invalide");
			return;
		}
		
		for(Visitor visitor : VaxTodo.visitors) {
			if(visitor.getAccountNumber() == number) {
				VaxTodo.visitors.remove(visitor);
				System.out.println("Le visiteur a ete supprime");
				return;
			}
		}
		
		System.out.println("Le numero de compte du visiteur n'existe pas");
		System.out.println("Voulez vous reessayer de supprimer un visiteur? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			deleteVisitor();
		}
		return;
	}
	
	public Visitor modifyInfo(Visitor visitor) {
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
            System.out.println("9. Quitter le menu de modification");
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
            			return visitor;
            		}
                	visitor.setLastName(newInfo);
                	System.out.println("Nom de famille modifie avec succes");
                	return visitor;
                	
                case 2:
                	
                	System.out.println("Entrer le nouveau prenom");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	if(!newInfo.matches("[a-zA-Z]+")) {
            			System.out.println("Prenom invalide");
            			return visitor;
            		}
                	visitor.setFirstName(newInfo);
                	System.out.println("Prenom modifie avec succes");
                	return visitor;
                	
                case 3:
                	
                	System.out.println("Entrer la nouvelle adresse courriel");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	String[] emailVerif = newInfo.split("@");
            		if(emailVerif.length != 2) {
            			System.out.println("Adresse courriel invalide");
            			return visitor;
            		}
            		visitor.setEmail(newInfo);
            		System.out.println("Adresse courriel modifiee avec succes");
            		return visitor;
            		
                case 4:
                	
                	System.out.println("Entrer le nouveau numero de telephone");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	if(newInfo.length() != 10) {
                		System.out.println("Numero de telephone invalide");
                		return visitor;
                	}
                	visitor.setPhoneNumber(Long.parseLong(newInfo));
                	System.out.println("Numero de telephone modifie avec succes");
                	return visitor;
                	
                case 5:
                	
                	String[] newInfos = new String[2];
                	System.out.println("1. Entrer le numero de rue");
                	scanner.nextLine();
                	newInfos[0] = scanner.nextLine();
                	System.out.println("1. Entrer le nom de rue");
                	newInfos[1] = scanner.nextLine();
                	
                	if(!Address.isValid(newInfos)) return visitor;
                	
                	visitor.setAddress(new Address(Integer.parseInt(newInfos[0]), newInfos[1]));
                	System.out.println("Adresse modifiee avec succes");
                	return visitor;
                	
                case 6:
                	
                	System.out.println("Entrer le nouveau code postal");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	if(newInfo.length() != 6) {
                		System.out.println("Code postal invalide");
                		return visitor;
                	}
                	visitor.setPostalCode(newInfo);
                	System.out.println("Code postal modifie avec succes");
                	return visitor;
                	
                case 7:
                	
                	System.out.println("Entrer la nouvelle ville");
                	scanner.nextLine();
                	newInfo = scanner.nextLine();
                	
                	if(!newInfo.matches("[a-zA-Z]+")) {
            			System.out.println("Ville invalide");
            			return visitor;
            		}
                	visitor.setCity(newInfo);
                	System.out.println("Ville modifiee avec succes");
                	return visitor;
                	
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
            				return visitor;
            			}
            		} catch(NumberFormatException e) {
            			System.out.println("Date de naissance invalide");
            			return visitor;
            		}
                	visitor.setBirthdate(newInfo);
                	System.out.println("Date de naissance modifiee avec succes");
                	return visitor;
                	
                case 9:
                	isContinue = false;
                	return visitor;
                default : System.out.println("La valeur entree est invalide");
            }
        }
		
		return visitor;
	}

	public void visitorList(){
		
		System.out.println("\nAffichage des informations des visiteurs");
		
		for (Visitor visitor: VaxTodo.visitors){
			int nVaccines = 0;
			for(Vaccine vax : visitor.getVaccines()) {
				if(vax == null) break;
				nVaccines++;
			}
			
			System.out.println(visitor.getFirstName() + " " + visitor.getLastName() + ", " + visitor.getEmail() + ", numero de telephone : " 
														+ visitor.getPhoneNumber() + ", nombre de doses : " + nVaccines);

		}

	}

}