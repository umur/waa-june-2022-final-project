-- Add Test student user
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (1, 'Test', 'Student 1', 'teststudent1@gmail.com', 'teststudent1');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (2, 'Test', 'Student 2', 'teststudent2@gmail.com', 'teststudent2');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (3, 'Test', 'Student 3', 'teststudent3@gmail.com', 'teststudent3');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (4, 'Test', 'Student 4', 'teststudent4@gmail.com', 'teststudent4');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (5, 'Test', 'Student 5', 'teststudent5@gmail.com', 'teststudent5');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (6, 'Test', 'Student 6', 'teststudent6@gmail.com', 'teststudent6');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (7, 'Test', 'Student 7', 'teststudent7@gmail.com', 'teststudent7');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (8, 'Test', 'Student 8', 'teststudent8@gmail.com', 'teststudent8');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (9, 'Test', 'Student 9', 'teststudent9@gmail.com', 'teststudent9');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (10, 'Test', 'Student 10', 'teststudent10@gmail.com', 'teststudent10');

INSERT INTO STUDENT(id)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10);

-- Add test faculty user

INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (11, 'Test', 'Faculty 11', 'testfaculty11@gmail.com', 'testfaculty11');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (12, 'Test', 'Faculty 12', 'testfaculty12@gmail.com', 'testfaculty12');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (13, 'Test', 'Faculty 13', 'testfaculty13@gmail.com', 'testfaculty13');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (14, 'Test', 'Faculty 14', 'testfaculty14@gmail.com', 'testfaculty14');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (15, 'Test', 'Faculty 15', 'testfaculty15@gmail.com', 'testfaculty15');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (16, 'Test', 'Faculty 16', 'testfaculty16@gmail.com', 'testfaculty16');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (17, 'Test', 'Faculty 17', 'testfaculty17@gmail.com', 'testfaculty17');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (18, 'Test', 'Faculty 18', 'testfaculty18@gmail.com', 'testfaculty18');
INSERT INTO users (id, first_name, last_name, email, user_name)
VALUES (19, 'Test', 'Faculty 19', 'testfaculty19@gmail.com', 'testfaculty19');


-- Add job tags
INSERT INTO tag(tag_name)
VALUES ('devops'),
       ('java developer'),
       ('senior engineer'),
       ('junior engineer'),
       ('software engineer'),
       ('android developer'),
       ('dot net developer'),
       ('lead engineer'),
       ('project manager'),
       ('frontend developer');

-- JOB advertisement data

INSERT INTO job_advertisement (id, title, company_name, benefits, description, created_by)
VALUES (1, 'Software Engineering II', 'Braintrust', 'N/A',
        'Braintrust is the only network that gives in-demand talent all the freedom of freelance with all the benefits, community and stability of a full-time role. As the first decentralized talent network, our revolutionary Web3 model ensures the community that relies on Braintrust to find work are the same people who own and build it through the blockchain token, BTRST. So unlike other marketplaces that take 20% to 50% of talent earnings, Braintrust allows talent to keep 100% of earnings and to vote on key changes to improve the network. Braintrust is working to change the way freelance works – for good.',
        1);

INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
VALUES (1, 1),
       (1, 2),
       (1, 4),
       (1, 6);


INSERT INTO job_advertisement (id, title, company_name, benefits, description, created_by)
VALUES (2, 'DevOps Engineering', 'KForce', 'N/A',
        'Kforce has a client based out of Portland, OR that is seeking a Remote Full-Stack Cloud Engineering Manager. This position comes with many benefits including: a 401k with a 6% match, immediate vesting, and allows you to live the dream of a flexible lifestyle with truly unlimited PTO. In this role, you will be accountable for the team''s output and growth. You will get the opportunity for hands on technical, and mentoring work, which will vary based on the team''s needs. We are looking ideally for someone who has technical skills, Cloud, and React experience.',
        1);

INSERT INTO tag_job_advertisement_list(job_advertisement_list_id, tag_id)
VALUES (2, 1),
       (2, 3),
       (2, 8),
       (2, 6);

