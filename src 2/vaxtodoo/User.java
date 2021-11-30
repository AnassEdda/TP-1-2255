package vaxtodoo;

import java.util.Scanner;

public class User {
    private int numCompte;
    private int numMotDePasse;
    private String nom;
    private String lastName;
    private String adresse;
    private String city;
    private String email;
    private int phoneNum;

    public void verifyNumPasse(int numCompte, int numMotDePasse){
        int lenghtcompte = String.valueOf(numCompte).length();
        int lenghtpasse = String.valueOf(numMotDePasse).length();
        if(lenghtcompte==12){
            System.out.println("numero de compte valide");
        }
        else{
            System.out.println("numero de compte invalide");
        }
        if(lenghtpasse==9){
            System.out.println("mot de passe valide");
        }
        else{
            System.out.println("mot de passe invalide");
        }


    }




}
