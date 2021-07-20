CREATE EXTENSION pgcrypto;
INSERT INTO languages (language)
VALUES ('ENGLISH'),
       ('SWEDISH'),
       ('RUSSIAN');


INSERT INTO Users (name, password, email, native_language_id, learning_language1_id)
VALUES ('User1', crypt('password1', gen_salt('bf')), 'email1', 3, 2),
       ('User2', crypt('password1', gen_salt('bf')), 'email2', 3, 1),
       ('User3', crypt('password1', gen_salt('bf')), 'email3', 2, 1),
       ('User4', crypt('password1', gen_salt('bf')), 'email4', 1, 2);



-- alter table Users
--     add foreign key (native_language_id) references languages;
-- alter table Users
--     add foreign key (learning_language1_id) references languages;
