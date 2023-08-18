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

API URL : 
http://localhost:8085/flightsAPI/v1/flights/search?origin=BOM&destination=DEL&sortBy=duration
