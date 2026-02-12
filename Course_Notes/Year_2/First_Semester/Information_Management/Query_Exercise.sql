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


-- ------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------
-- 1. What orders were delivered 3 days after they were ordered?
select 
  orderID "ID of Order",
  date_format(orderDate, '%Y-%m-%d') "Date of Order",
  date_format(deliveryDate, '%Y-%m-%d') "Date of Delivery"
from orderheader
where datediff(deliveryDate, orderDate) = 3;

-- ------------------------------------------------------------------------------------------------------------------------------
-- 2. How many products are there in each category? Sort the list according to the count of products in descending order.
select
	category "Product Category",
    count(*) "Count of Products"
from product
group by category
order by count(*) desc;

-- ------------------------------------------------------------------------------------------------------------------------------
-- 3. How many male and female customers don't have a contact number? Sort the list according to gender in ascending order.
select
	custGender "Gender",
    COUNT(*) "Count of Customers with no Contact" 
from customer
WHERE contact IS NULL OR contact = ''
group by custGender
order by custGender asc;

-- ------------------------------------------------------------------------------------------------------------------------------
-- 4. What is the total amount of each order? Sort the list according to total amount in ascending order.
select
	orderID "Order ID",
    sum(price * qtyOrdered) "Total Amount"
from orderdetail
group by orderID
order by sum(price * qtyOrdered) asc;

-- ------------------------------------------------------------------------------------------------------------------------------
-- 5. What is the customer ID of customers who ordered more than once?
select
	custID "Customer ID"
from orderheader
group by custID
having count(*) > 1;
-- ------------------------------------------------------------------------------------------------------------------------------
-- 6. How many orders were delivered on October 2018?
select
	count(*) "Count of Oders"
from orderheader
where year(deliveryDate) = 2018 and month(deliveryDate) = 10;

-- ------------------------------------------------------------------------------------------------------------------------------
-- 7. What is the expected sales if all products in the stock were ordered or sold?
select 
	format(sum(qtyInStock * uPrice), 2)  "Expected Total Sales"
from product;

-- ------------------------------------------------------------------------------------------------------------------------------
