# Coin flipping service
This is Spring Boot service that returns randomly chosen coin site as json response.
## Built with
- java
- spring boot
## How to run
````
java -jar jar-name.jar
````
#How to use
- returns single coin site record
````
http://localhost:8080/v1/flips/1/
````
- return multiple coin site records
````
http://localhost:8080/v1/flips/10/
````
- returns report with count how many specific coin site chosen
````
http://localhost:8080/v1/flips/3/total
````
# API

http://localhost:8080/swagger-ui/index.html#/