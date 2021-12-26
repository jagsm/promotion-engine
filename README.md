# Promotion Engine

This API is used for calculate the total of the items.

## Service Metadata
* **Service Name:** promotion-engine
* **Context Root:** /promotion-engine/v1.0


## API EndPoints
/orders/order

## Getting Started

### Prerequisites
* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git:
```
git@github.com:jagsm/promotion-engine.git
```

### External Dependencies
API is dependent on following external services:

### Configuration Parameters
To configure the promotions and prices of the items in application.yml

### Deployment

#### Run locally as Spring-Boot application in its own container

```
mvn spring-boot:run
```
*While deploying application locally as Spring-Boot, /src/main/resources/application.yml is consumed.*


