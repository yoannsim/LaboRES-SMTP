FROM java:8
MAINTAINER Yoann Simonet <yoann.simonet@heig-vd.ch>, Julien Rod <julien.rod@heig-vd.ch>

#
# When we build the image, we copy the executable jar in the image file system. 
#
COPY LaboRES-SMTP-1.0-SNAPSHOT-launcher.jar /opt/app/server.jar
COPY src/config.properties /src/config.properties
COPY src/listeVictime.txt /src/listeVictime.txt
COPY src/listePrank.txt /src/listePrank.txt

#
# This is the command that is executed when the Docker container starts
#
CMD ["java", "-jar", "/opt/app/server.jar"]