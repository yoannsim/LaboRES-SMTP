package ch.heigvd.res.mailbot.config;



import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;



public class ParserConfigTest {


    @Test
    public void getListeVictimeTest() {
        ParserConfig p = null;
        try {
            p = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt","src/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        assert("yoann.simonet95@gmail.com".contains(p.getListeVictime()[0]));

    }



    @Test
    public void getListePrankTest() {
        ParserConfig p = null;
        try {
            p = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt","src/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
