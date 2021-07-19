CREATE EXTENSION pgcrypto;
INSERT INTO languages (language) VALUES ('ENGLISH');
INSERT INTO languages (language) VALUES ('SWEDISH');

INSERT INTO Users (name,password,email,native_language_id,learning_language1_id) VALUES ('User1',crypt('password1',gen_salt('bf')),'email1',1,2);
INSERT INTO Users (name,password,email,native_language_id,learning_language1_id) VALUES ('User2',crypt('password1',gen_salt('bf')),'email2',1,2);
INSERT INTO Users (name,password,email,native_language_id,learning_language1_id) VALUES ('User3',crypt('password1',gen_salt('bf')),'email3',1,2);
INSERT INTO Users (name,password,email,native_language_id,learning_language1_id) VALUES ('User4',crypt('password1',gen_salt('bf')),'email4',1,2);

alter table Users
    add foreign key (native_language_id) references languages;
alter table Users
    add foreign key (learning_language1_id) references languages;
