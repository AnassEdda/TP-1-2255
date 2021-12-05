package vaxtodoo;

import java.util.ArrayList;
import java.util.List;

public class VisitorController {
    public String nom;
    private String lastName;
    private String adresse;
    private String city;
    private String email;
    private int phoneNum;
    private boolean premiereDose;
    private boolean deuxiemeDose;
    private boolean symptomeCovid;
    private boolean allergie;


    public void verifyVisitor(String nom){
        //arrayList
        ArrayList<String> people = new ArrayList<String>();
        people.add("adam");
        people.add("nick");
        if(people.contains(nom)){
            System.out.println("Vous etes identifier");

        }else {
            System.out.println("veuillez créez un comptre ou vous connectez");
        }



    }

}
