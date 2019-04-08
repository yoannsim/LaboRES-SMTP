//Plus ou moins recopié de https://www.youtube.com/watch?v=OrSdRCt_6YQ&list=PLfKkysTy70Qa1IYbV9Xndojc7L-T4keF-&index=22
// à partir de 15:55
package ch.heigvd.res.mailbot.SMTPclient;

import ch.heigvd.res.mailbot.mail.Message;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientMail {
    private static final Logger LOG = Logger.getLogger(ClientMail.class.getName());
    private String smtpServerAddress;
    private int portServer;

    private PrintWriter pw;
    private BufferedReader br;
    private Socket socket;

    /**
     * @brief Constructeur de la connexion SMTP du côté du client
     * @param smtpServerAddress L'adresse du serveur SMTP
     * @param portServer Le port utilisé par le serveur SMTP
     */
    public ClientMail(String smtpServerAddress, int portServer){
        this.smtpServerAddress = smtpServerAddress;
        this.portServer = portServer;
    }

    /**
     * @brief Envoye nos pranks à une liste de clients aléatoires
     * @param message Contient le faux envoyeur, la liste des victimes, le titre du message et la prank
     * @throws IOException
     */
    public void send(Message message) throws IOException {
        LOG.info("Send a message to the server.");

        socket = new Socket(smtpServerAddress, portServer);
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        //Attente d'un contact du serveur SMTP
        String l = br.readLine();
        LOG.info(l);

        //Début du protocol SMTP
        pw.write("EHLO something");
        pw.write("\r\n");
        pw.flush();

        //Réponse du serveur SMTP
        l = br.readLine();
        LOG.info(l);
        if(!l.startsWith("250")){
            throw new IOException("SMTP Error" + l);
        }
        while(l.startsWith("250-")){
            LOG.info(l);
            l = br.readLine();
        }

        //Partie du faux envoyeur
        pw.write("MAIL FROM: ");
        pw.write(message.getFrom());
        pw.write("\r\n");
        pw.flush();

        //Réponse du serveur SMTP
        l = br.readLine();
        LOG.info(l);

        //Partie des victimes
        for(String victime : message.getTo()){
            pw.write("RCPT TO: ");
            pw.write(victime);
            pw.write("\r\n");
            pw.flush();

            //Réponse du serveur
            l = br.readLine();
            LOG.info(l);
        }

        //On a pas de cc (nous avions décidé de mettre toutes les victimes en TO).

        //Partie d'initialisation du corps du texte
        pw.write("DATA");
        pw.write("\r\n");
        pw.flush();

        //Réponse du serveur
        l = br.readLine();
        LOG.info(l);

        //On rentre le corps du texte
        pw.write("Content-Type: text/plain; charset=\"UTF-8\"\r\n");
        //Le faux envoyeur
        pw.write("From: " + message.getFrom() + "\r\n");
        //Les victimes
        pw.write("To: ");
        int pos = 1;
        for(String victime : message.getTo()){
            pw.write(victime);
            if(!(pos++ == message.getTo().length)){
                pw.write(", ");
            }
        }
        pw.write("\r\n");
        //Le sujet
        pw.write("Subject: " + message.getSubject() + "\r\n\r\n");
        pw.flush();

        LOG.info("Prank: " + message.getData());

        //Suite du corps du texte
        pw.write(message.getData() + "\r\n.\r\n");
        pw.flush();

        //Attente de la confirmation du serveur SMTP
        l = br.readLine();
        LOG.info(l);

        //On ferme nos variable
        br.close();
        pw.close();
        socket.close();
    }
}
