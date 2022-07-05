INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_STUDENT');
INSERT INTO roles(name) VALUES('ROLE_FACULTY');

INSERT INTO public.users(email, "password", username)
VALUES('subo@gmail.com', '$2a$10$u8WolM01.f6TXBWzgctoQ.33R72LEYFnsetQCmvmgD4g5QWRoeTqe', 'subo');

INSERT INTO public.user_roles(user_id, role_id)VALUES(1, 1);