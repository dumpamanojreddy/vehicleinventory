# vehicleinventory
Restful application to handle vehicles inventory & search.

1) Vehicle could be of different types with specific properties and behaviors. Types: Car, Truck, Airplane, Drone, Amphibian, Boat.

2) CRUD operations to manage vehicles

3) Save to a local db like h2 or sqlite

4) Ability to search for vehicles (Hibernate Search)

5) Delete recent API - should delete last added vehicle


Rest API's for vehicle inventory
1. Get list of vehicles

$ curl http://localhost:8080/vehicleinventory/api/v1/vehicles

2. Get vehicle by id

$ curl http://localhost:8080/vehicleinventory/api/v1/vehicles/6

3. Post a new vehicle

$ curl --header "Content-Type: application/json" --request POST --data '{"type":"boat","manufacturer":"volvo","model":"B222","make_year":2014,"price":450000}' http://localhost:8080/vehicleinventory/api/v1/vehicles

4. Update a vehicle

$ curl --header "Content-Type: application/json" --request PUT --data '{"id":6,"type":"truck","manufacturer":"volvo","model":"dhf","make_year":2015,"price":115000}' http://localhost:8080/vehicleinventory/api/v1/vehicles

5. Delete a vehicle

$ curl --request DELETE http://localhost:8080/vehicleinventory/api/v1/vehicles/6

6. Delete last inserted record

$ curl --request DELETE http://localhost:8080/vehicleinventory/api/v1/vehicles/latest

7. Search vehicles
$ curl -X GET 'http://localhost:8080/vehicleinventory/api/v1/vehicles/search?query=car'