-- first_attribute
create table if not exists first_attribute
(
    first_attribute_id   integer
        constraint first_attribute_id_pk
            primary key,
    first_attribute_name varchar
);

create index first_attribute_first_attribute_name_index on first_attribute (first_attribute_name);

-- second_attribute
create table if not exists second_attribute
(
    second_attribute_id   integer
        constraint second_attribute_id_pk
            primary key,
    second_attribute_name varchar
);

create index second_attribute_second_attribute_name_index on second_attribute (second_attribute_name);

-- third_attribute
create table if not exists third_attribute
(
    third_attribute_id   integer
        constraint third_attribute_id_pk
            primary key,
    third_attribute_name varchar
);

create index third_attribute_third_attribute_name_index on third_attribute (third_attribute_name);

-- fourth_attribute
create table if not exists fourth_attribute
(
    fourth_attribute_id   integer
        constraint fourth_attribute_id_pk
            primary key,
    fourth_attribute_name varchar
);

create index fourth_attribute_fourth_attribute_name_index on fourth_attribute (fourth_attribute_name);

-- fifth_attribute
create table if not exists fifth_attribute
(
    fifth_attribute_id   integer
        constraint fifth_attribute_id_pk
            primary key,
    fifth_attribute_name varchar
);

create index fifth_attribute_fifth_attribute_name_index on fifth_attribute (fifth_attribute_name);

-- sixth_attribute
create table if not exists sixth_attribute
(
    sixth_attribute_id   integer
        constraint sixth_attribute_id_pk
            primary key,
    sixth_attribute_name varchar
);

create index sixth_attribute_sixth_attribute_name_index on sixth_attribute (sixth_attribute_name);

-- seventh_attribute
create table if not exists seventh_attribute
(
    seventh_attribute_id   integer
        constraint seventh_attribute_id_pk
            primary key,
    seventh_attribute_name varchar
);

create index seventh_attribute_seventh_attribute_name_index on seventh_attribute (seventh_attribute_name);

-- eighth_attribute
create table if not exists eighth_attribute
(
    eighth_attribute_id   integer
        constraint eighth_attribute_id_pk
            primary key,
    eighth_attribute_name varchar
);

create index eighth_attribute_first_attribute_name_index on eighth_attribute (eighth_attribute_name);

-- ninth_attribute
create table if not exists ninth_attribute
(
    ninth_attribute_id   integer
        constraint ninth_attribute_id_pk
            primary key,
    ninth_attribute_name varchar
);

create index ninth_attribute_ninth_attribute_name_index on ninth_attribute (ninth_attribute_name);

-- tenth_attribute
create table if not exists tenth_attribute
(
    tenth_attribute_id   integer
        constraint tenth_attribute_id_pk
            primary key,
    tenth_attribute_name varchar
);

create index tenth_attribute_tenth_attribute_name_index on tenth_attribute (tenth_attribute_name);
