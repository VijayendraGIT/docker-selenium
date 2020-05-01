FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/work

# ADD .jar files target from host

ADD target/selenium-docker.jar 				selenium-docker.jar
ADD target/selenium-docker-tests.jar		selenium-docker-tests.jar
ADD target/libs								libs

#Any other dependency like .csv, excel  should be added

#Add Suite files
ADD book-flght-module.xml 					book-flght-module.xml
ADD search-module.xml						search-module.xml

#Add healthcheck.sh
#RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

#Below varaible also be passed to entrypoint which will be required to pass while run image 
#BROWSER
#HUB_HOST
#MODULE

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
#ENTRYPOINT sh healthcheck.sh
