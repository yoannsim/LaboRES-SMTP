package ch.heigvd.res.mailbot.mail;

import ch.heigvd.res.mailbot.config.ParserConfig;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;




class GroupGeneratorTest {
    private static final Logger LOG = Logger.getLogger(GroupGeneratorTest.class.getName());
    @Test
    void generate() {
        ParserConfig config = null;
        Group[] listeGroup;
        try {
            config = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        GroupGenerator gene = new GroupGenerator();

        listeGroup = gene.generate(config.getListeVictime());

        assert(4==listeGroup.length);

        String affichage = "";
        for(Group g : listeGroup){
            affichage += "envoieur =" +  g.getEnvoyeur()+"\n";
            affichage += "receveur: \n";
            for(String p:g.getReceveurs()){
                affichage += p + " \n";
            }
            affichage += "\n *****************\n";
        }
        LOG.info(affichage);

    }
}