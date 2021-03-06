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
import java.util.logging.Logger;

public class MailBot {
    private static ParserConfig config;
    private static Group[] groups;
    private static Prank[] pranks;
    private static ClientMail client;
    private static final Logger LOG = Logger.getLogger(MailBot.class.getName());
    public static void main(String[] args)
    {

        try {
            config = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt","src/config.properties");
            LOG.info("ip serveur:" + config.getServer() +"\n");
            client = new ClientMail(config.getServer(), config.getServerPort());
            groups = new GroupGenerator().generate(config.getListeVictime(), config.getNbGroup());
            pranks = new PrankGenerator().generate(groups, config.getListePrank());
            for(Prank p : pranks){
                LOG.info("mail:" + p.getMail().getFrom() +"\n");
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
