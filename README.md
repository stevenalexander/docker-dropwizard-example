# Docker Dropwizard image

Example Docker image for running a Dropwizard Application in a container.

Requires:
* [Docker](https://www.docker.com/)
* [Boot2Docker](http://boot2docker.io/)
* JDK (to compile java file locally)

To run locally:

```
gradle run
# ./go
```

To build docker image:

```
gradle dockerBuildImage
# ./dockerBuildImage.sh
```

To run docker image:

```
gradle dockerRunImage
./dockerRunImage.sh
```

When image is running use `boot2docker ip` to get the docker IP and `docker ps` to see the port assigned to the container port 8080, then curl `http://<mydockerip>:<port>/hello` to call the dropwizard application running in the container.
