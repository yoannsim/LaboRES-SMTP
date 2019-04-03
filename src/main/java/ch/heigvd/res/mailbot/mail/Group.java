package ch.heigvd.res.mailbot.mail;

public class Group {

    private String envoyeur;
    private String[] receveurs;

    public Group (String envoi,String ... reciver){
        envoyeur = envoi;
        receveurs = reciver;
    }

    public String getEnvoyeur() {
        return envoyeur;
    }

    public String[] getReceveurs() {
        return receveurs;
    }




}


