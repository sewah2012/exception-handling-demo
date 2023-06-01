CREATE TABLE IF NOT EXISTS ACCOUNTS (
    id uuid  PRIMARY KEY ,
    balance float NOT NULL,
    first_name varchar(25) NOT NULL,
    last_name varchar(25) NOT NULL,
    email varchar(25) NOT NULL,
    version int not null

);