package vaxtodoo;

public class ReservationController {
    int jour;
    int heure;
    int numReservation;
    public void reservationVerify(int numReservation){
        int lenghtreservation = String.valueOf(numReservation).length();
        if(lenghtreservation==9){
            if(numReservation<500000000 && numReservation>100000000){
                System.out.println("vous avez une réservation aujourd'hui a 11h");
            }else {
                System.out.println("vous n'avez pas de réservation aujourd'hui et il n'y a plus de diponibilité");
            }


        }
        else {
            System.out.println("le numéro doit contenir 9 chiffres");
        }
    }


    public void createReservation(int jour,int heure ){

        if (jour>7&&jour<26){
            System.out.println("jour disponible");

        }else{System.out.println("choisissez un autre jour");}

        if (heure<24&&heure>0){
            System.out.println("heure disponible votre RDV est enregistré votre numéro de réservation est le 676767676");
        }else {
            System.out.println("heure indisponible ou impossible");
        }



    }
}
