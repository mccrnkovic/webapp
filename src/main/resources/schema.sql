CREATE TABLE IF NOT EXISTS hardware (
    hardware_code INT NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE,
    type VARCHAR(7),
    stock INT
);

CREATE TABLE IF NOT EXISTS review (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(20),
    text VARCHAR(60),
    rating INT,
    hardware_code INT NOT NULL,
    FOREIGN KEY (hardware_code) REFERENCES hardware(hardware_code) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS `user` (
    id INT NOT NULL PRIMARY KEY,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS authority (
    id INT NOT NULL PRIMARY KEY,
    authority_name VARCHAR(16)
    );

CREATE TABLE IF NOT EXISTS user_authority (
    user_id INT NOT NULL,
    authority_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `user`(id) ON DELETE CASCADE,
    FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE CASCADE
    )