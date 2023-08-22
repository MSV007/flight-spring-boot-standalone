DROP TABLE FLIGHT_DETAILS;

create table FLIGHT_DETAILS(flight_number varchar, origin varchar, destination varchar, departure_time datetime, arrival_time datetime, price int, currency varchar, primary key (flight_number));

insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('A101','AMS', 'DEL', '2023-08-28T11:00:00', '2023-08-21T17:00:00', 850, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('B101','AMS', 'BOM', '2023-08-28T12:00:00', '2023-08-28T19:30:00', 750, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('C101','AMS', 'BLR', '2023-08-28T13:00:00', '2023-08-28T18:30:00', 800, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('D101','AMS', 'MAA', '2023-08-28T09:00:00', '2023-08-28T15:00:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('E101','MAA', 'BOM', '2023-08-28T16:00:00', '2023-08-28T17:30:00', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('F101','BOM', 'DEL', '2023-08-28T20:30:00', '2023-08-28T21:30:00', 80, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('G101','BOM', 'DEL', '2023-08-28T18:00:00', '2023-08-28T19:30:00', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('A201','LHR', 'DEL', '2023-08-28T11:30:00', '2023-08-28T17:00:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('B201','LHR', 'BOM', '2023-08-28T12:35:00', '2023-08-28T19:30:00', 750, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('C201','LHR', 'BLR', '2023-08-28T13:45:00', '2023-08-28T18:30:00', 800, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('D201','LHR', 'MAA', '2023-08-28T09:00:00', '2023-08-28T15:00:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('E201','DEL', 'BOM', '2023-08-28T18:45:00', '2023-08-28T20:15:00', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('F201','BOM', 'DEL', '2023-08-28T21:15:00', '2023-08-28T22:30:00', 80, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('G01','BOM', 'DEL', '2023-08-28T20:20:00', '2023-08-28T21:30:00', 100, 'EUR');


COMMIT;