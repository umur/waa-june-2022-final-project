INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_STUDENT');
INSERT INTO roles(name) VALUES('ROLE_FACULTY');

INSERT INTO public.users(email, "password", username)
VALUES('subo@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'student');

INSERT INTO public.users(email, "password", username)
VALUES('faculty@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'faculty');

INSERT INTO public.users(email, "password", username)
VALUES('admin@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'admin');

INSERT INTO public.user_roles(user_id, role_id)VALUES(1, 3);
INSERT INTO public.user_roles(user_id, role_id)VALUES(2, 4);
INSERT INTO public.user_roles(user_id, role_id)VALUES(3, 2);

INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 1);
INSERT INTO public.address(city, state, street, zip, id_user)
VALUES('Fairfield', 'IA', '106 S D S', '52556', 2);

