# hello_microservices

## Prerequisites
```
gradle 2+
Java 1.8
Eclipse with Groovy 2.4 plugin.
```

## Instructions to setup
```
git clone https://github.com/kingomarigold/hello_microservices.git
git checkout develop
gradle cleanEclipse eclipse
```
## Instructions to run
```
cd eureka
gradle bootRun
```

Run the individual applications once Eureka is started. The gateway would be available at port 8080.
