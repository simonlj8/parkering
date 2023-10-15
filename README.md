REST API med ett antal endpoints

Post one person:
POST
/person/

(example)
{
 "name": "Anders Andersson"	
}

Respons:
{
	"id": 1,
	"name": "Anders Andersson"
}


Post Parking:

{
	"carId": 1,
	"locationId": 1,
	"parkingEnd": "2023-05-15T22:55:05",
	"parkingStart": "2023-05-15T22:30:06",
	"personId": 1,
	"status": "active"	
	
}


Fetch all cars:
GET

/cars

----------------------------
Fetch all persons:
GET

/persons

----------------------------
Fetch One person with id;
GET

/persons/{id}
