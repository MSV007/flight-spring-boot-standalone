DROP TABLE FLIGHT_DETAILS;

create table FLIGHT_DETAILS(flight_number varchar, origin varchar, destination varchar, departure_time varchar, arrival_time varchar, price int, currency varchar, primary key (flight_number));

insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('A101','AMS','DEL', '2023-08-22 11:00', '2023-08-22 17:00', 850, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('B101','AMS','BOM', '2023-08-22 12:00', '2023-08-22 19:30', 750, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('C101','AMS','BLR', '2023-08-22 13:00', '2023-08-22 18:30', 800, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('D101','AMS','MAA', '2023-08-22 09:00', '2023-08-22 15:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('E101','MAA','BOM', '2023-08-22 16:00', '2023-08-22 17:30', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('F101','BOM','DEL', '2023-08-22 20:30', '2023-08-22 21:30', 80, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('G101','BOM','DEL', '2023-08-22 18:00', '2023-08-22 19:30', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('A201','LHR','DEL', '2023-08-22 11:30', '2023-08-22 17:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('B201','LHR','BOM', '2023-08-22 12:35', '2023-08-22 19:30', 750, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('C201','LHR','BLR', '2023-08-22 13:45', '2023-08-22 18:30', 800, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('D201','LHR','MAA', '2023-08-22 09:00', '2023-08-22 15:00', 600, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('E201','DEL','BOM', '2023-08-22 18:45', '2023-08-22 20:15', 100, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('F201','BOM','DEL', '2023-08-22 21:15', '2023-08-22 22:30', 80, 'EUR');
insert into FLIGHT_DETAILS(flight_number, origin, destination, departure_time, arrival_time, price, currency) values('G01','BOM','DEL', '2023-08-22 20:20', '2023-08-22 21:30', 100, 'EUR');

COMMIT;