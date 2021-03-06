package ch.heigvd.res.mailbot.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

public class ParserConfig {
    private String[] listeVictime;
    private String[] listePrank;
    ArrayList<String> lines = new ArrayList() ;

    private Properties prop = new Properties();

    public ParserConfig(String pathPrank,String pathVictime,String pathConf) throws FileNotFoundException, UnsupportedEncodingException {
        BufferedReader readerPrank = new BufferedReader (new InputStreamReader(new FileInputStream(pathPrank), "UTF-8"));
        BufferedReader readerVictime = new BufferedReader (new InputStreamReader(new FileInputStream(pathVictime), "UTF-8"));

        //read victime

        try{
            String line;
            while((line = readerVictime.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        listeVictime = lines.toArray(new String[lines.size()]);
        lines.clear();


        //read prank

        try{
            String line;
            String prank = "";
            while((line = readerPrank.readLine()) != null) {
                if(line.compareTo("***")==0){
                    lines.add(prank);
                    prank = "";
                }
                else{
                    prank +=  line + "\n";

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listePrank = lines.toArray(new String[lines.size()]);
        lines.clear();

        try {
            FileInputStream input = new FileInputStream(pathConf);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String[] getListeVictime() {
        return listeVictime;
    }

    public String[] getListePrank() {
        return listePrank;
    }

    public String getServer() { return prop.getProperty("smtpServerAddress");}

    public int getServerPort(){ return Integer.parseInt(prop.getProperty("smtpServerPort"));}

    public int getNbGroup(){ return Integer.parseInt(prop.getProperty("numberOfGroup"));}

    public String getWitnessToCC(){ return prop.getProperty("witnessToCC");}







}
