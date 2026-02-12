use sample11052;

describe employee;
alter table employee modify parkingSpace int;

insert into employee
values (102,'Sy','Kenneth',null,null,null,null);



insert into employee (empID, lastName, firstName)
values (101,'Sy','Mary');
insert into employee (empID, lastName, firstName)
values (103,'Go','Wally');
insert into employee (empID, lastName, firstName)
values (104,'Gao','Nilo');
insert into employee (empID, lastName, firstName)
values (105,'Du','Manuel');

insert into department values ('D1','HR');
insert into department values ('D2','Sales');
insert into department values ('D3','Accounting');

select * from department;
select * from employee;

update employee set depCode='D1' where empid=103;
update employee set depCode='D3' where empid=102;
update employee set birthDate='2000-12-15', salary=25000,
parkingspace=2 where empid=101;
update employee set parkingspace=3 where empid=102;
alter table employee modify gender char;
update employee set gender='M' where empid = 102 or empid=103 or empid=105;
update employee set gender='M' where empid in (102 ,103 ,105);
