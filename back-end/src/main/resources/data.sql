INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_STUDENT');
INSERT INTO roles(name) VALUES('ROLE_FACULTY');

INSERT INTO public.tags("name")VALUES('javascript');
INSERT INTO public.tags("name")VALUES('java');
INSERT INTO public.tags("name")VALUES('front-end');
INSERT INTO public.tags("name")VALUES('back-end');
INSERT INTO public.tags("name")VALUES('rest-api');
INSERT INTO public.tags("name")VALUES('python');
INSERT INTO public.tags("name")VALUES('security');
INSERT INTO public.tags("name")VALUES('ux-ui');
INSERT INTO public.tags("name")VALUES('web-development');
INSERT INTO public.tags("name")VALUES('react');
INSERT INTO public.tags("name")VALUES('spring-boot');

INSERT INTO public.users(email, "password", username, first_name, last_name, logged_at)
VALUES('subo@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'student', 'George', 'Bush', '2022-07-09 10:22:49.828');
INSERT INTO public.users(email, "password", username, first_name, last_name, logged_at)
VALUES('stu1@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'student1', 'Steve', 'Nash', '2022-07-10 19:26:49.828');
INSERT INTO public.users(email, "password", username, first_name, last_name, logged_at)
VALUES('stu2@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'student2', 'David', 'You', '2022-07-07 12:25:49.828');

INSERT INTO public.users(email, "password", username)
VALUES('faculty@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'faculty');

INSERT INTO public.users(email, "password", username)
VALUES('admin@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'admin');

INSERT INTO public.user_roles(user_id, role_id)VALUES(1, 3);
INSERT INTO public.user_roles(user_id, role_id)VALUES(2, 3);
INSERT INTO public.user_roles(user_id, role_id)VALUES(3, 3);
INSERT INTO public.user_roles(user_id, role_id)VALUES(4, 4);
INSERT INTO public.user_roles(user_id, role_id)VALUES(5, 2);

INSERT INTO public.student(gpa, major, student_id, user_id)
VALUES(4, 'CS', 613777, 1);
INSERT INTO public.student(gpa, major, student_id, user_id)
VALUES(3, 'CS', 614800, 2);
INSERT INTO public.student(gpa, major, student_id, user_id)
VALUES(4, 'MBA', 623177, 3);

INSERT INTO public."comments"("comment", commenter, student_id, post_time)
VALUES('He is genius', 'faculty', 1, '2022-07-09 17:22:49.828');
INSERT INTO public."comments"("comment", commenter, student_id, post_time)
VALUES('I Like him', 'faculty', 1, '2022-07-09 17:22:49.828');
INSERT INTO public."comments"("comment", commenter, student_id, post_time)
VALUES('He is very punctual', 'admin', 1, '2022-07-09 17:22:49.828');


INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 1);
INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 2);
INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 3);
INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 4);
INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 5);

INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Facebook', 'CA','San Francisco','High Salary', 'Senior UX Developer, Web Experience at Indeed Senior UX Developers, Web Experience at Indeed serve a critical role in getting designs into production, bridging the design and engineering organizations. Senior UX Developers work with a cross-functional team to build accessible user interfaces for our products; create fast, scalable, maintainable, and secure systems; define best practices in UI development; and contribute to design ideation and decision making', '2022-07-09 17:22:49.828', 184000, 'Senior UX Developer, Web Experience');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Deers', 'IA','Fairfield','Dental Insurance', 'We are seeking an energetic, Software Developer, with 3-5 years under their belt, to join our growing team of software developers, helping to drive innovation in the Architecture Engineering and Construction (AEC) Industry. We work with a wide range of technologies and APIs to help our customers achieve productivity enhancements and increase their return on investment in Autodesk software products', '2022-07-09 16:22:49.828', 105000, 'Full Stack Developer ReactJS/.NETCore Autodesk Forge + BIM360');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Apple', 'TX','Austin','Paid time off', 'UX Developers, Employer at Indeed serve a critical role evolving concepts and designs into production for the Indeed Employer website experience. They specialize in bridging the gap between design and engineering, executing and advocating high-quality UX standards and best practices.', '2022-07-09 15:22:49.828', 159000, 'UX Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Amazon', '','Remote','401k', 'Opportunity for an Android Developer to join a rapidly growing healthcare company focused on leveraging information technology to aid in population health and improving health outcomes.The Android app developer will work with our team of talented engineers to design and build the next generation of our mobile applications. Android programming works closely with other app development and technical teams.', '2022-07-09 14:22:49.828', 70000, 'Android Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Amgen', 'FL','Tampa','Flexible Schedule', 'U.S. citizenship required (defined by federal contract): Required Education: Bachelor’s in Computer Science, Computer Engineering, Mathematics, Physics or related field or possess relevant experience in lieu of education Preferred Education: Master’s or PhD in Computer Science, Computer Engineering, Mathematics, Physics or related field', '2022-07-09 13:22:49.828', 120000, 'Software Engineer - Front End');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('IDT Corporation', 'CA','San Francisco','Relocation assistance', 'Our client is one of the world’s leading digital performance-based marketing companies, dedicated to providing superior results for our advertisers and media partners. They accomplish this by combining best-in-class expertise in media optimization and targeting with our in-house analytics and big-data technology. Our client has a strong analytical focus that requires quick reaction in this fast-paced environment. Our success is fueled by employee innovation, data driven decisions and a startup mentality. Our teams are comprised of Software Engineers, Web Developers, Media Buyers, Account Managers and Business Intelligence Analysts. This position is available in their Fort Myers office right across from GCTC. Employees enjoy free lunches, free benefits, unlimited time off, no dress code and company team building trips.', '2022-07-09 12:22:49.828', 130000, 'Senior Android Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('T-Mobile', 'WA','Seattle','Employee assistance program', 'Multi-unit business operators often find accounting and payroll to be frustrating and expensive. InfoSync provides the people and technology so they can focus on their core business.With over 10,000 locations using our services across 80 different brands, InfoSync is the leading provider of outsourcing services for multi-unit businesses.', '2022-07-09 11:22:49.828', 110000, 'Senior Application Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Spotify', 'NJ','New Ark','Health Insurance', 'Responsibilities of a Full Stack Developer:Use different front-end Technologies to build interactive User Interfaces.Should be able to design robust backend architecture using different technologies to retrieve data from the servers.Creating databases and servers that are resistant to outages and work endlessly.Ensuring cross-platform compatibility by creating applications that work on different platforms.Based on the type of application the developer is responsible for the creation of API.The developer is responsible for building flexible applications that meet consumer requirements.', '2022-07-09 10:22:49.828', 159205, 'Java Full Stack Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Square', 'CA','Los Angeles','Life Insurance', 'Responsibilities of a Full Stack Developer:Use different front-end Technologies to build interactive User Interfaces.Should be able to design robust backend architecture using different technologies to retrieve data from the servers.Creating databases and servers that are resistant to outages and work endlessly.Ensuring cross-platform compatibility by creating applications that work on different platforms.Based on the type of application the developer is responsible for the creation of API.The developer is responsible for building flexible applications that meet consumer requirements.', '2022-07-09 09:22:49.828', 133000, 'Python Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Vivo', 'IL','Goodfield','', 'GetUWired’s junior web developers work with our project managers and other developers to update, maintain and craft custom websites. They also implement marketing strategies associated with membership sites, newsletter signups, and various CRM platforms. This position uses both frontend and backend technologies…', '2022-07-08 16:22:49.828', 115000, 'Junior Web Developer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('IBM', 'TX','Austin','401k', 'Traject Data powers business insights for many household internet brands and trendsetters in the digital marketing space. We’re looking to add a backend engineer to our team. This is the perfect opportunity for you if you are passionate about building solutions with modern cloud and data technologies and are interested in working in the digital marketing | SEO space. The ideal candidate is a capable backend engineer that can demonstrate prior experience building and scaling cloud-native data-centric applications specifically using Node.js, AWS and MYSQL.', '2022-07-08 17:22:49.828', 140000, 'Backend Engineer');
INSERT INTO public.job_advertisement(company, states, city, benefit, description, posted, salary, title)
VALUES('Woongjin Inc', 'NJ','Ridgefield Park','401k', 'Signify Technology is partnered with a client who is seeking a Frontend Software Developer to join their team! Successful candidates will have the ability to make an immediate impact in delivering highly scalable solutions as our client continues to expand their userbase and service offerings.', '2022-07-08 18:22:49.828', 200000, 'Frontend Developer');

INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(1,1);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(1,3);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(2,1);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(2,5);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(2,8);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(2,4);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(2,2);
INSERT INTO public.jobs_tags(jobs_id, tags_id)VALUES(3,1);
