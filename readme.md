# MicroProfile is a set of specs that are used for microservices

## Introduction
Many microprofile application servers exists, and I used payara-micro for this demo
u need to download payara-micro
and mysql connector and put it in libs dir
I used postboot file that configures data source for our app.

to build the project use
    mvn clean package

This will create a war file  This can be started by executing the following command

     java -jar path_to_payara-micro/payara-micro-5.2021.1.jar ./target/hello-jakarta-micro.war  --postbootcommandfile ./initializer/postboot --addlibs ./libs --port 7777



To launch the test page, open your browser at the following URL

    http://localhost:7777/index.html  



## Specification examples

### CDI
* type safe DI, sterio types, qualifiers
* life cycle - contexts
* interceptors
* events
* service providers

### JAX-RS
By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple todo endpoint is created.

### JPA








