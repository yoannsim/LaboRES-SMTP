package ch.heigvd.res.mailbot;

import ch.heigvd.res.mailbot.SMTPclient.ClientMail;
import ch.heigvd.res.mailbot.config.ParserConfig;
import ch.heigvd.res.mailbot.mail.Group;
import ch.heigvd.res.mailbot.mail.GroupGenerator;
import ch.heigvd.res.mailbot.prank.Prank;
import ch.heigvd.res.mailbot.prank.PrankGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MailBot {
    private static ParserConfig config;
    private static Group[] groups;
    private static Prank[] pranks;
    private static ClientMail client;

    public static void main(String[] args)
    {

        try {
            client = new ClientMail("127.0.0.1", 2525);
            config = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt");
            groups = new GroupGenerator().generate(config.getListeVictime());
            pranks = new PrankGenerator().generate(groups, config.getListePrank());
            for(Prank p : pranks){
                client.send(p.getMail());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
