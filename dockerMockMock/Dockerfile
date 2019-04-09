FROM java:8
MAINTAINER Yoann Simonet <yoann.simonet@heig-vd.ch>, Julien Rod <julien.rod@heig-vd.ch>

#
# When we build the image, we copy the executable jar in the image file system. 
#
COPY MockMock-1.4.0.one-jar.jar /opt/app/server.jar

EXPOSE 25
EXPOSE 8282


#
# This is the command that is executed when the Docker container starts
#
CMD ["java", "-jar", "/opt/app/server.jar"]