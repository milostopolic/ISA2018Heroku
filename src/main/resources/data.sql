insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (1, "Veljko", "Petrovic", "vpetrovic@gmail.com", "pass", "Novi Sad", "021323221", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (2, "Stefan", "Stefanovic", "stefans@gmail.com", "pass", "Beocin", "021521151", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (3, "Branko", "Markovic", "brankomarkovic@gmail.com", "pass", "Beograd", "021236235", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (4, "Mila", "Lukic", "milamila@gmail.com", "pass", "Subotica", "021325312", false, 0, 0);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (5, "Stanislava", "Loncar", "stanislaval@gmail.com", "pass", "Pancevo", "021534231", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (6, "Milan", "Vujosevic", "milanvuj123@gmail.com", "pass", "Titel", "021732331", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (7, "Ana", "Vlahovic", "student.ftn.isa@gmail.com", "pass", "Novi Sad", "021632231", false, 0, 0); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (8, "Pavle", "Jankovic", "pavlej233@gmail.com", "pass", "Becej", "021532321", false, 0, 0);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (9, "Admin", "Admin", "admin@gmail.com", "admin", "Novi Sad", "021323221", true, 1, 0);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (10, "Air", "Admin", "airadmin@gmail.com", "admin", "Novi Sad", "021323221", true, 2, 0);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (11, "Hotel", "Admin", "hoteladmin@gmail.com", "admin", "Novi Sad", "021323221", true, 3, 0);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified,type, version) values (12, "Rac", "Admin", "racadmin@gmail.com", "admin", "Novi Sad", "021323221", true, 4, 0);


INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',0,1,2, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',1,1,3, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',1,2,3, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',1,1,4, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',1,2,6, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',0,1,7, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',0,1,6, 0);
INSERT INTO friendship(confirm,status,receiver_id,sender_id, version) VALUES ('?',2,1,5, 0);


insert into hotel(id,name,address,description,image, rating, version) values (1, "Palisad", "Plaza de Cibeles Madrid", "Lep hotel", "../../assets/img/palisad.jpg", 4.56, 0);
insert into hotel(id,name,address,description,image, rating, version) values (2, "Park", "Novosadskog sajma 35 Novi Sad", "Sajmiste", "../../assets/img/park.jpg", 4.01, 0);  
insert into hotel(id,name,address,description,image, rating, version) values (3, "Putnik", "Ilije Ognjanovica 24 Novi Sad", "U centru", "../../assets/img/putnik.jpg", 4.07, 0);  
  
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (1, 2, 40, 1, 3.12, 0, 0);
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (2, 3, 54, 1, 5.00, 0, 0);
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (3, 4, 67, 1, 4.96, 0, 0);
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (4, 2, 80, 1, 4.82, 1, 0);
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (5, 3, 90, 1, 4.63, 1, 0);
insert into room(id, beds, price, hotel_id, rating, on_discount, version) values (6, 4, 100, 1, 4.43, 1, 0);

insert into airline(id, name, address, description, image, rating, version) values (1, "Air Srbija", "Aerodrom Beograd 59 Beograd", "Serbian airline", "../../assets/img/airserbia.jpg", 4.5, 0);
insert into destination(airline_id, name, version) values (1, "Beocin", 0);
insert into destination(airline_id, name, version) values (1, "Madrid", 0);
insert into destination(airline_id, name, version) values (1, "Berlin", 0);

insert into airline(id, name, address, description, image, rating, version) values (2, "Emirates", "Financial Center Rd Dubai UAE", "UAE", "../../assets/img/emirates.png", 4.9, 0);
insert into destination(airline_id, name, version) values (2, "Berlin", 0);
insert into destination(airline_id, name, version) values (2, "New York", 0);
insert into destination(airline_id, name, version) values (2, "Moscow", 0);
insert into destination(airline_id, name, version) values (2, "Nis", 0);

insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (1, "Beograd", "London", "2018-12-22", "12:00 pm", "2018-12-22", "16:00 pm", 670, 1, 300, 3.8, 0);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (2, "Beograd", "Madrid", "2018-12-23", "12:00 pm", "2018-12-23", "16:00 pm", 1790, 1, 800, 4.5, 0);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (3, "Dubai", "New York", "2018-12-22", "12:00 pm", "2018-12-23", "16:00 pm", 7090, 2, 1400, 4.7, 0);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (4, "Beograd", "Madrid", "2018-12-23", "12:00 pm", "2018-12-23", "16:00 pm", 1200, 2, 1200, 3.9, 0);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (5, "Madrid", "Beograd", "2018-12-25", "13:00 pm", "2018-12-25", "17:00 pm", 1300, 2, 600, 4.2, 0);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price, rating, version) values (6, "Madrid", "Beograd", "2018-12-25", "14:00 pm", "2018-12-25", "18:00 pm", 1799, 1, 900, 3.9, 0);

insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (1,0,"2019-02-05","spec_offer",0,1,4,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (2,0,"2019-02-05","spec_offer",0,1,16,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (3,0,"2019-02-05","spec_offer",0,2,28,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (4,0,"2019-02-05","spec_offer",0,2,40,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (5,0,"2019-02-05","spec_offer",0,3,52,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (6,0,"2019-02-05","spec_offer",0,3,64,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (7,0,"2019-02-05","spec_offer",0,4,76,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (8,0,"2019-02-05","spec_offer",0,4,88,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (9,0,"2019-02-05","spec_offer",0,5,100,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (10,0,"2019-02-05","spec_offer",0,5,112,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (11,0,"2019-02-05","spec_offer",0,6,124,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (12,0,"2019-02-05","spec_offer",0,6,136,null, 0);
insert into booking_flight(id,passport_nmb, reservation_date, status, total_price, flight_id, seats_id, user_id, version) values (13,111,"2019-02-05","accepted",120,1,3,1, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (1, 1, false, "A", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (2, 1, false, "B", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (3, 1, false, "C", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (4, 1, true, "D", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (5, 1, false, "E", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (6, 1, false, "F", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (7, 2, false, "A", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (8, 2, false, "B", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (9, 2, false, "C", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (10, 2, false, "D", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (11, 2, false, "E", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (12, 2, false, "F", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (13, 3, false, "A", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (14, 3, false, "B", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (15, 3, false, "C", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (16, 3, true, "D", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (17, 3, false, "E", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (18, 3, false, "F", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (19, 4, false, "A", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (20, 4, false, "B", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (21, 4, false, "C", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (22, 4, false, "D", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (23, 4, false, "E", 1, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (24, 4, false, "F", 1, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (25, 1, false, "A", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (26, 1, false, "B", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (27, 1, false, "C", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (28, 1, true, "D", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (29, 1, false, "E", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (30, 1, false, "F", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (31, 2, false, "A", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (32, 2, false, "B", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (33, 2, false, "C", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (34, 2, false, "D", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (35, 2, false, "E", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (36, 2, false, "F", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (37, 3, false, "A", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (38, 3, false, "B", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (39, 3, false, "C", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (40, 3, true, "D", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (41, 3, false, "E", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (42, 3, false, "F", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (43, 4, false, "A", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (44, 4, false, "B", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (45, 4, false, "C", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (46, 4, false, "D", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (47, 4, false, "E", 2, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (48, 4, false, "F", 2, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (49, 1, false, "A", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (50, 1, false, "B", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (51, 1, false, "C", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (52, 1, true, "D", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (53, 1, false, "E", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (54, 1, false, "F", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (55, 2, false, "A", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (56, 2, false, "B", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (57, 2, false, "C", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (58, 2, false, "D", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (59, 2, false, "E", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (60, 2, false, "F", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (61, 3, false, "A", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (62, 3, false, "B", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (63, 3, false, "C", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (64, 3, true, "D", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (65, 3, false, "E", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (66, 3, false, "F", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (67, 4, false, "A", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (68, 4, false, "B", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (69, 4, false, "C", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (70, 4, false, "D", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (71, 4, false, "E", 3, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (72, 4, false, "F", 3, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (73, 1, false, "A", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (74, 1, false, "B", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (75, 1, false, "C", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (76, 1, true, "D", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (77, 1, false, "E", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (78, 1, false, "F", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (79, 2, false, "A", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (80, 2, false, "B", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (81, 2, false, "C", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (82, 2, false, "D", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (83, 2, false, "E", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (84, 2, false, "F", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (85, 3, false, "A", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (86, 3, false, "B", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (87, 3, false, "C", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (88, 3, true, "D", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (89, 3, false, "E", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (90, 3, false, "F", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (91, 4, false, "A", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (92, 4, false, "B", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (93, 4, false, "C", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (94, 4, false, "D", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (95, 4, false, "E", 4, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (96, 4, false, "F", 4, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (97, 1, false, "A", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (98, 1, false, "B", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (99, 1, false, "C", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (100, 1, true, "D", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (101, 1, false, "E", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (102, 1, false, "F", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (103, 2, false, "A", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (104, 2, false, "B", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (105, 2, false, "C", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (106, 2, false, "D", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (107, 2, false, "E", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (108, 2, false, "F", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (109, 3, false, "A", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (110, 3, false, "B", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (111, 3, false, "C", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (112, 3, true, "D", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (113, 3, false, "E", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (114, 3, false, "F", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (115, 4, false, "A", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (116, 4, false, "B", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (117, 4, false, "C", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (118, 4, false, "D", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (119, 4, false, "E", 5, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (120, 4, false, "F", 5, 0);

insert into seat(id, roww, reserved, columnn, flight_id, version) values (121, 1, false, "A", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (122, 1, false, "B", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (123, 1, false, "C", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (124, 1, true, "D", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (125, 1, false, "E", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (126, 1, false, "F", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (127, 2, false, "A", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (128, 2, false, "B", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (129, 2, false, "C", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (130, 2, false, "D", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (131, 2, false, "E", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (132, 2, false, "F", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (133, 3, false, "A", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (134, 3, false, "B", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (135, 3, false, "C", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (136, 3, true, "D", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (137, 3, false, "E", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (138, 3, false, "F", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (139, 4, false, "A", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (140, 4, false, "B", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (141, 4, false, "C", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (142, 4, false, "D", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (143, 4, false, "E", 6, 0);
insert into seat(id, roww, reserved, columnn, flight_id, version) values (144, 4, false, "F", 6, 0);



insert into stop(name, flight_id, version) values ("Paris", 3, 0);
insert into stop(name, flight_id, version) values ("Lisabon", 3, 0);
insert into stop(name, flight_id, version) values ("Amsterdam", 1, 0);
insert into stop(name, flight_id, version) values ("Berlin", 1, 0);
insert into stop(name, flight_id, version) values ("Bern", 2, 0);
insert into stop(name, flight_id, version) values ("Vienna", 2, 0);
insert into stop(name, flight_id, version) values ("Barcelona", 4, 0);
insert into stop(name, flight_id, version) values ("Warshaw", 4, 0);
insert into stop(name, flight_id, version) values ("Rome", 5, 0);
insert into stop(name, flight_id, version) values ("Milano", 5, 0);
insert into stop(name, flight_id, version) values ("Oslo", 6, 0);
insert into stop(name, flight_id, version) values ("Moscow", 6, 0);

insert into rentacar(id, name, address, description, image) values (1, "Star", "Novi Sad", "Best prices", "../../assets/img/star.png");
insert into rentacar(id, name, address, description, image) values (2, "Control", "Beograd", "Best cars", "../../assets/img/control.jpg");
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (1, "Mercedes-Benz", "S-Class", 2016, 4, 3, 190, 2);
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (2, "Audi", "A3", 2017, 5, 0, 90, 2);
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (3, "Skoda", "Octavia", 2014, 5, 1, 70, 1);
insert into branch_office(id, address, head_office_id) values (1, "Maksima Gorkog 32", 1);
insert into branch_office(id, address, head_office_id) values (2, "Bulevar oslobodjenja 126", 1);
insert into branch_office(id, address, head_office_id) values (3, "Hajduk Veljkova 7", 2);

insert into pricelist(id, hotel_id, version) values (1, 1, 0);
insert into pricelist(id, hotel_id, version) values (2, 2, 0);
insert into pricelist(id, hotel_id, version) values (3, 3, 0);


insert into additional_service(id, name, price, pricelist_id, version) values (1, 'Wifi', 10, 1, 0);
insert into additional_service(id, name, price, pricelist_id, version) values (2, 'Wifi', 13, 2, 0);
insert into additional_service(id, name, price, pricelist_id, version) values (3, 'Wifi', 12, 3, 0);
insert into additional_service(id, name, price, pricelist_id, version) values (4, 'Breakfast', 7, 1, 0);
insert into additional_service(id, name, price, pricelist_id, version) values (5, 'Air condition', 5, 1, 0);
insert into additional_service(id, name, price, pricelist_id, version) values (6, 'Parking', 11, 1, 0);



insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (1, '2019-02-02', '2019-02-06', 131, 1, 1, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (2, '2019-02-04', '2019-02-12', 231, 1, 2, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (3, '2019-02-12', '2019-02-14', 121, 1, 3, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (4, '2019-02-22', '2019-02-28', 131, 1, 4, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (5, '2019-02-07', '2019-02-09', 331, 1, 5, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (6, '2019-03-03', '2019-03-05', 331, 1, 5, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (7, '2019-04-04', '2019-04-07', 331, 1, 4, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (8, '2019-05-05', '2019-05-08', 331, 1, 5, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (9, '2019-06-06', '2019-06-16', 331, 1, 4, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (10, '2019-07-07', '2019-07-17', 331, 1, 5, 0);
insert into booking(id, end_date, start_date, total_price, hotel_id, user_id, version) values (11, '2019-08-08', '2019-08-18', 331, 1, 4, 0);

insert into booking(id, hotel_id, total_price, version) values (12, 1, 0, 0);
insert into booking(id, hotel_id, total_price, version) values (13, 1, 0, 0);
insert into booking(id, hotel_id, total_price, version) values (14, 1, 0, 0);

insert into booking_rooms(booking_id, rooms_id) values(12, 4);
insert into booking_rooms(booking_id, rooms_id) values(13, 5);
insert into booking_rooms(booking_id, rooms_id) values(14, 6);

insert into booking_additional_services(booking_id, additional_services_id) values (12, 1);
insert into booking_additional_services(booking_id, additional_services_id) values (13, 1);
insert into booking_additional_services(booking_id, additional_services_id) values (14, 1);
