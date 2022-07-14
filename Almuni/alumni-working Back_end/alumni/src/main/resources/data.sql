-- addresses
insert into addresses values (7,'Seattle','WA','176th street',98188,1,1);
insert into addresses values (2,'Fairfield','IA','200th street',98188,2,2);
insert into addresses values (3,'Des Moines','IA','176th street',98188,3,3);
insert into addresses values (4,'New York','NY','876th street',98188,4,4);
insert into addresses values (5,'Dallas','TX','376th street',98188,5,5);

-- commnets
insert into comments values (1,'this is funny and crazy',1);
insert into comments values (2,'This student is good',2);
insert into comments values (3,'This student is funny',3);
insert into comments values (4,'Please watch out this student ',4);

-- coureses
insert into coureses values (5,'545','WAA',1);
insert into coureses values (2,'572','EA',2);
insert into coureses values (3,'546','SA',3);
insert into coureses values (4,'525','ASD',4);

-- departments

insert into departments values (1,'Compro');
insert into departments values (2,'MSD');

-- faculties
insert into faculties values  (7,1,'rob@gmail.com','robeil',3.8,null,'aregawi','asdef',1,1);
insert into faculties values  (2,1,'teddy@gmail.com','teddy',3.8,null,'abcd','asdef',1,1);
insert into faculties values  (3,1,'rob@gmail.com','robeil',3.8,null,'aregawi','asdef',1,1);
insert into faculties values  (4,1,'teddy@gmail.com','teddy',3.8,null,'abcd','asdef',1,1);
insert into faculties values  (5,1,'rob@gmail.com','robeil',3.8,null,'aregawi','asdef',1,1);
insert into faculties values  (6,1,'teddy@gmail.com','teddy',3.8,null,'abcd','asdef',1,1);

-- students
insert into students values  (1,1,'kele@gmail.com','kele',3.8,null,'tesfamariam','fdsa12',1,1);
insert into students values  (2,0,'lwam@gmail.com','luwam',3.8,null,'tsegay','frdef',2,1);
insert into students values  (3,1,'natu@gmail.com','natu',3.8,null,'berhe','hhjjks',3,1);
insert into students values  (4,1,'kele@gmail.com','kele',3.8,null,'tesfamariam','fdsa12',1,1);
insert into students values  (5,0,'lwam@gmail.com','luwam',3.8,null,'tsegay','frdef',2,1);
insert into students values  (6,1,'natu@gmail.com','natu',3.8,null,'berhe','hhjjks',3,1);

-- roles
insert into roles values (1,'ROLE_STUDENT');
insert into roles values (2,'ROLE_FACULTY');
insert into roles values (3,'ROLE_ADMIN');


-- job advertisments
insert into job_advertisements values (16,null,'frontend','dental','Amazon',1,null,1);
insert into job_advertisements values (2,null,'backend','dental','Microsoft',1,null,2);
insert into job_advertisements values (3,null,'fullstuck','vision','Google',1,null,3);
insert into job_advertisements values (4,null,'frontend','dental','Amazon',1,null,3);
insert into job_advertisements values (5,null,'backend','dental','Microsoft',1,null,2);
insert into job_advertisements values (6,null,'fullstuck','vision','Google',1,null,3);
insert into job_advertisements values (7,null,'frontend','dental','Amazon',1,null,1);
insert into job_advertisements values (8,null,'backend','dental','Microsoft',1,null,2);
insert into job_advertisements values (9,null,'fullstuck','vision','Google',1,null,3);
insert into job_advertisements values (10,null,'frontend','dental','Amazon',1,null,3);
insert into job_advertisements values (11,null,'backend','dental','Microsoft',1,null,2);
insert into job_advertisements values (12,null,'fullstuck','vision','Google',1,null,3);
insert into job_advertisements values (13,null,'frontend','dental','Amazon',1,null,3);
insert into job_advertisements values (14,null,'backend','dental','Microsoft',1,null,2);
insert into job_advertisements values (15,null,'fullstuck','vision','Google',1,null,3);

insert into users values (3,'Fairfiled','robeil@gmail.com','Rob',1,'John','abcd','IA','200th street','rob1',52557);
insert into users values (2,'Fairfiled','robeil@gmail.com','Rob',1,'John','fgladjkglhbg','IA','200th street','rob123',52557);