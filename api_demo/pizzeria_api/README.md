# Pizzeria API Application
This is a web application built using Java SpringBoot 
and MySQL Server.

Launch the webserver by running the `main` method in
`PizzeriaApiApplication`.

You can then test the API using PostMan. Following are the API endpoints

## Orders
* **GET** `http://localhost:8080/api/orders/{orderId}`
* **POST** `http://localhost:8080/api/orders`
* **PUT** `http://localhost:8080/api/orders/{orderId}`
* **DELETE** `http://localhost:8080/api/orders/{orderId}`

## Pizzas
* **GET** `http://localhost:8080/api/pizzas?oid={orderId}`
* **GET** `http://localhost:8080/api/pizzas/{pizzaId}`
* **POST** `http://localhost:8080/api/pizzas`
* **PUT** `http://localhost:8080/api/pizzas/{pizzaId}`
* **DELETE** `http://localhost:8080/api/pizzas/{pizzaId}`
