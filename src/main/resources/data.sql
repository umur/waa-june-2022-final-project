insert into tag (name) values ('Java');
insert into tag (name) values ('Backend');
insert into tag (name) values ('Frontend');
insert into tag (name) values ('Fullstack');
insert into tag (name) values ('iOS');
insert into tag (name) values ('.Net');
insert into tag (name) values ('Android');
insert into tag (name) values ('DevOps');
insert into tag (name) values ('Data Analytics');
insert into tag (name) values ('Software Engineering');

insert into department (name) values ('Computer Science');
insert into department (name) values ('Business Administration');
insert into department (name) values ('Electrical Engineering');
insert into department (name) values ('Civil Engineering');
insert into department (name) values ('Medical');
insert into department (name) values ('Environmental Sciences');
insert into department (name) values ('Social Sciences');
insert into department (name) values ('Journalism');
insert into department (name) values ('Agriculture');
insert into department (name) values ('Mathematics');

insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'john.doe@keycloak.org','John',4,'Doe','john.doe',1);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'jane.doe@keycloak.org','Jane',4,'Doe','jane.doe',2);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'anne.hathaway@keycloak.org','Anne',4,'Hathaway','anne.hathaway',3);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'eva.green@keycloak.org','Eva',4,'Green','eve.green',4);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'jlo@keycloak.org','Jenifer',4,'Lopez','jlo',5);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'jess.glynne@keycloak.org','Jess',4,'Glynne','jess.glynne',6);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'calum.scott@keycloak.org','Calum',4,'Scott','calum.scott',7);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'rbj@keycloak.org','Robert',4,'Downey Jr.','rbj',8);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'robert.deniro@keycloak.org','Robert',4,'De Niro','robert.deniro',9);
insert into student (active, email, first_name, gpa, last_name,username,major_id) values (true,'johnny.depp@keycloak.org','Johnny',4,'Depp','johnny.depp',10);

insert into address ( city, state, street, zip, student_id) values ('Fairfield','IA','1001 N 4th St.',52556,1);
insert into address ( city, state, street, zip, student_id) values ('Iowa','IA','1002 N 4th St.',52557,2);
insert into address ( city, state, street, zip, student_id) values ('Ottumwa','IA','1003 N 4th St.',52557,3);
insert into address ( city, state, street, zip, student_id) values ('Kabul','KB','1004 N 4th St.',52557,4);
insert into address ( city, state, street, zip, student_id) values ('NY City','NY','1005 N 4th St.',52557,5);
insert into address ( city, state, street, zip, student_id) values ('Washington DC','CL','1006 N 4th St.',52557,6);
insert into address ( city, state, street, zip, student_id) values ('Huston','TX','1007 N 4th St.',52557,7);
insert into address ( city, state, street, zip, student_id) values ('Dallas','TX','1008 N 4th St.',52557,8);
insert into address ( city, state, street, zip, student_id) values ('Alaska','AL','1009 N 4th St.',52557,9);
insert into address ( city, state, street, zip, student_id) values ('Virginia','VI','1010 N 4th St.',52557,10);



insert into job_advertisement (benefits, company_name, description, student_id) values ('3000$','Amazon','Java Backend Developer',1);
insert into job_advertisement (benefits, company_name, description, student_id) values ('4000$','Google','Senior Data Analyst',2);
insert into job_advertisement (benefits, company_name, description, student_id) values ('5000$','Microsoft','DevOps Engineer',3);
insert into job_advertisement (benefits, company_name, description, student_id) values ('6000$','Apple','iOS Developer',4);
insert into job_advertisement (benefits, company_name, description, student_id) values ('4000$','Asus','Fullstack Developer',2);
insert into job_advertisement (benefits, company_name, description, student_id) values ('5600','Asus','System Analyst',2);
insert into job_advertisement (benefits, company_name, description, student_id) values ('7800$','Asus','Graphic Designer',2);
insert into job_advertisement (benefits, company_name, description, student_id) values ('9400$','Asus','Project Manager',2);
insert into job_advertisement (benefits, company_name, description, student_id) values ('4300$','Asus','React Developer',3);

insert into address ( city, state, street, zip, job_ad_id) values ('Fairfield','IA','1007 N 4th St.',52557,1);
insert into address ( city, state, street, zip, job_ad_id) values ('Burlington','IA','1008 N 4th St.',52557,2);
insert into address ( city, state, street, zip, job_ad_id) values ('Iowa','IA','1009 N 4th St.',52557,3);
insert into address ( city, state, street, zip, job_ad_id) values ('Kabul','KB','17th Yakhsazi St.',1010,4);

insert into address ( city, state, street, zip, job_ad_id) values ('Fairfield','IA','1007 N 4th St.',52557,5);
insert into address ( city, state, street, zip, job_ad_id) values ('Burlington','IA','1008 N 4th St.',52557,6);
insert into address ( city, state, street, zip, job_ad_id) values ('Iowa','IA','1009 N 4th St.',52557,7);
insert into address ( city, state, street, zip, job_ad_id) values ('Kabul','KB','17th Yakhsazi St.',1010,8);
insert into address ( city, state, street, zip, job_ad_id) values ('Balkh','BL','7th St.',1010,9);


insert into job_attachment (name,url,job_advertisement_id) values ('AM-0192','n/a',1);
insert into job_attachment (name,url,job_advertisement_id) values ('GO-042','n/a',2);
insert into job_attachment (name,url,job_advertisement_id) values ('MS-097','n/a',3);
insert into job_attachment (name,url,job_advertisement_id) values ('AP-002','n/a',4);

insert into job_advertisement_tags values (1,1);
insert into job_advertisement_tags values (1,2);
insert into job_advertisement_tags values (2,9);
insert into job_advertisement_tags values (3,8);
insert into job_advertisement_tags values (4,5);

insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Bank Of America','n/a','07/22/1989','12/30/1999',1);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('CNBC','n/a','01/01/2000','12/30/2015',1);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('CNBC','n/a','12/30/2015','12/30/2021',1);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Ford','n/a','07/22/1989','12/30/1999',2);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Honda','n/a','01/01/2000','12/30/2015',2);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Microsoft','n/a','12/30/2015','12/30/2021',2);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Yahoo','n/a','07/22/1989','12/30/1999',3);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Apple','n/a','01/01/2000','12/30/2015',3);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('pfizer','n/a','12/30/2015','12/30/2021',3);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Suzuki','n/a','07/22/1989','12/30/1999',4);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Q&Q','n/a','01/01/2000','12/30/2015',4);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('KFC','n/a','12/30/2015','12/30/2021',4);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Fossil','n/a','07/22/1989','12/30/1999',5);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Lenovo','n/a','01/01/2000','12/30/2015',5);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Dell','n/a','12/30/2015','12/30/2021',5);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('IBM','n/a','07/22/1989','12/30/1999',6);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Pizza Ranch','n/a','01/01/2000','12/30/2015',6);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Pizza Hut','n/a','12/30/2015','12/30/2021',6);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Tata','n/a','07/22/1989','12/30/1999',7);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Motorola','n/a','01/01/2000','12/30/2015',7);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('SAMSUNG','n/a','12/30/2015','12/30/2021',7);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Panasonic','n/a','07/22/1989','12/30/1999',8);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('LG','n/a','01/01/2000','12/30/2015',8);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Sony','n/a','12/30/2015','12/30/2021',8);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Nokia','n/a','07/22/1989','12/30/1999',9);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Google','n/a','01/01/2000','12/30/2015',9);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Facebook','n/a','12/30/2015','12/30/2021',9);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('VW','n/a','07/22/1989','12/30/1999',10);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('BMW','n/a','01/01/2000','12/30/2015',10);
insert into professional_experience ( company_name, description, finish_date, start_date, student_id) values ('Audi','n/a','12/30/2015','12/30/2021',10);

insert into professional_experience_tags (professional_experience_id, tags_id) values (1,1);
insert into professional_experience_tags (professional_experience_id, tags_id) values (1,2);
insert into professional_experience_tags (professional_experience_id, tags_id) values (2,3);
insert into professional_experience_tags (professional_experience_id, tags_id) values (2,4);
insert into professional_experience_tags (professional_experience_id, tags_id) values (3,1);
insert into professional_experience_tags (professional_experience_id, tags_id) values (4,6);
insert into professional_experience_tags (professional_experience_id, tags_id) values (5,5);
insert into professional_experience_tags (professional_experience_id, tags_id) values (6,8);
insert into professional_experience_tags (professional_experience_id, tags_id) values (7,9);
insert into professional_experience_tags (professional_experience_id, tags_id) values (8,2);
insert into professional_experience_tags (professional_experience_id, tags_id) values (8,3);
insert into professional_experience_tags (professional_experience_id, tags_id) values (8,4);
insert into professional_experience_tags (professional_experience_id, tags_id) values (9,1);
insert into professional_experience_tags (professional_experience_id, tags_id) values (10,10);
insert into professional_experience_tags (professional_experience_id, tags_id) values (10,9);

insert into Job_Application (student_id,job_advertisement_id) values (2,1);
insert into Job_Application (student_id,job_advertisement_id) values (8,1);
insert into Job_Application (student_id,job_advertisement_id) values (9,1);
insert into Job_Application (student_id,job_advertisement_id) values (10,1);
insert into Job_Application (student_id,job_advertisement_id) values (3,2);
insert into Job_Application (student_id,job_advertisement_id) values (5,2);
insert into Job_Application (student_id,job_advertisement_id) values (6,3);
insert into Job_Application (student_id,job_advertisement_id) values (10,4);

insert into faculty (active, email, first_name, last_name,username) values (true,'f1@keycloak.org','Mubarak','Jemal Ali','mja');
insert into faculty (active, email, first_name, last_name,username) values (true,'f2@keycloak.org','Mateus','Jose','mj');
insert into faculty (active, email, first_name, last_name,username) values (true,'f3@keycloak.org','Hassan','Ahmad','ha');
insert into faculty (active, email, first_name, last_name,username) values (true,'f4@keycloak.org','Sharif','Stanekzai','ss');

insert into feedback (comments,faculty_id,student_id) values ('n/a',1,1);
insert into feedback (comments,faculty_id,student_id) values ('n/a',2,2);
insert into feedback (comments,faculty_id,student_id) values ('n/a',3,3);
insert into feedback (comments,faculty_id,student_id) values ('n/a',4,4);
insert into feedback (comments,faculty_id,student_id) values ('n/a',1,5);
insert into feedback (comments,faculty_id,student_id) values ('n/a',2,6);
insert into feedback (comments,faculty_id,student_id) values ('n/a',3,7);
insert into feedback (comments,faculty_id,student_id) values ('n/a',4,8);
insert into feedback (comments,faculty_id,student_id) values ('n/a',1,9);
insert into feedback (comments,faculty_id,student_id) values ('n/a',2,10);







