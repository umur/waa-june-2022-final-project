-- Add Test student user
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10001, 'Test', 'Student 10001', 'teststudent1@gmail.com', 'teststudent1');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10002, 'Test', 'Student 10002', 'teststudent2@gmail.com', 'teststudent2');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10003, 'Test', 'Student 10003', 'teststudent3@gmail.com', 'teststudent3');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10004, 'Test', 'Student 10004', 'teststudent4@gmail.com', 'teststudent4');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10005, 'Test', 'Student 10005', 'teststudent5@gmail.com', 'teststudent5');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10006, 'Test', 'Student 10006', 'teststudent6@gmail.com', 'teststudent6');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10007, 'Test', 'Student 10007', 'teststudent7@gmail.com', 'teststudent7');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10008, 'Test', 'Student 10008', 'teststudent8@gmail.com', 'teststudent8');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10009, 'Test', 'Student 10009', 'teststudent9@gmail.com', 'teststudent9');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10010, 'Test', 'Student 10010', 'teststudent10@gmail.com', 'teststudent10');

INSERT INTO STUDENT(id)
VALUES (10001),
       (10002),
       (10003),
       (10004),
       (10005),
       (10006),
       (10007),
       (10008),
       (10009),
       (10010);

-- Add test faculty user

INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10011, 'Test', 'Faculty 10011', 'testfaculty11@gmail.com', 'testfaculty11');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10012, 'Test', 'Faculty 10012', 'testfaculty12@gmail.com', 'testfaculty12');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10013, 'Test', 'Faculty 10013', 'testfaculty13@gmail.com', 'testfaculty13');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10014, 'Test', 'Faculty 10014', 'testfaculty14@gmail.com', 'testfaculty14');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10015, 'Test', 'Faculty 10015', 'testfaculty15@gmail.com', 'testfaculty15');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10016, 'Test', 'Faculty 10016', 'testfaculty16@gmail.com', 'testfaculty16');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10017, 'Test', 'Faculty 10017', 'testfaculty17@gmail.com', 'testfaculty17');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10018, 'Test', 'Faculty 10018', 'testfaculty18@gmail.com', 'testfaculty18');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10019, 'Test', 'Faculty 10019', 'testfaculty19@gmail.com', 'testfaculty19');


-- Add job tags
INSERT INTO tag(id,tag_name)
VALUES (10001,'devops'),
       (10002,'java developer'),
       (10003,'senior engineer'),
       (10004,'junior engineer'),
       (10005,'software engineer'),
       (10006,'android developer'),
       (10007,'dot net developer'),
       (10008,'lead engineer'),
       (10009,'project manager'),
       (10010,'frontend developer');

-- JOB advertisement data

INSERT INTO job_advertisement (id, title, company_name, benefits, description, created_by)
VALUES (10001, 'Software Engineering II', 'Braintrust', 'N/A',
        'Braintrust is the only network that gives in-demand talent all the freedom of freelance with all the benefits, community and stability of a full-time role. As the first decentralized talent network, our revolutionary Web3 model ensures the community that relies on Braintrust to find work are the same people who own and build it through the blockchain token, BTRST. So unlike other marketplaces that take 10020% to 50% of talent earnings, Braintrust allows talent to keep 100% of earnings and to vote on key changes to improve the network. Braintrust is working to change the way freelance works – for good.',
        10001);

INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
VALUES (10001, 10001),
       (10001, 10002),
       (10001, 10004),
       (10001, 10006);


INSERT INTO job_advertisement (id, title, company_name, benefits, description, created_by)
VALUES (10002, 'DevOps Engineering', 'KForce', 'N/A',
        'Kforce has a client based out of Portland, OR that is seeking a Remote Full-Stack Cloud Engineering Manager. This position comes with many benefits including: a 401k with a 10006% match, immediate vesting, and allows you to live the dream of a flexible lifestyle with truly unlimited PTO. In this role, you will be accountable for the team''s output and growth. You will get the opportunity for hands on technical, and mentoring work, which will vary based on the team''s needs. We are looking ideally for someone who has technical skills, Cloud, and React experience.',
        10001);

INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
VALUES (10002, 10001),
       (10002, 10003),
       (10002, 10008),
       (10002, 10006);

