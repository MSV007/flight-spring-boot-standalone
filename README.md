# flight-spring-boot-standalone

Develop a Flight-Search API that suites the following  use cases:
Flight Number | Origin |Destination |Departure Time |Arrival Time |Price
A101|AMS|DEL|11:00|17:00|850 EURO
B101|AMS|BOM|12:00|19:30|750 EURO
C101|AMS|BLR|13:00|18:30|800 EURO
D101|AMS|MAA|09:00|15:00|600 EURO
E101|MAA|BOM|16:00|17:30|100 EURO
F101|BOM|DEL|20:30|21:30|80 EURO
G101|BOM|DEL|18:00|19:30|100 EURO
A201|LHR|DEL|11:30|17:00|600 EURO
B201|LHR|BOM|12:35|19:30|750 EURO
C201|LHR|BLR|13:45|18:30|800 EURO
D201|LHR|MAA|09:00|15:00|600 EURO
E201|DEL|BOM|18:45|20:15|100 EURO
F201|BOM|DEL|21:15|22:30|80 EURO
G01 |BOM|DEL|20:20|21:30|100 EURO

Use case: 
- User can be able to find list of flights from Origin - Destination
- User can supply extra parameters in the request to sort results based on price, duration.

Tips:
 - Use at least Java 8 in combination with Spring framework

API URLs : 

Case 1 : find list of flights form Origin to Destination

http://localhost:8085/flightsAPI/v1/flights/search?origin=BOM&destination=DEL

Response : 

[
    {
        "flightNumber": "F101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:30",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "60 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "G101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 18:00",
        "arrivalTime": "2023-08-22 19:30",
        "duration": "90 minute",
        "price": 100,
        "currency": "EUR"
    },
    {
        "flightNumber": "F201",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 21:15",
        "arrivalTime": "2023-08-22 22:30",
        "duration": "75 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "G01",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:20",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "70 minute",
        "price": 100,
        "currency": "EUR"
    }
]

Case 2 : find list of flights form Origin to Destination and sortBy duration

http://localhost:8085/flightsAPI/v1/flights/search?origin=BOM&destination=DEL&sortBy=duration

Response : 

[
    {
        "flightNumber": "F101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:30",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "60 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "G01",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:20",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "70 minute",
        "price": 100,
        "currency": "EUR"
    },
    {
        "flightNumber": "F201",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 21:15",
        "arrivalTime": "2023-08-22 22:30",
        "duration": "75 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "G101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 18:00",
        "arrivalTime": "2023-08-22 19:30",
        "duration": "90 minute",
        "price": 100,
        "currency": "EUR"
    }
]

Case 3 : find list of flights form Origin to Destination and sortBy price

http://localhost:8085/flightsAPI/v1/flights/search?origin=BOM&destination=DEL&sortBy=price

Response : 

[
    {
        "flightNumber": "F101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:30",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "60 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "F201",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 21:15",
        "arrivalTime": "2023-08-22 22:30",
        "duration": "75 minute",
        "price": 80,
        "currency": "EUR"
    },
    {
        "flightNumber": "G101",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 18:00",
        "arrivalTime": "2023-08-22 19:30",
        "duration": "90 minute",
        "price": 100,
        "currency": "EUR"
    },
    {
        "flightNumber": "G01",
        "origin": "BOM",
        "destination": "DEL",
        "departureTime": "2023-08-22 20:20",
        "arrivalTime": "2023-08-22 21:30",
        "duration": "70 minute",
        "price": 100,
        "currency": "EUR"
    }
]

Case 4 : If Route is not available

http://localhost:8085/flightsAPI/v1/flights/search?origin=BOM&destination=DEM&sortBy=price

Response : 

{
    "timestamp": "2023-08-18T07:39:53.076+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Flights are not available for this route",
    "path": "/flightsAPI/v1/flights/search"
}
