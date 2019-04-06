package ch.heigvd.res.mailbot.mail;
import java.util.ArrayList;

public class GroupGenerator {

    private String[] listePersonne;
    private String[] Groupes;

    //a fair avec un fichier de config
    private int tailleMin = 3;
    private int nbGroup = 4;

    public   Group[] generate(String[] listePersonne){

        int tailleListe = listePersonne.length;
        int tailleGroup = tailleListe/nbGroup;
        int comteurPresonne =0;
        ArrayList<Group> groups = new ArrayList() ;


        if(tailleListe < (tailleMin * nbGroup))
             return null;

        for(int i =0;i<20;i++)
            melangerTableau(listePersonne);

       for(int i=0; i<nbGroup; i++){
           Group group = new Group();
           group.setEnvoyeur(listePersonne[comteurPresonne++]);
           for(int j =0;j<tailleGroup-1;j++) {
               group.setReceveur(listePersonne[comteurPresonne++]);
           }
           groups.add(group);
       }

       //on met les personne qui reste dans un group au hasard
       while(comteurPresonne<tailleListe){
           groups.get(nbGroup - 1 ).setReceveur(listePersonne[comteurPresonne++]);
       }


        return groups.toArray(new Group[groups.size()]);
    }

    private static double random(double min, double max) {
        return min + Math.random() * (max - min);
    }

    // Mélange un tableau
    private void melangerTableau(String t[]) {
        for (int i = 0; i < t.length; i++) {
            int r = (int) random(0, t.length);
            String tmp = t[i];
            t[i] = t[r];
            t[r] = tmp;
        }
    }


}
