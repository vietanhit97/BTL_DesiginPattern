create database BTL_DP;
go 
use BTL_DP;
go 
create table Category (
	id int PRIMARY KEY,
	name nvarchar(50),
	status varchar(20) ,

)
go
create table Product(
	id nvarchar(50) PRIMARY KEY,
	name nvarchar(50),
	price float ,
	categoryId int FOREIGN KEY REFERENCES CATEGORY(ID),
	status varchar(20),
)