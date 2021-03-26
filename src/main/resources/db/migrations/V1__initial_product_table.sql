create table if not exists pricing
(
    id                     integer
        constraint id_pk
            primary key,

    product_name           varchar not null,

    first_attribute_id     integer,
    first_attribute_name   varchar,

    second_attribute_id    integer,
    second_attribute_name  varchar,

    third_attribute_id     integer,
    third_attribute_name   varchar,

    fourth_attribute_id    integer,
    fourth_attribute_name  varchar,

    fifth_attribute_id     integer,
    fifth_attribute_name   varchar,

    sixth_attribute_id     integer,
    sixth_attribute_name   varchar,

    seventh_attribute_id   integer,
    seventh_attribute_name varchar,

    eighth_attribute_id    integer,
    eighth_attribute_name  varchar,

    ninth_attribute_id     integer,
    ninth_attribute_name   varchar,

    tenth_attribute_id     integer,
    tenth_attribute_name   varchar
);

create index pricing_product_name_index on pricing (product_name);
create index pricing_first_attribute_name_index on pricing (first_attribute_name);
create index pricing_second_attribute_name_index on pricing (second_attribute_name);
create index pricing_third_attribute_name_index on pricing (third_attribute_name);
create index pricing_fourth_attribute_name_index on pricing (fourth_attribute_name);
create index pricing_fifth_attribute_name_index on pricing (fifth_attribute_name);
create index pricing_sixth_attribute_name_index on pricing (sixth_attribute_name);
create index pricing_seventh_attribute_name_index on pricing (seventh_attribute_name);
create index pricing_eighth_attribute_name_index on pricing (eighth_attribute_name);
create index pricing_ninth_attribute_name_index on pricing (ninth_attribute_name);
create index pricing_tenth_attribute_name_index on pricing (tenth_attribute_name);
