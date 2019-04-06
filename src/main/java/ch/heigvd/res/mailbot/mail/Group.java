package ch.heigvd.res.mailbot.mail;

import java.util.ArrayList;

public class Group {

    private String envoyeur;
    private ArrayList<String> receveurs = new ArrayList<String>();


    public void setEnvoyeur(String envoyeur) {
        this.envoyeur = envoyeur;
    }

    public void setReceveur(String receveur) {
        this.receveurs.add(receveur);
    }

    public String getEnvoyeur() {
        return envoyeur;
    }

    public String[] getReceveurs() {
        return  receveurs.toArray(new String[receveurs.size()]);
    }





}


