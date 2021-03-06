# Office Search Service

## About
Microservice to return the details of the nearest Job Centre Plus for a given postcode.

### Prerequisites

* Java 8
* Maven
* Docker (for postgresql)

## DB
### Local DB

The easiest way to have a local DB up and running on your machine is to use docker
```bash
$ docker run --name dwp-jsa -e POSTGRES_PASSWORD=password -e POSTGRES_DB=dwp-jsa -p5432:5432 postgres
```

## PublicKey

In application.properties, the services.publicKey needs to be populated with a good RSA key.
To create this, and set it, run ./createPublicKey.sh.  This is a one time operation.  Please take
care not to check this change in.

## Starting the jar

To run the jar, use:

```
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=5005,suspend=n \
  -jar ./target/office-search-service-1.0.0-SNAPSHOT.jar --spring.profiles.active=nosecure,WC \
  --logging.level.root=DEBUG
```

# Dependencies

This service requires nsjsa-commons to build.

## Sample dataset

src/test/resources/test-data.sql contains a sample data set that can be uploaded into
the postgres database.