package ch.heigvd.res.mailbot.prank;

import ch.heigvd.res.mailbot.mail.Group;

import java.util.ArrayList;

import static ch.heigvd.res.mailbot.mail.GroupGenerator.random;

public class PrankGenerator {

    public  Prank[] generate(Group[] listeGroup,String[] listeBlague) {

        ArrayList<Prank> Pranks = new ArrayList();

        for (Group g : listeGroup) {
            Pranks.add(new Prank(g, listeBlague[(int) random(0, listeBlague.length)]));
        }

        return Pranks.toArray(new Prank[Pranks.size()]);
    }

}
