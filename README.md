# Promotion Engine

Problem Statement 1: 
Promotion Engine
We need you to implement a simple promotion engine for a checkout process. Our Cart contains a list of single character SKU ids (A, B, C....) over which the promotion engine will need to run.
The promotion engine will need to calculate the total order value after applying the 2 promotion types
•	buy 'n' items of a SKU for a fixed price (3 A's for 130)
•	buy SKU 1 & SKU 2 for a fixed price ( C + D = 30 )
The promotion engine should be modular to allow for more promotion types to be added at a later date (e.g. a future promotion could be x% of a SKU unit price). For this coding exercise you can assume that the promotions will be mutually exclusive; in other words if one is applied the other promotions will not apply
Test Setup
Unit price for SKU IDs
A      50
B      30
C      20
D      15

Active Promotions
3 of A's for 130
2 of B's for 45
C & D for 30

Scenario A
1 * A     50
1 * B     30
1 * C     20
======
Total     100

Scenario B
5 * A     130 + 2*50
5 * B     45 + 45 + 30
1 * C     20
======
Total     370

Scenario C
3 * A     130
5 * B     45 + 45 + 1 * 30
1 * C     -
1 * D     30
======
Total     280


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

### Configuration Parameters
To configure the promotions and prices of the items in application.yml

### Deployment

#### Run locally as Spring-Boot application in its own container

```
mvn spring-boot:run
```
*While deploying application locally as Spring-Boot, /src/main/resources/application.yml is consumed.*

### Testing

Example:

```
curl --location --request POST 'http://localhost:8080/demo/v1.0/orders/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "A":3,
    "B":5,
    "C":1,
    "D":1
}'
```
