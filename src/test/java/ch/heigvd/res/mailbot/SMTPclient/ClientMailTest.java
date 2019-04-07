package ch.heigvd.res.mailbot.SMTPclient;

import ch.heigvd.res.mailbot.mail.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ClientMailTest {
    private ClientMail mocklocale;

    @BeforeEach
    void setUp() {

        mocklocale = new ClientMail("127.0.0.1",25);
    }

    @Test
    void send() {

        Message MailTest = new Message();
        MailTest.setFrom("yoann.simonet@test.ch");
        MailTest.setTo(new String[]{"juju.test@test1.ch","juju.test@test2.ch"});
        MailTest.setSubject("Test1");
        MailTest.setData("hello my guy\r\n");
        try {
            mocklocale.send(MailTest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}