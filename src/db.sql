DROP DATABASE IF EXISTS jarcompany;

CREATE database jarcompany;

USE jarcompany;


CREATE TABLE Department(
DepartmentID INT PRIMARY KEY AUTO_INCREMENT,
Name varchar(20) NOT NULL
);

CREATE TABLE Employee(
employeeNumber int PRIMARY KEY AUTO_INCREMENT,
Name varchar(45) NOT NULL,
Address varchar(150) NOT NULL,
Email varchar(150) NOT NULL, 
NI char(9) NOT NULL, 
accountNumber char(8) NOT NULL, 
sortCode char(6) NOT NULL, 
startingSalary float(8,2) NOT NULL,
DepartmentID INT NULL,
CONSTRAINT `fk_department` FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

INSERT INTO Department (Name) VALUES ('Sales'), ('Accounting'), ('Manufacturing');

INSERT INTO Employee (Name,Address,Email,NI,accountNumber,sortCode,startingSalary, DepartmentID)
VALUES ('Bruce Wayne','Boston','rnd@kainos.com','12345678','SS12345C','42060','50000', 1);

SELECT * FROM Employee;