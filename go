gradle clean oneJar
java -jar -Done-jar.silent=true build/libs/docker-dropwizard-application-standalone.jar server config.yml
