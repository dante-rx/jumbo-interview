# Jumbo Closest Store Rest API
Simple REST based application for querying closest Jumbo Stores.

Application has only one endpoint that returns closest stores with given latitude and longitude:

`GET /stores/closest?latitude={latitude}&longitude={longitude}`

## Usage

To run the application, just run this command under the base directory:

`mvn spring-boot:run`

You can limit the number of stores to return with running this command (Default:5):

`mvn spring-boot:run -Dstores.numberOfStoresToReturn=NUMBER_OF_STORES_YOU_WANT`

## Swagger

You can try the closest store endpoint using SwaggerUI:

http://localhost:8080/swagger-ui.html