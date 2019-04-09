package ch.heigvd.res.mailbot.prank;


import ch.heigvd.res.mailbot.config.ParserConfig;
import ch.heigvd.res.mailbot.mail.Group;
import ch.heigvd.res.mailbot.mail.GroupGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;



class PrankGeneratorTest {
    private static final Logger LOG = Logger.getLogger(PrankGeneratorTest.class.getName());

    private Group[] listeGroup;
    private String[] ListeBlague;


    @BeforeEach
    void setUp() {
        ParserConfig config = null;
        try {
            config = new ParserConfig("src/listePrank.txt", "src/listeVictime.txt","src/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        GroupGenerator gene = new GroupGenerator();

        listeGroup = gene.generate(config.getListeVictime(), 4);
        ListeBlague = config.getListePrank();
    }

    @Test
    void generate() {

        PrankGenerator generator = new PrankGenerator();

        Prank[] pranks = generator.generate(listeGroup,ListeBlague);

        assert(pranks.length ==listeGroup.length);

        LOG.info(pranks[0].getMail().getData());
        LOG.info(pranks[1].getMail().getData());
        LOG.info(pranks[2].getMail().getData());
        LOG.info(pranks[3].getMail().getData());

    }

    @Test
    void MailFormatTest() {

        PrankGenerator generator = new PrankGenerator();

        Prank[] pranks = generator.generate(listeGroup,ListeBlague);

        assert(pranks.length ==listeGroup.length);

        LOG.info(pranks[0].getMail().getData());
        LOG.info(pranks[1].getMail().getData());
        LOG.info(pranks[2].getMail().getData());
        LOG.info(pranks[3].getMail().getData());

    }








}