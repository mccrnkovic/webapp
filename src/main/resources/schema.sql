CREATE TABLE IF NOT EXISTS hardware (
    code INT NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE,
    type VARCHAR(7),
    amount INT
);

CREATE TABLE IF NOT EXISTS review (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(20),
    text VARCHAR(60),
    rating INT,
    hardwareCode INT NOT NULL,
    FOREIGN KEY (hardwareCode) REFERENCES hardware(code)
    );