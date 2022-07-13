INSERT INTO user_auth(role,is_active,password,username) VALUES
('ADMIN',true,'$2a$10$FLna.MvoHiTYxmHqvw980euM5aldO1lcZNDNGhrHDRuQQXYCmdiau','ashish@miu.edu');

INSERT INTO department (id,department_name) VALUES (1,'Development');
INSERT INTO department (id,department_name) VALUES (2,'Quality Assistance');
INSERT INTO department (id,department_name) VALUES (3,'Teaching Assistance');
INSERT INTO department (id,department_name) VALUES (4,'Research Assistance');

INSERT INTO address (id,city,state) VALUES (1,'Fairfield','IOWA');
INSERT INTO address (id,city,state) VALUES (2,'BHAKTAPUR','OHIO');
INSERT INTO address (id,city,state) VALUES (3,'SOUTH','COLORADO');
INSERT INTO address (id,city,state) VALUES (4,'POKHARA','CALIFORNIA');
INSERT INTO address (id,city,state) VALUES (5,'HETAUDA','ALASKA');
INSERT INTO address (id,city,state) VALUES (6,'KATHMANDU','KANSAS');
INSERT INTO address (id,city,state) VALUES (7,'DANG','FLORIDA');
INSERT INTO address (id,city,state) VALUES (8,'Ottumwa','IOWA');
INSERT INTO address (id,city,state) VALUES (9,'De Moines','IOWA');
INSERT INTO address (id,city,state) VALUES (10,'North','COLORADO');
INSERT INTO address (id,city,state) VALUES (11,'Chitwan','CALIFORNIA');
INSERT INTO address (id,city,state) VALUES (12,'Bharatpur','ALASKA');
INSERT INTO address (id,city,state) VALUES (13,'Walling','KANSAS');
INSERT INTO address (id,city,state) VALUES (14,'Patan','FLORIDA');
INSERT INTO address (id,city,state) VALUES (15,'Dolpa','ALASKA');

INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (1,'apokhrel@miu.edu','Ashish','Pokhrel',1,4,1,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (2,'pbudhathoki@miu.edu','Puskar','Budhatoki',12,4,2,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (3,'spageni@miu.edu','Saugat','Pageni',13,4,3,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (4,'akc@miu.edu','Anand','Kc',14,4,4,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (5,'sudip@miu.edu','Sudip','Budhatoki',5,4,1,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (6,'sp666@miu.edu','Sudip2','Budhatoki2',6,4,2,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (7,'apokhrel777@miu.edu','Ashish','Pokhrel',1,4,1,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (8,'pbudhathoki8888@miu.edu','Puskar','Budhatoki',15,4,2,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (9,'spageni9999@miu.edu','Saugat','Pageni',3,4,3,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (10,'akc10010@miu.edu','Anand','Kc',4,4,4,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (11,'ram@miu.edu','Ram','raj',1,4,1,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (12,'shyam@miu.edu','Shyam','Budhatoki',2,4,2,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (13,'hari@miu.edu','Hari','Pageni',3,4,3,1,false);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id,is_deleted) VALUES (14,'ramesh@miu.edu','rames','VAi',4,4,4,1,false);

INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('good salary with bonus','Amazon','more than 1000','Mid level java developer needed in Amazon','Java, PostgreSQL','Java Developer','Full-Time',5,180000,'2022-07-12',1,1,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Attractive Salary with stock options','Microsoft','more than 1000','Senior level C# developer needed in Microsoft','C#, MySQL','C# Developer','Full-Time',10,220000,'2022-07-01',2,2,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Lunch provided, Recreational Center within company','Shining Star Pvt. Ltd','0-less than 100','Entry level Java Engineer needed in Shining Star Pvt. Ltd','Java','Java Developer','Part-Time',2,80000,'2022-06-25',3,3,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Weekly recreational Activities','IBM','more than 1000','Entry level C# developer needed in IBM','C#, PostgreSQL','Java Developer','Contract',10,90000,'2022-05-10',4,4,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Monthly Hiking trip','MiSUMi Co. Ltd.','100-1000','Mid level C# developer needed in MiSUMi','C#, MySQL','Full Stack Developer','Full-Time',3,150000,'2022-01-12',5,5,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Yearly recreational Activities','CORBA','more than 1000','Entry level C# developer needed in IBM','C#, PostgreSQL','Java Developer','Contract',10,90000,'2022-05-10',4,4,false);
INSERT INTO job_advertisement(add_benefit, company_name, company_size, job_desc, job_tag, job_title, job_type, num_opening, payment_amount, publish_date, id_address, student_id, is_deleted) VALUES ('Tou trip','Honda Co. Ltd.','100-1000','Mid level C# developer needed in MiSUMi','C#, MySQL','Full Stack Developer','Full-Time',3,150000,'2022-01-12',5,5,false);


INSERT INTO faculty (id, active, department, email, first_name, last_logged_in_at, last_name, password, id_address, is_deleted) VALUES (1, true,'cs','faculty@miu.edu','Bibek','2022-01-15','Thokar','admin123',1, false);

INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (1, 'Extraordinary Student',true,false,1,1);
INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (2, 'Good boy.',true,false,1,1);
INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (3, 'Fresh boy',true,false,1,2);






