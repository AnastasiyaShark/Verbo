create sequence user_seq;
create table users
(
    id                   int     not null primary key default nextval('user_seq'),
    name                 varchar not null,
    password             varchar not null,
    email                varchar not null,
    native_language_id   int,
    learning_language_id int
--     learning_language2_id int
);
comment on table users is 'пользователи';
comment on column users.id is 'id в системе';
comment on column users.name is 'имя пользователя (nickname)';
comment on column users.password is 'пароль пользователя';
comment on column users.email is 'почта пользователя';
comment on column users.native_language_id is 'родной язык пользователя';
comment on column users.learning_language_id is 'изучаемый язык пользователя';
-- comment on column users.learning_language2_id is ' second изучаемый язык пользователя';


create sequence language_seq;
create table languages
(
    id       int not null primary key default nextval('language_seq'),
    language varchar
);
comment on table languages is 'языки';
comment on column languages.id is 'id в системе';
comment on column languages.language is 'название языка';


create sequence vocabulary_seq;
create table vocabularies
(
    id                       int     not null primary key default nextval('vocabulary_seq'),
    user_id                  varchar not null,
    swedish_verb_id          int,
    swedish_particle_verb_id int,
    english_verb_id          int,
    english_particle_verb_id int,
    status_id                int     not null
);
comment on table vocabularies is 'словари';
comment on column vocabularies.id is 'id в системе';
comment on column vocabularies.user_id is 'id пользователя,чей словарь';
comment on column vocabularies.swedish_verb_id is 'id изучаемого шведского глагола';
comment on column vocabularies.swedish_particle_verb_id is 'id изучаемого шведского фразового глагола';
comment on column vocabularies.english_verb_id is 'id изучаемого английского глагола';
comment on column vocabularies.english_particle_verb_id is 'id изучаемого английского фразового глагола';
comment on column vocabularies.status_id is 'id статуса глагола в словаре';

create sequence status_seq;
create table statuses
(
    id     int not null primary key default nextval('status_seq'),
    status varchar
);
comment on table statuses is 'статус глагола в словаре';
comment on column statuses.id is 'id в системе';
comment on column statuses.status is 'название статуса глагола в словаре';


create sequence english_verb_seq;
create table english_verbs
(
    id              int not null primary key default nextval('english_verb_seq'),
--     imperative      varchar,
    base_form       varchar,
    present_tense   varchar,
    past            varchar,
    past_participle varchar,
    picture_id      int,
    returnability   boolean,
    regular         boolean
);
comment on table english_verbs is 'английский глагол';
comment on column english_verbs.id is 'id в системе';
-- comment on column english_verbs.imperative is 'форма императива';
comment on column english_verbs.base_form is 'базовая форма глагола';
comment on column english_verbs.present_tense is 'форма настоящего времени';
comment on column english_verbs.past is 'форма прошедшего времени (V2)';
comment on column english_verbs.past_participle is 'форма прошедшего времени (V3)';
comment on column english_verbs.picture_id is 'id изображения';
comment on column english_verbs.returnability is 'возвратность глагола';
comment on column english_verbs.regular is 'правильность глагола';


create sequence english_particle_verb_seq;
create table english_particle_verbs
(
    id              int not null primary key default nextval('english_particle_verb_seq'),
    english_verb_id int,
    preposition1_id int,
    preposition2_id int,
    picture_id      int
--     reflexive_pronoun         boolean
);
comment on table english_particle_verbs is 'английский фразовый глагол';
comment on column english_particle_verbs.id is 'id в системе';
comment on column english_particle_verbs.english_verb_id is 'id английского глагола';
comment on column english_particle_verbs.preposition1_id is 'id первого предлога';
comment on column english_particle_verbs.preposition2_id is 'id второго предлога';
comment on column english_particle_verbs.picture_id is 'id изображения';


create sequence english_preposition_seq;
create table english_prepositions
(
    id          int not null primary key default nextval('english_preposition_seq'),
    preposition varchar

);
comment on table english_prepositions is 'английский предлог';
comment on column english_prepositions.id is 'id в системе';
comment on column english_prepositions.preposition is 'английский предлог';


create sequence english_verbs_translation_seq;
create table english_verbs_translation
(
    id                       int not null primary key default nextval('english_verbs_translation_seq'),
    english_verb_id          int,
    swedish_verb_id          int,
    russian_verb_id          int,
    swedish_particle_verb_id int
);
comment on table english_verbs_translation is 'перевод английского глагола';
comment on column english_verbs_translation.id is 'id в системе';
comment on column english_verbs_translation.english_verb_id is 'id английского глагола';
comment on column english_verbs_translation.swedish_verb_id is 'id шведского глагола';
comment on column english_verbs_translation.russian_verb_id is 'id русского глагола';
comment on column english_verbs_translation.swedish_particle_verb_id is 'id шведского фразового глагола';


create sequence english_particle_verbs_translation_seq;
create table english_particle_verbs_translation
(
    id                       int not null primary key default nextval('english_particle_verbs_translation_seq'),
    english_particle_verb_id int,
    swedish_verb_id          int,
    russian_verb_id          int,
    swedish_particle_verb_id int
);
comment on table english_particle_verbs_translation is 'перевод английского фразового глагола';
comment on column english_particle_verbs_translation.id is 'id в системе';
comment on column english_particle_verbs_translation.english_particle_verb_id is 'id английского фразового глагола';
comment on column english_particle_verbs_translation.swedish_verb_id is 'id шведского глагола';
comment on column english_particle_verbs_translation.russian_verb_id is 'id русского глагола';
comment on column english_particle_verbs_translation.swedish_particle_verb_id is 'id шведского фразового глагола';


create sequence swedish_verb_seq;
create table swedish_verbs
(
    id            int not null primary key default nextval('swedish_verb_seq'),
    imperative    varchar,
    infinitive    varchar,
    presens       varchar,
    preteritum    varchar,
    supinum       varchar,
    group_id      int,
    picture_id    int,
    returnability boolean,
    regular       boolean
);
comment on table swedish_verbs is 'шведский глагол';
comment on column swedish_verbs.id is 'id в системе';
comment on column swedish_verbs.imperative is 'форма императива';
comment on column swedish_verbs.infinitive is 'форма инфинитива';
comment on column swedish_verbs.presens is 'форма настоящего времени';
comment on column swedish_verbs.preteritum is 'форма прошедшего времени';
comment on column swedish_verbs.supinum is 'форма прошедшего времени';
comment on column swedish_verbs.group_id is 'id группы глагола';
comment on column swedish_verbs.picture_id is 'id изображения';
comment on column swedish_verbs.returnability is 'возвратность глагола';
comment on column swedish_verbs.regular is 'правильность глагола';

create sequence swedish_particle_verb_seq;
create table swedish_particle_verbs
(
    id              int not null primary key default nextval('swedish_particle_verb_seq'),
    swedish_verb_id int,
    preposition1_id int,
    preposition2_id int,
    picture_id      int
--     reflexive_pronoun         boolean
);
comment on table swedish_particle_verbs is 'шведский фразовый глагол';
comment on column swedish_particle_verbs.id is 'id в системе';
comment on column swedish_particle_verbs.swedish_verb_id is 'id шведского глагола';
comment on column swedish_particle_verbs.preposition1_id is 'id первого предлога';
comment on column swedish_particle_verbs.preposition2_id is 'id второго предлога';
comment on column swedish_particle_verbs.picture_id is 'id изображения';

create sequence swedish_preposition_seq;
create table swedish_prepositions
(
    id          int not null primary key default nextval('swedish_preposition_seq'),
    preposition varchar

);
comment on table swedish_prepositions is 'шведский предлог';
comment on column swedish_prepositions.id is 'id в системе';
comment on column swedish_prepositions.preposition is 'шведский предлог';

create sequence group_swedish_verbs_seq;
create table group_swedish_verbs
(
    id   int not null primary key default nextval('group_swedish_verbs_seq'),
    name varchar

);
comment on table group_swedish_verbs is 'группа шведских глаголов';
comment on column group_swedish_verbs.id is 'id в системе';
comment on column group_swedish_verbs.name is 'название группы шведских глаголов';


create sequence swedish_verbs_translation_seq;
create table swedish_verbs_translation
(
    id                       int not null primary key default nextval('swedish_verbs_translation_seq'),
    swedish_verb_id          int,
    english_verb_id          int,
    russian_verb_id          int,
    english_particle_verb_id int
);
comment on table swedish_verbs_translation is 'перевод шведского глагола';
comment on column swedish_verbs_translation.id is 'id в системе';
comment on column swedish_verbs_translation.swedish_verb_id is 'id шведского глагола';
comment on column swedish_verbs_translation.english_verb_id is 'id английского глагола';
comment on column swedish_verbs_translation.russian_verb_id is 'id русского глагола';
comment on column swedish_verbs_translation.english_particle_verb_id is 'id английского фразового глагола';


create sequence swedish_particle_verbs_translation_seq;
create table swedish_particle_verbs_translation
(
    id                       int not null primary key default nextval('swedish_particle_verbs_translation_seq'),
    swedish_particle_verb_id int,
    english_verb_id          int,
    russian_verb_id          int,
    english_particle_verb_id int
);
comment on table swedish_particle_verbs_translation is 'перевод шведского фразового глагола';
comment on column swedish_particle_verbs_translation.id is 'id в системе';
comment on column swedish_particle_verbs_translation.swedish_particle_verb_id is 'id  шведского фразового глагола';
comment on column swedish_particle_verbs_translation.english_verb_id is 'id английского глагола';
comment on column swedish_particle_verbs_translation.russian_verb_id is 'id русского глагола';
comment on column swedish_particle_verbs_translation.english_particle_verb_id is 'id английского фразового глагола';


create sequence russian_verb_seq;
create table russian_verbs
(
    id         int not null primary key default nextval('russian_verb_seq'),
    presens    varchar,
    picture_id int
);
comment on table russian_verbs is 'русский глагол';
comment on column russian_verbs.id is 'id в системе';
comment on column russian_verbs.presens is 'форма настоящего времени';
comment on column russian_verbs.picture_id is 'id изображения';

create sequence picture_seq;
create table pictures
(
    id    int not null primary key default nextval('picture_seq'),
    name  varchar,
    size  int,
    patch varchar
);
comment on table pictures is 'изображение';
comment on column pictures.id is 'id в системе';
comment on column pictures.name is 'имя изображения';
comment on column pictures.size is 'размер изображения';
comment on column pictures.patch is 'путь к изображению';
















