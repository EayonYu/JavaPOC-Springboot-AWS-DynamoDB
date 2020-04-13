# JavaPOC-Springboot-DynamoDB
Sample Spring Boot app to perform operations using AWS-DynamoDB

### Download and run DynamoDB in local
```
$ java -jar -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

Initializing DynamoDB Local with the following configuration:
Port:	8000
InMemory:	false
DbPath:	null
SharedDb:	true
shouldDelayTransientStatuses:	false
CorsParams:	*
```
Refer to C2CDynamoDBApplication.java to see how we are creating the ProductCatalog data store in DynamoDB. 

### Try the below end-point to successfully retrieve sample data from DynamoDB

http://localhost:8080/catalogService/products

### Sample PUT request with a JSON payload. Make sure that you set 'Content-Type' to 'application/json' in the request headers

http://localhost:8080/catalogService/products/update/1ed4cd6a-41db-4192-a7b2-8e88c251b6e9
```
  {
    "createTime": "2020-04-13 13:46:40",
    "currencyCode": "USD",
    "id": "d37d01ba-4fb1-4aa9-b523-ae40cdd1ae70",
    "inventoryLow": 0,
    "isDeleted": "0",
    "price": 10.99,
    "productName": "Book",
    "quantity": 10
  }
```
### Sample POST request with a JSON payload. Make sure that you set 'Content-Type' to 'application/json' in the request headers

http://localhost:8080/catalogService/products/add   
```
{
  "createTime": "2020-04-13 13:46:40",
  "currencyCode": "USD",
  "id": "1066441e-f5b6-4373-9074-0f8eb20da8d4",
  "inventoryLow": 0,
  "isDeleted": "0",
  "price": 5.99,
  "productName": "Bag",
  "quantity": 10
}
```
 