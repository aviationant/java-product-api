Simple Java API from scratch built with SpringBoot.

Add products via curl with 'curl -X POST -H "Content-Type: application/json" -d '{"name": "shovel", "price", 20.0}' http://localhost:8081/api/products'.
Get average of prices with 'curl -X GET -H "Content-Type: application/json" http://localhost:8081/api/products/average.
Get item price with 'curl -X GET -H "Content-Type: application/json" -d '{"name": "shovel"}' http://localhost:8081/api/products/item-price'.
