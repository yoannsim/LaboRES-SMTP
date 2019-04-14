# LaboRES-SMTP

## Deliverables

Your report MUST include the following sections:

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

If you do a good job, an external user should be able to clone your repo, edit a couple of files and send a batch of e-mails in less than 10 minutes.

#### A description of your implementation document the key aspects of your code. 

It is probably a good idea to start with a class diagram. Decide which classes you want to show (focus on the important ones) and describe their responsibilities in text. It is also certainly a good idea to include examples of dialogues between your client and an SMTP server (maybe you also want to include some screenshots here).

![UML](https://user-images.githubusercontent.com/47739482/56092624-a36ae680-5ebe-11e9-8c32-8ac070e85806.PNG)
