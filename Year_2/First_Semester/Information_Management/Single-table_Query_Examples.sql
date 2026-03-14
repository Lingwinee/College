use sample11052;

select * from department;
select * from employee;

-- 1. Display the employee ID, last name, firstname, and birthdate of all employees
-- projection
-- column alias
select empID, lastname, firstname, birthdate from employee;
select empID "Employee ID" ,lastName "Last Name", firstName "First Name",
birthdate "Date of Birth" from employee;

-- 2. Display records of all employees according to salary in ascendeng order
select * from employee order by salary;

-- 3. Display records of all employees according to lastName in descending order
--     and firstname in ascendeng order
select * from employee order by lastName desc, firstName;
 
 -- 4. Display names of all employees ang their age. For name, concatenate first name
 --     and last name separated by a space. Sort the list according age
 --     in descending order
 select concat(firstName, " ", lastName) "Employee Name",
 truncate(datediff(curdate(), birthdate)/365,0) "Age" from employee
 order by truncate(datediff(curdate(), birthdate)/365,0) desc;

-- 5. Display records of employees who were born in the year 1995
select * from employee where birthdate>='1995-01-01' and birthdate<='1995-12-31';
-- or
select * from employee where birthdate between '1995-01-01' and '1995-12-31';

-- 6. Display records of employees who do not have a parking space
select * from employee where parkingSpace is null;

-- 7. Display records of employees who have a parking space
select * from employee where parkingSpace is not null;

-- 8. Display records of employees whose lastname starts with 'S'
select * from employee where lastname like 'S%';

-- 9. Display the birth year of all employees. Sort the list according to birth year in
--     ascending order. Suppress duplicate rows.
select distinct year(birthdate) "Birth Year "from employee order by year(birthdate);

-- 10. How many employees are in the company?
select count(*) "Count of Employees" from employee;

-- 11. What is the average salary of all employees?
select round(avg(salary),2) "Average Salary" from employee;

-- 12. How many male and female employees are in the company?
select gender "Gender", count(*) "Count of Employees" from employee
group by gender;

-- 13. How many male employees are there in each department?
--       Sort the list according to the count of employees in ascending order.
select depCode "Department Code", count(*) "Count of Male Employees"
from employee
where gender='M'
group by depCode
order by count(*);

-- 14. Display the average salary of all male employees in each department.
--       Display only those departments in which the average salary exceeds
--      21000. Sort the list according to the average salary in ascending order.
select depcode "Department Code", round(avg(salary),2) "Average Salary"
from employee
where gender='M'
group by depCode
having round(avg(salary),2)>21000
order by round(avg(salary),2);




