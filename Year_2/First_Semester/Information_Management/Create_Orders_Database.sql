create database orders;
use orders;

create table customer
( custID char(3) primary key,
custLastName varchar(15) not null,
custFirstName varchar(15) not null,
custAddress varchar(30),
custGender char not null,
contact varchar(11)
);

create table product
( prodID char(3) primary key,
prodName varchar(40) not null,
category char not null,
uPrice decimal(7,2) not null,
qtyInStock integer not null,
reorderPt integer not null
);

create table orderheader
( orderID char(3) primary key,
orderDate date not null,
custID char(3),
deliveryDate date not null,
foreign key (custID) references customer (custID)
on delete set null on update cascade
);

create table orderdetail
( orderID char(3),
prodID char(3),
qtyOrdered integer not null,
price decimal(7,2) not null,
primary key (orderID, prodID),
foreign key (orderID) references orderheader (orderID) on delete cascade on update cascade,
foreign key (prodID) references product (prodID) on delete cascade on update cascade
);

insert into customer
values ('101', 'Wang', 'Nene', 'Cebu City', 'F', '2721135');
insert into customer
values ('102', 'Gao', 'Nilo', 'Lapulapu City', 'M', null);
insert into customer
values ('103', 'Kho', 'Zena', 'Cebu City', 'F', null);
insert into customer
values ('104', 'Co', 'Nelly', null, 'F', '09172943012');
insert into customer
values ('105', 'Go', 'Wally', null, 'M', '4179511');


insert into product
values ('201', 'SODIMM DDR3 2GB 1333Mhz Kingston', 'C', 595.00, 50, 10);
insert into product
values ('202', 'Seagate 2TB SV35 Series', 'C', 3795.00, 10, 5);
insert into product
values ('203', 'A4tech Optical Mouse', 'B', 495.00, 100, 20);
insert into product
values ('204', 'Epson FX-2175 Dot-Matrix Printer', 'A', 19000.00, 6, 2);
insert into product
values ('205', 'HP LaserJet 1102 Printer', 'A', 4195.00, 5, 1);
insert into product
values ('206', 'LED 23" Acer S230HL Wide', 'A', 6995.00, 12, 3);
insert into product
values ('207', 'Epson EB-S18 3000 Lumes', 'A', 18495.00, 3, 1);
insert into product
values ('208', 'INTEX USB Keyboard', 'B', 250.00, 100, 20);
insert into product
values ('209', '16 GB Flash Sandisk', 'C', 350.00, 5, 2);
insert into product
values ('210', 'ASUS VANGUARD B85 Motherboard', 'D', 4695.00, 5, 2);


insert into orderheader
values ('301', '2018-10-12', '104', '2018-10-15');
insert into orderheader
values ('302', '2018-10-12', '101', '2018-10-17');
insert into orderheader
values ('303', '2018-10-25', '102', '2018-10-27');
insert into orderheader
values ('304', '2018-11-07', '101', '2018-11-11');
insert into orderheader
values ('305', '2018-11-09', '103', '2018-11-12');
insert into orderheader
values ('306', '2018-11-15', '104', '2018-11-20');


insert into orderdetail
values ('301', '205', 3, 4000.00);
insert into orderdetail
values ('301', '209', 20, 375.00);
insert into orderdetail
values ('302', '207', 5, 18495.00);
insert into orderdetail
values ('303', '209', 50, 300.00);
insert into orderdetail
values ('303', '203', 100, 500.00);
insert into orderdetail
values ('303', '201', 500, 590.00);
insert into orderdetail
values ('304', '202', 10, 3750.00);
insert into orderdetail
values ('304', '203', 25, 500.00);
insert into orderdetail
values ('305', '206', 20, 6900.00);
insert into orderdetail
values ('305', '203', 20, 500.00);
insert into orderdetail
values ('305', '207', 2, 18495.00);
insert into orderdetail
values ('306', '210', 12, 4650.00);
insert into orderdetail
values ('306', '205', 2, 4000.00);
insert into orderdetail
values ('306', '201', 25, 590.00);


select * from customer;
select * from orderheader;
select * from orderdetail;
select * from product;

-- List of all male customers
select * from customer where custGender='M';

-- Products priced between 2000 and 25000 inclusive
select * from product where uprice>=2000 and uprice<=25000;
select * from product where uprice between 2000 and 25000;

-- Name of products that belong to categories 'A', 'B', or 'D'.
-- Sort the list according to product name in ascending order
select prodname "Name of Product" from product where category='A' or category='B' or  category='D'
order by prodname;
select prodname "Name of Product" from product where category in ('A', 'B', 'D')
order by prodname;

-- Customers who have no contact numbers.
select concat(custfirstname," ",custlastname) "Name of Customer" from customer
where contact is null;

-- Customers whose first name starts with letter 'N'
select concat(custfirstname," ",custlastname) "Name of Customer" from customer
where custfirstname like 'N%';

-- Customers whose address contains the word 'Cebu'
select * from customer where custaddress like '%cebu%';

-- How many orders are there for each cusotmer ID?
select custID, count(*) "Count of Orders" from orderheader
group by custid;

-- How many orders are there for each cusotmer ID?
-- Include only those customers who placed more than one order
select custID, count(*) "Count of Orders" from orderheader
group by custid having count(*)>1;

