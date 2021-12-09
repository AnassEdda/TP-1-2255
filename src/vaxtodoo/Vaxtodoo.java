package vaxtodoo;

import java.util.Scanner;

public class Vaxtodoo {
    public static void main(String[] args) {
        User user = new User();
        ReservationController reservationController=new ReservationController();
        VisitorController visitorController=new VisitorController();
        menu(user,reservationController,visitorController);

    }



    static void menu(User user,ReservationController reservationController,VisitorController visitorController) {
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("\n1. Se Connectez/creer un compte");
            System.out.println("2. Afficher Rendez-vous");
            System.out.println("3. Afficher visiteurs");
            System.out.println("4. Faire une réservation");
            System.out.println("5. quittez");
            System.out.print("choisissez une option : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Entrez votre numéro de compte");
                    int numCompte = scanner.nextInt();
                    System.out.print("Entrez votre mot de passe");
                    int numMotDePasse = scanner.nextInt();


                    user.verifyNumPasse(numCompte,numMotDePasse);
                    break;


                case 2:
                    System.out.println("rentrez votre numéro de réservation:");
                    int numDeReservation = scanner.nextInt();
                    reservationController.reservationVerify(numDeReservation);
                    break;


                case 3:
                    System.out.println("Entrez nom du visiteur");
                    String nomVisiteur =scanner.next();

                    visitorController.verifyVisitor(nomVisiteur);
                    break;


                case 4:
                    System.out.println("choisissez un jour");
                    int jour = scanner.nextInt();
                    System.out.println("choisissez une heure");
                    int heure = scanner.nextInt();
                    reservationController.createReservation(jour,heure);
                    break;

                case 5:
                    System.out.println("Au revoir!");
                    isContinue = false;
                    break;
                default:
                    System.out.println("choisissez une valeur entre 1 et 5");
                    break;

            }

        }
    }

}
