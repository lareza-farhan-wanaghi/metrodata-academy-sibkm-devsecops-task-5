# Metrodata Academy SIBKM DevSecOps Task 5: CRUD Order Service

## Objective

1. Create a new branch in the Order-Service repository.
2. Create a Spring Boot project named "order-service" with the following dependencies:
   - Spring Web
   - MySQL Driver
   - Spring Data JPA
   - Cloud Bootstrap
   - Spring Boot DevTools
   - Lombok
3. Implement a CRUD application using the created project. The application will utilize a table named "tb_tr_order" with the following fields:
   - Long id
   - int quantity
   - Long amount
   - String status
   - Instant date

## Solution

### 1. Project Setup

1. Visit the Spring Initializr webpage at [https://start.spring.io/](https://start.spring.io/) to create the Spring Boot project with the appropriate settings and click generate.
     <img src="_resources/Screenshot%202023-09-10%20at%2017.19.28.png" width="75%"/>

2. Configure Git:

   ```bash
   git config --global user.name "<Your Name>"
   git config --global user.email "<Your Email>"
   echo "export GITHUB_TOKEN=<Your Access Token>" >> ~/.bashrc
   source ~/.bashrc
   ```

3. Unzip the project, initialize a repository for the project, and set the Git remote address:

   ```bash
   unzip order-service.zip 
   cd order-service
   git init
   git remote add order-service https://github.com/SIBKM-DevSecOps/order-service.git
   ```

4. Create a new branch and push the project as the initial commit:

   ```bash
   cd product-service
   git checkout -b lareza-farhan-wanaghi
   ```

### 2. Implement the CRUD application

1. Rename the `application.properties` to `application.yaml` and edit its content:

   ```bash
   mv src/main/resources/application.properties src/main/resources/application.yaml
   nano src/main/resources/application.yaml
   ```

   Copy and paste the following content into `application.yaml`:

   ```yaml
   server:
     port: 8081

   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/order_service
       username: user1
       password: 123456
       driver-class-name: com.mysql.cj.jdbc.Driver
     jpa:
       database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
       hibernate:
         ddl-auto: update
       show-sql: true
   ```

2. Create the controller:

   ```bash
   nano src/main/java/com/example/orderservice/controller/OrderController.java
   ```

   Copy and paste the following content into `OrderController.java`:

   ```java
   package com.example.orderservice.controller;

   // ... (import statements)

   @RestController
   @RequestMapping("/order")
   public class OrderController {

       // ... (controller methods)
   }
   ```

3. Create the table entity with the table named "tb_tr_order":

   ```bash
   nano src/main/java/com/example/orderservice/entity/Order.java
   ```

   Copy and paste the following content into `Order.java`:

   ```java
   package com.example.orderservice.entity;

   // ... (import statements)

   @Entity
   @Table(name = "tb_tr_order")
   public class Order {

       // ... (entity fields and methods)
   }
   ```

4. Create DTO (Data Transfer Object) for request:

   ```bash
   nano src/main/java/com/example/orderservice/model/OrderRequest.java
   ```

   Copy and paste the following content into `OrderRequest.java`:

   ```java
   package com.example.orderservice.model;

   // ... (import statements)

   public class OrderRequest {

       // ... (request fields and methods)
   }
   ```

5. Create DTO for response:

   ```bash
   nano src/main/java/com/example/orderservice/model/OrderResponse.java
   ```

   Copy and paste the following content into `OrderResponse.java`:

   ```java
   package com.example.orderservice.model;

   // ... (import statements)

   public class OrderResponse {

       // ... (response fields and methods)
   }
   ```

6. Create the database object repository:

   ```bash
   nano src/main/java/com/example/orderservice/repository/OrderRepository.java
   ```

   Copy and paste the following content into `OrderRepository.java`:

   ```java
   package com.example.orderservice.repository;

   // ... (import statements)

   @Repository
   public interface OrderRepository extends JpaRepository<Order, Long> {
       // JPQL
       // MethodQuery
   }
   ```

7. Create the service interface:

   ```bash
   nano src/main/java/com/example/orderservice/service/OrderService.java
   ```

   Copy and paste the following content into `OrderService.java`:

   ```java
   package com.example.orderservice.service;

   // ... (import statements)

   public interface OrderService {

       // ... (service methods)
   }
   ```

8. Create the service implementation:

   ```bash
   nano src/main/java/com/example/orderservice/service/OrderServiceImpl.java
   ```

   Copy and paste the following content into `OrderServiceImpl.java`:

   ```java
   package com.example.orderservice.service;

   // ... (import statements)

   @Service
   public class OrderServiceImpl implements OrderService {

       // ... (service implementation)
   }
   ```

The overall project structure should now look similar to this:

<img src="_resources/Screenshot%202023-09-11%20at%2009.24.16.png" width="75%"/>


### 3. Run and Test

1. Run the program:

   ```bash
   bash mvnw spring-boot:run
   ```

   You should see the program running as indicated by the output.

2. Test the Create Endpoint using Postman (or a similar tool) and observe the results.

   <img src="_resources/Screenshot%202023-09-11%20at%2009.25.20.png" width="75%"/>

3. Test the List Endpoint using Postman and observe the results.

   <img src="_resources/Screenshot%202023-09-11%20at%2009.25.39.png" width="75%"/>

4. Test the Update Endpoint using Postman and observe the results.

   <img src="_resources/Screenshot%202023-09-11%20at%2009.25.55.png" width="75%"/>

5. Test the Detail Endpoint using Postman and observe the results.

   <img src="_resources/Screenshot%202023-09-11%20at%2009.26.16.png" width="75%"/>

6. Test the Delete Endpoint using Postman and observe the results.

   <img src="_resources/Screenshot%202023-09-11%20at%2009.26.35.png" width="75%"/>

### 4. Push the solution
1. Push the solution
	```
	git add .
	git commit -m "Adding scripts for order-service CRUD RestAPI implementation"
	git push -u order-service lareza-farhan-wanaghi
	```