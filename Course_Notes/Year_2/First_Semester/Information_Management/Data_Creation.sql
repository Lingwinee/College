CREATE DATABASE StudentInfo;

USE StudentInfo;
CREATE TABLE Course (
    courseID CHAR(4) PRIMARY KEY,
    courseName VARCHAR(40) NOT NULL
);

CREATE TABLE Student (
    studentID CHAR(3) PRIMARY KEY,
    lastName VARCHAR(15) NOT NULL,
    firstName VARCHAR(15) NOT NULL,
    gender CHAR(1) NOT NULL CHECK (gender IN ('F', 'M')),
    yrLevel INT NOT NULL CHECK (yrLevel BETWEEN 1 AND 4),
    birthdate DATE NOT NULL,
    address VARCHAR(30),
    contact VARCHAR(11),
    courseID CHAR(4),
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

INSERT INTO Course VALUES 
('BSIT', 'BS in Information Technology'),
('BSCS', 'BS in Computer Science'),
('BSIS', 'BS in Information Systems');

INSERT INTO Student (studentID, lastName, firstName, gender, yrLevel, birthdate, address, contact, courseID) VALUES
('S01', 'Reyes', 'Anna', 'F', 1, '2005-03-15', 'Banilad, Cebu', '09171234567', 'BSIT'),
('S02', 'Cruz', 'John', 'M', 2, '2004-01-10', 'Mandaue City', '09181234567', 'BSIT'),
('S03', 'Tan', 'Kim', 'F', 3, '2003-05-25', NULL, '09192345678', 'BSIT'),
('S04', 'Lim', 'Mark', 'M', 4, '2002-09-09', NULL, '09203456789', 'BSCS'),
('S05', 'Lopez', 'Maria', 'F', 1, '2005-07-19', 'Talisay City', NULL, 'BSCS'),
('S06', 'Torres', 'Alex', 'M', 2, '2004-04-04', 'Lapu-Lapu City', '09354567890', 'BSCS'),
('S07', 'Santos', 'Ella', 'F', 3, '2003-11-22', 'Cebu City', '09465678901', 'BSIS'),
('S08', 'Garcia', 'Luke', 'M', 4, '2002-02-14', 'Mandaue City', '09576789012', 'BSIS'),
('S09', 'Chua', 'Ivy', 'F', 1, '2005-08-30', NULL, NULL, 'BSIS'),
('S10', 'Fernandez', 'Ryan', 'M', 2, '2004-06-12', 'Consolacion', '09687890123', 'BSIT');

UPDATE Student
SET address = '123 Colon St., Cebu City',
    contact = '4179511'
WHERE studentID = 'S01';

ALTER TABLE Student
ADD COLUMN grade DECIMAL(3,1);

UPDATE Student
SET grade = 1.0;

SELECT * FROM Student;
SELECT * FROM Course;