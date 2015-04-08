# Docker Dropwizard image

Example Docker image for running a Dropwizard Application in a container.

![terminal gif](https://raw.githubusercontent.com/stevenalexander/docker-dropwizard-example/master/terminal.gif "terminal gif")

Requires:
* [Docker](https://www.docker.com/)
* [Boot2Docker](http://boot2docker.io/)
* JDK (to compile java file locally)
* [Gradle](https://gradle.org/) (for build automation)

To run locally:

```
gradle run
# ./go
```

To build docker image:

```
gradle dockerBuildImage
# ./dockerBuildImage.sh (requires oneJar task to build dropwizard application)
```

To run docker image:

```
gradle dockerRunImage
./dockerRunImage.sh (requires built image)
```

When image is running use `boot2docker ip` to get the docker IP and `docker ps` to see the port assigned to the container port 8080, then curl `http://<dockerip>:<port>/hello` to call the dropwizard application running in the container.

If using LINUX you can use localhost and have to `sudo` docker commands.

## Details

This is a bare bones example for building an image for running a single Dropwizard application. It uses the standard docker java:jre-8 image as base, copies necessary files into image into folder `/opt/dropwizard` and runs command to start dropwizard application.

Dockerfile:

```
FROM java:8-jre
COPY config.yml /opt/dropwizard/
COPY build/libs/docker-dropwizard-application-standalone.jar /opt/dropwizard/
EXPOSE 8080
WORKDIR /opt/dropwizard
CMD ["java", "-jar", "-Done-jar.silent=true", "docker-dropwizard-application-standalone.jar", "server", "config.yml"]
```

## Conclusions

This is a simple way of defining a disposal container for a dropwizard application, taking effort away from operations and making the development team responsible for how their application will be hosted and run. Your application will be completely isolated from other parts of your solution running on the same host machine, including other instances of the same application for scaling and redundancy.

Instead of thinking of instances of your application, you have instances of your container image, hosted on one or more docker hosts depending on your architecture. Used correctly, you can create container instances as needed, kill when done, using versioning of images to release new versions of the service.

Things to consider:
* How to extract information from running container instance application (logging, performance monitoring etc.)
* Port management, how to create new containers with dynamic port allocation (to avoid collisions) while still balancing load between them
* General release management using Docker
