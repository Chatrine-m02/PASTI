CREATE DATABASE myDatabase;
mydatabase

CREATE TABLE login(
userId INT,
userName VARCHAR(100),
PASSWORD VARCHAR(100));

CREATE TABLE Student (
studentID INT,
firstName VARCHAR(100),
lastName VARCHAR(100))

INSERT INTO login VALUE (1,"admin","admin");
INSERT INTO login VALUE (2,"vedang","123456");
INSERT INTO Student VALUE (1,"Wayne","Rooney");
INSERT INTO Student VALUE (2,"Van","Persie");
INSERT INTO Student VALUE (3,"Ryan","Giggs");

SELECT * FROM login
SELECT * FROM Student