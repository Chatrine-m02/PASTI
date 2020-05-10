CREATE DATABASE siakad;
USE siakad;
CREATE TABLE Mahasiswa(
nim INT(15) PRIMARY KEY,
nama VARCHAR(30),
jurusan VARCHAR(30),
email VARCHAR(30),
alamat VARCHAR(50))

INSERT INTO Mahasiswa VALUES (11318043,"Chatrine","D3 Teknologi Informasi 2018","chatrine.manurung2001@gmail.com","Aeknatolu")
SELECT * FROM Mahasiswa