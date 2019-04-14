package ch.heigvd.res.mailbot.mail;
import java.util.ArrayList;
import java.util.Random;

public class GroupGenerator {

    private String[] listePersonne;
    private String[] Groupes;

    //a fair avec un fichier de config en dure pour le moment
    private int tailleMin = 3;
    private int nbGroup;

    public  Group[] generate(String[] listePersonne, int nbGroup){
        this.nbGroup = nbGroup;

        int tailleListe = listePersonne.length;
        int tailleGroup = tailleListe/nbGroup;
        int comteurPresonne =0;
        ArrayList<Group> groups = new ArrayList() ;


        if(tailleListe < (tailleMin * nbGroup))
             throw new IllegalArgumentException("You don't have enougth mail address to make "
                     + nbGroup + " groups.");

        //mélanger la liste de mail 20X
        for(int i = 0;i<20;i++){
            melangerTableau(listePersonne);
        }


      //remplire les groupes en fonction de la config
       for(int i=0; i<nbGroup; i++){
           Group group = new Group();
           group.setEnvoyeur(listePersonne[comteurPresonne++]);
           for(int j =0;j<tailleGroup-1;j++) {
               group.setReceveur(listePersonne[comteurPresonne++]);
           }
           groups.add(group);
       }

       //on met les personnes qui reste dans un group au hasard
       while(comteurPresonne<tailleListe){
           groups.get(nbGroup - 1 ).setReceveur(listePersonne[comteurPresonne++]);
       }


        return groups.toArray(new Group[groups.size()]);
    }

    public static int random(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

    // Mélange un tableau de sring
    private void melangerTableau(String t[]) {
        for (int i = 0; i < t.length; i++) {
            int r = (int) random(0, t.length - 1);
            String tmp = t[i];
            t[i] = t[r];
            t[r] = tmp;
        }
    }


}
