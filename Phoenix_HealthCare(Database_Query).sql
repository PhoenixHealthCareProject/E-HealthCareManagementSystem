use phoenix;
CREATE TABLE user (
    userId int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255),
    password varchar(255),
    PRIMARY KEY (userId)
);
desc user;
ALTER TABLE user AUTO_INCREMENT=100;
INSERT INTO user (name,email,password) VALUES ('Anjali Kushwaha','anjali@gmail.com','anjali');
INSERT INTO user (name,email,password) VALUES ('Dhairyasheel Nikam','dhairya@gmail.com','dhairya');
INSERT INTO user (name,email,password) VALUES ('Kaushal Mutange','kaushal@gmail.com','kaushal');
INSERT INTO user (name,email,password) VALUES ('Divya Dhande','divya@gmail.com','divya');
select * from user;
CREATE TABLE feedback (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    email varchar(255),
    phone varchar(255),
    feedback text,
    PRIMARY KEY (id)
);