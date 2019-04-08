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
        mail.setData(blague);
        mail.setSubject("Ma blague prefere");


        return mail;
    }




}
