package ch.heigvd.res.mailbot.config;



import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class ParserConfigTest {


    @Test
    public void getListeVictimeTest() {
        ParserConfig p = null;
        try {
            p = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        assertEquals("yoann.simonet95@gmail.com",p.getListeVictime()[0]);

    }



    @Test
    public void getListePrankTest() {
        ParserConfig p = null;
        try {
            p = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        assertEquals("Quel est le point commun entre un gynecologue myope et un chien en bonne sante ?\n" +
                "\n" +
                "Ils ont tous les deux le nez mouille.\n",p.getListePrank()[0]);
    }
}
