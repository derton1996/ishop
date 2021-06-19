CREATE TABLE STRAND_ELECTRO
(
    id    VARCHAR(100) NOT NULL,
    title VARCHAR(100),
    price int,
    gauge VARCHAR(60),
    brand VARCHAR(45),
    country_origin VARCHAR(40),
    description varchar(200),
    image varchar(100),
    primary key (id)
);

CREATE TABLE SALE
(
    id    VARCHAR(100) NOT NULL,
    title VARCHAR(60) NOT NULL,
    description varchar(200),
    image varchar(255),
    primary key (id)
);
