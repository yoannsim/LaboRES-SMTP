# LaboRES-SMTP

## Deliverables

Authors : Yoann Simonet, Julien Rod

#### Description of the project

MailBot is a client application (TCP) in Java. It allows you to send pranks (mail) to a list of victims.

For testing our application safely you can use a mock SMTP server.
  
**Warning**: if you run the application in a real SMTP server you may be identified as a spammer and your IP will be ban. 
 
#### Instructions for setting up a mock SMTP server (with Docker) 

1. install docker machine (https://docs.docker.com/machine/install-machine/).
2. Go in the dockerMockMock folder and build a docker image of the server white this cmd: `docker build -t myMockServerSMPT .` 
3.    run the server:    `docker run -p 8282:8282 -p 25:25`
4.    Start your favorite browser (internet explorer or another) and connect you to the server 
    `192.156.12.100:8282`
5. You are ready for testing your first pranks campaigns !!

#### Clear and simple instructions for configuring your tool and running a prank campaign. 

To deploy our PrankGenerator soft, you must clone our github project (https://github.com/yoannsim/LaboRES-SMTP). For this,
you'll need to have a github account and gitbash command installed in your computer.

If you want to custom the list of pranks, you have to edit the file listePrank.txt, use the same syntax as the samples you'll find there.

If you want to custom the list of your victims, you have to edit the file listeVictime.txt, just add their mail address to this file.


These two files can be found in the src directory.



To run our application, just open a command line and write java -jar LaboRES-SMTP-1.0-SNAPSHOT-launcher.jar.

You can also throw the main method in the MailBot class.



Beware, this application make spam, if you want to use it without problem, you'll need to install and run a mock server 
or use website such as MailTrap (https://mailtrap.io).

#### A description of your implementation document the key aspects of your code. 

It is probably a good idea to start with a class diagram. Decide which classes you want to show (focus on the important ones) and describe their responsibilities in text. It is also certainly a good idea to include examples of dialogues between your client and an SMTP server (maybe you also want to include some screenshots here).
Our code is divided in 4 packages :

###### config

This package contains the ParserConfig class. It's meant to "transform" the configurations files into String[] to be
understandable to our program.

###### mail

This package contains the Group, GroupGenerator and Message Classes.

The Group class define a group one of these member is the seeder and the others the victims.

The GroupGenerator class is here to create all the group of the program (use every time all the mails specified).

The Message class define the mail behaviour (the sender, the receptionists, the subject and the text of the mail).

###### prank

This package is used to define what is a prank and is composed of Prank and PrankGenerator classes.

The Prank class define the prank lines and the victims of this prank (one group).

The PrankGenerator class is here to create all pranks. It generate couples of prank-group. The same
prank can be assigned to more than one group.

###### SMTPclient

This package contains the ClientMail class. This class behaviour is to send emails based
on the prank-group pairs. It's send all victims as "To" ans follow the SMTP protocol standard.

<br><br>


The main class of our application is MailBot whose work as the backbone of this apps. It just bind
all our classes together.



![UML](https://user-images.githubusercontent.com/47739482/56092624-a36ae680-5ebe-11e9-8c32-8ac070e85806.PNG)
