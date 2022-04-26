CREATE TABLE IF NOT EXISTS hardware (
    Code INT NOT NULL PRIMARY KEY,
    Name VARCHAR(100),
    Price DOUBLE,
    Type VARCHAR(5),
    Amount INT
);