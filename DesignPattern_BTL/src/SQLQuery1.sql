create database BTL_DP;
go 
use BTL_DP;
go 
create table Category (
	id int identity,
	name nvarchar(50),
	status tinyint default(0),
	PRIMARY KEY (id)
)
go
create table Product(
	id nvarchar(50),
	name nvarchar(50),
	price float ,
	status tinyint default(0),
	categoryId int ,
	primary key (id),
	FOREIGN KEY (categoryId) REFERENCES Category(id),
)