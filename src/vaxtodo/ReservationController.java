package vaxtodo;

import java.util.Scanner;

public class ReservationController {

	public void createReservation() {
		
		String[] infos = new String[5];
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nCreation d'une nouvelle reservation");
		
		System.out.println("Entrer le nom de famille du visiteur : ");
		infos[0] = scanner.nextLine();
		
		System.out.println("Entrer le prenom du visiteur : ");
		infos[1] = scanner.nextLine();
		
		System.out.println("Entrer la date de la reservation (AAAA-MM-JJ) : ");
		infos[2] = scanner.nextLine();
		
		System.out.println("Entrer l'heure de la reservation (HH:MM) : ");
		infos[3] = scanner.nextLine();
		
		System.out.println("Numero de dose du vaccin : ");
		infos[4] = scanner.nextLine();
		
		if(Reservation.isValid(infos)) {
			VaxTodo.reservations.add(new Reservation(infos[0], infos[1], infos[2], infos[3], Integer.parseInt(infos[4])));
			System.out.println("Reservation creee");
			return;
		}
		
		System.out.println("Voulez vous reessayer de creer une reservation? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			createReservation();
		}
		return;
	}

	public void deleteReservation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de reservation de la reservation a supprimer (6 chiffres) : ");
		String temp = scanner.nextLine();
		int number = 0;
		
		try {
			number = Integer.parseInt(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de reservation invalide");
			return;
		}
		
		for(Reservation reservation : VaxTodo.reservations) {
			if(reservation.getReservationNumber() == number) {
				VaxTodo.reservations.remove(reservation);
				System.out.println("La reservation a ete supprimee");
				return;
			}
		}
		
		System.out.println("Le numero de reservation n'existe pas");
		System.out.println("Voulez vous reessayer de supprimer une reservation? (OUI/NON)");
		String decision = scanner.nextLine();
		
		if(decision.equals("OUI")) {
			deleteReservation();
		}
		return;
	}

	public void confirmReservation() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEntrer le numero de reservation de la reservation a confirmer (6 chiffres) : ");
		String temp = scanner.nextLine();
		int number = 0;
		
		try {
			number = Integer.parseInt(temp);
		}catch (NumberFormatException e){
			System.out.println("Numero de reservation invalide");
			return;
		}
		
		for(Reservation reservation : VaxTodo.reservations) {
			if(reservation.getReservationNumber() == number) {
				System.out.println("Reservation de " + reservation.getFirstName() + " " + reservation.getLastName());
				System.out.println("Dose #"+ reservation.getDoseNumber() + " qui a lieu le " + reservation.getVisitDate() + " a " + reservation.getVisitTime());
				return;
			}
		}
		System.out.println("Numero de reservation inexistant");
		return;
	}

	public void createReport() {
		
	}

	public void notifyVisitors() {
		
	}
	
	public void reservationList(){
		System.out.println("\nAffichage des informations des reservations");
		
		for (Reservation reservation: VaxTodo.reservations){
			
			System.out.println(reservation.getFirstName() + " " + reservation.getLastName() + ", le " + reservation.getVisitDate() + " a " 
					+ reservation.getVisitTime() + " pour une " + String.valueOf(reservation.getDoseNumber()) + "e dose");

		}
	}

}