package ch.heigvd.res.mailbot.prank;

import ch.heigvd.res.mailbot.mail.Group;
import ch.heigvd.res.mailbot.mail.Message;

public class Prank {
    Group group;
    String blague;

    public Prank( Group group,String blague){
        this.blague = "";
        this.blague = blague;
        this.group = group;
    }

    public Message getMail(){

        Message mail = new Message();
        mail.setFrom(group.getEnvoyeur());
        mail.setTo(group.getReceveurs());
        mail.setSubject(blague.substring(0,blague.indexOf("\n")));
        mail.setData(blague);



        return mail;
    }




}
