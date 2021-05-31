CREATE TABLE PRODUCT
(
    id    VARCHAR(100) NOT NULL,
    gauge VARCHAR(60) NOT NULL,
    country_origin VARCHAR(40),
    description varchar(200),
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
