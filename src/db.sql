CREATE database jarcompany;

USE jarcompany;


CREATE USER 'jaruser'@'localhost' IDENTIFIED by 'password';
GRANT select on jarcompany.* TO jaruser@localhost;

create table Employee( Name varchar(45) NOT NULL, Address varchar(150) NOT NULL, Email varchar(150) NOT NULL, NI char(9) NOT NULL, accountNumber char(8) NOT NULL, sortCode char(6) NOT NULL, startingSalary double(8,2) NOT NULL, employeeNumber int PRIMARY KEY AUTO_INCREMENT);

INSERT INTO Employee (Name,Address,Email,NI,accountNumber,sortCode,startingSalary) VALUES ('Bruce Wayne','Boston','rnd@kainos.com','12345678','SS12345C','42060','50000');

ALTER TABLE Employee
ADD COLUMN Department varchar(20) NULL;

