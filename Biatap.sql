create database if not exists Biatap;
   use Biatap;
create  table danhsach(
   id int,
   Ten varchar(50),
   tuoi int,
   qty float,
   primary key (id)
);
insert into danhsach values (1,'Vinh',18,150000);
insert into danhsach values (2,'Trang',18,130000);
insert into danhsach values (3,'Duc',18,100000);
insert into danhsach values (4,'Duong',17,120000);

select * from danhsach;